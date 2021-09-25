# SearchEngine_Assignment


This repository is a framework for automating google search engine. 

This framework is using WebDriverManager for setting-up drivers instead of explicitly providing the browser drivers. 

To execute use 'testng_google_regression.xml' which is placed inside /src/test/java/resources/testrunners/

Under Build folder test execution report will get generated in .html format.


In this framework test data are driven from excel sheet and one test date is incorrect so that the test should fail due to this incorrect data.


On Failure same case is execute 3 time before generating the final report with screenshort attached for the failed case.



