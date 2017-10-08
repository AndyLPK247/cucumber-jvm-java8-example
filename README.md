# cucumber-jvm-java-example
This is an example BDD test automation Project for Java using the Cucumber-JVM framework.
It contains a simple behavior scenario that performs a basic Google search.

### Purpose
This project was developed by [Automation Panda](https://www.automationpanda.com/)
to demonstrate how to use Cucumber-JVM as a BDD test framework.

### Web Driver Setup
This project uses Selenium WebDriver to interact with the Chrome web browser.
In order for the tests to work, [ChromeDriver](https://sites.google.com/a/chromium.org/chromedriver/)
must be installed on the test machine and accessible from the system PATH.
(This means that it must be accessible from the command line.)

The source code may easily be changed to work with any other web browser.
Just remember to install the required web drivers.

### Running Tests
This project uses [Maven](https://maven.apache.org/).
To run tests, simply run "mvn clean test".

### Practice Exercises
To practice BDD and automation, try the following exercises:

1. The assertion for the "results for ___ are shown" step checks only the page title.
   Add more comprehensive assertions to strengthen the test.
2. Add a new scenario to search Google for images.
3. Add a new scenario to perform Google searches directly using URL query parameters.
4. Add a new feature for basic tests against Wikipedia using a new page object class.
   * Picking a language from the home page.
   * Searching for articles.
   * Verifying that embedded links navigate to the correct articles.
   * Viewing page history.
5. Make it possible to choose the web browser using a properties file.
   Classes to read the properties file and construct the appropriate web driver
   should be put in the framework package.
6. Write a new feature for basic service-level testing.
   Use [REST Assured](http://rest-assured.io/) to hit a few endpoints from
   [JSONPlaceholder](https://jsonplaceholder.typicode.com/).
7. Create separate test runners that partition the set of features using tags.
8. Add logging to the tests with [SLF4J](https://www.slf4j.org/) or
   [Extent Reports](http://extentreports.com/).
