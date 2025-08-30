#!/usr/bin/env sh

# Simplified Gradle wrapper launcher
DIR="$(cd "$(dirname "$0")" && pwd)"
exec "${DIR}/gradle/wrapper/gradle-wrapper.jar" "$@"
