# CRM-Automation
This project is intented for education and training purposes only.

We are going to create a maven testing project to run parallel testing of feature files (Cucumber)
The scope of the project is web testing to perform actions with web elements using the Page Object Model (POM) model.
And, producing test reports using listeners for, spark, sure-fire and custom Extent.html

There are few ways to run parallel testing with Cucumber, and each one has a particular configuration with diferent goals and limitations as well. For instance:

1.- WebDriver with Junit (https://cucumber.io/docs/guides/parallel-execution)
2.- RemoteWebDriver with Junit
3.- WebDriver with TestNG and maven, set dataprovider with parallel = tue, scenarios will run in multiple threads. 
4.- RemoteWebDriver with TestNG, maven and cucumber-jvm-parallel-plugin (https://github.com/cucumber/cucumber-jvm)
5.- RemoteWebDriver with TestNG, dataprovider, AbstractTestNGCucumberTests

 
This project will use option number 5, the RemoteWebDriver will create a remote session per each scenario in each feature file.
The RemoteWebDriver will run under a grid server configuration with selenium-server-standalone.

In order to create the remote browser, follow this steps:

1.- In the main folder of the project, locate the jar files under the "lib" folder, and open 3 console / terminal windows.
 
2.- Run a server grid hub, using the bellow command:

java -jar selenium-server-standalone-3.141.59.jar -role hub -timeout 30 -browserTimeout 60

3.- Run a grid node for the browser under test, sample: firefox
java -jar -Dwebdriver.firefox.driver="firefox.exe" selenium-server-standalone-3.141.59.jar -role node -hub http://localhost:4444/grid/register/ -browser "browserName=firefox,version=latest,maxInstances=7,seleniumProtocol=WebDriver" -browser "browserName=chrome,version=latest,maxInstances=7,seleniumProtocol=WebDriver"

4.- Run a grid node for the browser under test, sample: chrome

java -jar -Dwebdriver.chrome.driver="chromedriver.exe" selenium-server-standalone-3.141.59.jar -role node -hub http://localhost:4444/grid/register/ -browser "browserName=chrome,version=latest,maxInstances=7,seleniumProtocol=WebDriver" -browser "browserName=chrome,version=latest,maxInstances=7,seleniumProtocol=WebDriver"

5.- Run cucumber scenarios, using maven. Open a console / terminal windows in the root of the project (where the pom.xml is located)

mvn install

or, from jenkins

mvn clean test


6.- Another way to run the testing, using the [TestNGClass.java] right click, run as > TestNG Class.


# Reports
> Cucumber reports on folder /target/Spark.html
> Reports using listener ITestListener interface: /MyCustomExtent.html 
> Sure-fire: /target/sure-fire

# Custom Configurations

> Under the Java class Constants, there are few settings for running the testing.
Those are: delay, headless-execution, write-to-excel-file, browser-type, and so on.

