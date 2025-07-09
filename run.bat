@echo off
setlocal

:: Clear existing instances of automated browsers (Chrome, Firefox, Edge)
echo Killing any running automated browsers...
taskkill /F /IM chrome.exe /T
taskkill /F /IM firefox.exe /T
taskkill /F /IM msedge.exe /T

:: Set environment (dev or prod)
set ENVIRONMENT=dev

:: Set browser (CHROME, FIREFOX, EDGE)
set BROWSER=CHROME

:: Check if the environment variable is passed as a parameter
if not "%1"=="" set ENVIRONMENT=%1
if not "%2"=="" set BROWSER=%2

echo Compiling and running the project with environment: %ENVIRONMENT% and browser: %BROWSER%

:: Compile the project
mvn clean install

:: Run tests based on environment and browser
if "%ENVIRONMENT%"=="dev" (
    mvn test -Pdev -Denv=DEV -Dbrowser=%BROWSER%
) else if "%ENVIRONMENT%"=="prod" (
    mvn test -Pprod -Denv=PROD -Dbrowser=%BROWSER%
) else (
    echo Invalid environment specified. Use "dev" or "prod".
    exit /b 1
)

endlocal
pause
