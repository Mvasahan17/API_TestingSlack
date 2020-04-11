# API_TestingSlack
Project name : SlackAPI channel API 

Assignment  Pre-setup :
 
● Signup for Slack API and sign in
● Generate API Token https://api.slack.com/custom-integrations/legacy-tokens
● Please refer the API Doc @ https://api.slack.com/methods

Scenario:
● Create a new Channel
● Join the newly created Channel
● Rename the Channel
● List all Channels and Validate if the Channel name has changed successfully
● Archive the Channel
● Validate if the Channel is archived successfully

Prerequisites :
  java-Eclipse-Testng-maven-postman
  
Installing and Setup :
signup for Slack API and sign in - create xyz-workspace - install app in xyz-worksapce - set-up and complete the app installation 
note the required information for verifying response ( Manual and automation )
example:- 
1.	App name : Test-pilvo
2.	workspace id : test-apispace.slack.com
3.	App id : A011RE4KLSV
4.	client id : 1069887263568.1059480666913
5.	secret id : 745b97dde168e653eb4d8d71bd9f302c

note : need to refer https://api.slack.com/methods for to perform the assignment scenario

Automating  SlackAPI channel API :

Using Java - RestAssured to automate the given assignment   - Hybrid Driven framework structure - maven - pom 
 
•	folder structure
o	src/test/java - Source Class file -Channel_Testing.java 
o	src/main/java - Test Class file - Channel_PageGenrices.java
o	data : keeping project related data files - Testdata.properties ( Property file or excel sheet )
o	test-output - maintains execution reports  and files 
o	pom.xml - add the required dependency for API_testing
o	StackWSTest.xml - Convert required main class ( Channel_Testing.java  ) into Testng class to start execution and complete testing.

Running the tests :

    Before starting the Scripting check and validate all the Scenario’s manually in Postman Tool 
    to ensure what kind of data is required , response Structure etc. 
    
    ->get token from postman and used that in project.

  src/test/java - Source Class file -Channel_Testing.java 
        Channel Testing class - contains Assignment scripts 
  src/main/java - Test Class file - Channel_PageGenrices
         re-usable and generic methods
         
  Testdata: 
  Capture token from postman to access SlackAPI worksapce and app  , 
  refer Channel Scenario methods to create , join , rename channels from https://api.slack.com/methods
  
  provide and setup the Project and environment 
  StackWSTest.xml run as testng suite.
  
  Refer the console and test-output folder to verify report( emailable report )
  
  conclusion :
         As per my understanding and knowledge about API testing , I have tried my best to understand the Assignment and its purpose to complete the Scripting . please correct me if anything wrong and give a feedback which will help me to enhance my career growth. 
  
  
  
   
  Author
  Manickavasahan.M
  
  






