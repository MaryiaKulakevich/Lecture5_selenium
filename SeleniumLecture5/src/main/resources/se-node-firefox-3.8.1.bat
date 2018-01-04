:: Beginning of hub batch file
set SERVER_VERSION=3.8.1
set TASK_NAME=SeleniumServerNode3
set NODE_PORT=5558
set HUB_PORT=4444
set REGISTER_IP=localhost
set GECKO_DRIVER=%~dp0geckodriver.exe
java -jar -Dwebdriver.gecko.driver=%GECKO_DRIVER% selenium-server-standalone-%SERVER_VERSION%.jar -role node -hub http://%REGISTER_IP%:%HUB_PORT%/grid/register -browser "browserName=firefox,platform=WINDOWS" -port %NODE_PORT%
:: End of hub batch file
pause