
# **This repo contains tests for UI**
### UI website :   https://subscribe.stctv.com/sa-en

This Repo Has 6  Test Cases for STC TV subscription Plans , prices and currency for SA , KW and BH for both English and Arabic Language 

The FrameWork used is BDD with Java and Selenium

The Test are run on Firefox in Headless mode
and can be Run on Chrome on normal mode as the website crushes when run Chrome in Headless mode

There are currently 2 features files:
1. PricePlansAr.feature
2. PricePlansEn.feature

to test Parallel execution feature

## **RUN and CI/CD** :
 
## **Locally :**
 
**prerequisite**
1. JAVA jdk 17 or above installed in the system
2. Maven 3.8.0 or above installed in the system (used maven 3.8.6)
3. optional intellij IDE
 
**Run from command line**
1. clone project to local environment : git clone https://github.com/AhmedAlaaPhil/Assignment.git
2. navigate to project directory
3. open cmd in the project directory
4. write **mvn clean verify** and press enter
 
**Run from intellij IDE**
1. open project in intellij ID
2. run RunCucumberTests.java in src\test\java\runner file


**CircleCI**
1. navigate to the  [CircleCI](https://app.circleci.com/pipelines/github/AhmedAlaaPhil/TestCrew)
2. Click on any build to see the stages
3. Currently It is read only mood
 
**Framework Details**
1. Java Based Framework using Cucumber and TestNG 
2. Report is cucumber reporting
3. POM is used 
4. The util file have All genal classes needed

## **Point covered as in the Task Doc**

**Java**
1. Develop an effective and quality code using java
2. Use latest java programming language or stable version
3. Write Code following DRY Principle (Don’t Repeat Yourself) 
4. Follow Java naming convention & Name Class and function & variables meaningful 
5. Keep the Logic Clean & Clear and concise comments
6. Write Stable Test Suite
7. Document the Code Developed with clear comments
8. Have some examples for static & singleton class features
9. Make sure How is your code maintainable
10. Make sure How is your code flexible for changes
11. Make sure How is your code organized
**Selenium**
1. Reliable, efficient, organized cucumber test automation framework
2. Including Feature File, Step Definitions, and the Test Runner File
3. Structure and maintain the test artifacts (in a well manner)
4. Data driven & Keyword driven approach
5. Create Base class, driver manager class, Data file class (Excel manager or json file manager), driver manager, constants file, generic actions/methods etc
6. Maven for dependencies and building artifacts
7. Report feature: Cucumber default or Extent Report or Allure report
8. Report feature including - Log step actions, pass/fail status, validations to report (log info/step flows) 
9. Framework should have a feature to organize and maintain test data. 
For example, same test data can be applied to multiple test cases. 
Data driven approach on different test cases 

10. Use POM Model in Test Project 
11. Maintain Page Objects for Frequent UI changes
12. Test Should be flexible for New Changes
13. Browser configuration thru config file chrome, Firefox, edge
14. Wait principle applied thru framework general utility method for all page actions
15. Feature to flag, cluster/group, mark - Test Cases 
16. Parallel execution feature
17. Running thru Jenkins (CircleCI)
18. CI Integration Provision
19. Jenkins pipeline feature (CircleCI)
20. Readme.md file with clear explanation on framework features and commands 






