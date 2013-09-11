This is free and unencumbered software released into the public domain.
___________________________________________________________________________________
###################################################################################
README for Wicket, Java EE and Spring Security Sample
Last updated: Sep 9, 2013
___________________________________________________________________________________
###################################################################################
# Prerequisites
###################################################################################
1. Internet access to retrieve dependencies from online Maven repo.
2. Java SDK Version 7 or beyond installed to target environment
3. Maven 3 installed to target environment

___________________________________________________________________________________
###################################################################################
# Instructions for building and running the sample
###################################################################################
1. Download package: https://github.com/shawnmckinney/wicketsecurity/archive/master.zip
2. Extract
3. Set JAVA_HOME
4. Set M2_Home
5. Run the build from the root package:
$ mvn install
6. Start the Jetty Container
Classname: com.mycompany.Start
7. Go to this URL:
http://localhost:8080/myproject
8. Use the credentials defined in jetty-users.properties

___________________________________________________________________________________
###################################################################################
# Sample Policy
###################################################################################
user1 can view all pages
user2 can only view Page2
user3 can only view Page3