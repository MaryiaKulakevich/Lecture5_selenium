:: Beginning of hub batch file
set SERVER_VERSION=3.8.1
set TASK_NAME=SeleniumServerNode1
set NODE_PORT=5557
set HUB_PORT=4444
set REGISTER_IP=localhost
set CHROME_DRIVER=%~dp0chromedriver.exe
java -Dwebdriver.chrome.driver=%CHROME_DRIVER% -jar selenium-server-standalone-%SERVER_VERSION%.jar -role node -hub http://%REGISTER_IP%:%HUB_PORT%/grid/register -browser "browserName=chrome,maxInstances=3,platform=WINDOWS" -port %NODE_PORT%
:: End of hub batch file
pause