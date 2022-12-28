# CRM-Automation
BDD with Cucumber framework to perform regression testing

> run grid hub
java -jar selenium-server-standalone-3.141.59.jar -role hub -timeout 30 -browserTimeout 60

> run grid node for firefox
java -jar -Dwebdriver.firefox.driver="firefox.exe" selenium-server-standalone-3.141.59.jar -role node -hub http://localhost:4444/grid/register/ -browser "browserName=firefox,version=latest,maxInstances=7,seleniumProtocol=WebDriver" -browser "browserName=chrome,version=latest,maxInstances=7,seleniumProtocol=WebDriver"

> run grid node for chromedriver
java -jar -Dwebdriver.chrome.driver="chromedriver.exe" selenium-server-standalone-3.141.59.jar -role node -hub http://localhost:4444/grid/register/ -browser "browserName=firefox,version=latest,maxInstances=7,seleniumProtocol=WebDriver" -browser "browserName=chrome,version=latest,maxInstances=7,seleniumProtocol=WebDriver"

> run cucumber scenarios with testng listener class [TestNGClass.java]
> cucumber reports on folder /target/Spark.html
> run grid  with testng class [Grid_Runner.java] with testng.xml
> reports for testing /MyCustomExtent.html 


##check run cucumber testng parallel, is not working testng_cucumber.xml
