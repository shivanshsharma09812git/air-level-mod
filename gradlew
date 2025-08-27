#!/usr/bin/env bash
set -euo pipefail

REQUIRED_JAVA_MAJOR=21
GRADLE_VERSION=8.6

java_major() {
  if ! command -v java >/dev/null 2>&1; then
    echo 0
    return
  fi
  ver=$(java -version 2>&1 | head -n1)
  maj=$(printf "%s" "$ver" | sed -n 's/.*"\?\([0-9][0-9]*\).*"/\1/p' | head -n1)
  if [ -z "$maj" ]; then
    echo 0
  else
    echo "$maj"
  fi
}

JAVA_MAJOR=$(java_major)
if [ "$JAVA_MAJOR" -lt "$REQUIRED_JAVA_MAJOR" ]; then
  echo "Java $REQUIRED_JAVA_MAJOR or newer is required. Detected Java major version: $JAVA_MAJOR"
  exit 1
fi

if command -v gradle >/dev/null 2>&1; then
  exec gradle "$@"
fi

WRAPPER_DIR=".gradle-wrapper/gradle-$GRADLE_VERSION"
BIN_PATH="$WRAPPER_DIR/bin/gradle"

if [ ! -x "$BIN_PATH" ]; then
  echo "No system gradle found. Bootstrapping Gradle $GRADLE_VERSION into $WRAPPER_DIR ..."
  mkdir -p ".gradle-wrapper"
  ZIPNAME="gradle-${GRADLE_VERSION}-bin.zip"
  URL="https://services.gradle.org/distributions/${ZIPNAME}"
  TMPZIP="$(mktemp)"
  echo "Downloading $URL ..."
  if command -v curl >/dev/null 2>&1; then
    curl -L -o "$TMPZIP" "$URL"
  elif command -v wget >/dev/null 2>&1; then
    wget -O "$TMPZIP" "$URL"
  else
    echo "curl or wget is required to download Gradle distribution."
    exit 1
  fi
  echo "Extracting to $WRAPPER_DIR ..."
  unzip -q "$TMPZIP" -d ".gradle-wrapper"
  rm -f "$TMPZIP"
fi

exec "$BIN_PATH" "$@"
