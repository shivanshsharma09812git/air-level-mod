@echo off
set DIRNAME=%~dp0
if "%DIRNAME%" == "" set DIRNAME=.
set APP_HOME=%DIRNAME%

set DEFAULT_JVM_OPTS=

set CLASSPATH=%APP_HOME%\gradle\wrapper\gradle-wrapper.jar

set JAVA_EXE=java.exe
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %GRADLE_OPTS% -classpath "%CLASSPATH%" org.gradle.wrapper.GradleWrapperMain %*
