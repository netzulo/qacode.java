@echo OFF
echo Iniciando servidor selenium para android
echo --------------------------------------------------
java -jar selendroid-standalone-0.17.0-with-dependencies.jar -app apks/selendroid-test-app-0.17.0.apk -port 11001
pause