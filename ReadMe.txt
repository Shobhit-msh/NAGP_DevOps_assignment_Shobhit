This Project is created based on maven frameworl , selenium with java.
We are using TestNg as a testing framework , extent reports for reporting, log4j for logging purpose, and we are reading data from excel.

NOTE: For running the testcases please setup java,selenium, testng etc. on your machine first.

Below is the brief of the project:
1.)All the code is writtin in src/test/java. In which we have created base class, pages, testcases and functions for utilities.
2.)Test data(config files and excel data) is in inside src/test/resources.
3.)Reports are getting generated inside Reports folder.
4.)Logs are getting generated in log folder.
5.)Once you import the project all the dependencies will get auto downloaded since its a maven project.
6.) For checking the dependencies one can check pom.xml file.

Running the testcases:
1.)For running the testcases user can go to testrunner folder and run the .xml files based on user needs.
2.) Of user want to run the individual testcases then user can go to src/test/java/tests and can run the testcases.
3.) For running just open the file( either .xml or any test file) do a right click -> Run As ->TestNG Suite.
4.) Execution will start and all the logs will get printed in console, also logs will be there in extent report with screenshots.
5.) After execution user can go to Reports -> Current Test Results and user can find the report for current run.
6.) The next time execution takes place current report will get moved to Archive Result folder and new report will get created.
