This is free and unencumbered software released into the public domain.
___________________________________________________________________________________
###################################################################################
README for Wicket, Java EE, Spring and Fortress Security Sample
Last updated: Sep 10, 2013
___________________________________________________________________________________
###################################################################################
# Prerequisites
###################################################################################
1. Internet access to retrieve dependencies from online Maven repo.
2. Java SDK Version 7 or beyond installed to target environment
3. Maven 3 installed to target environment
___________________________________________________________________________________
###################################################################################
# Instructions for installing Fortress
###################################################################################
1. Download Fortress Quickstart package for Linux from here: http://iamfortress.org/download
2. Follow steps in README-QUICKSTART.html to install OpenLDAP, Tomcat, & Commander.  Tomcat uses
Fortress Realm (called Sentry) for container security.
3. Run the demo policy load.  This is necessary to load test users, roles and permissions to LDAP
a. copy demo-fortressproject-users.xml TO FORTRESS/ldap/setup
b. from FORTRESS root run this command:
./b.sh admin -Dparam1=ldap/setup/demo-fortressproject-users.xml
___________________________________________________________________________________
###################################################################################
# Instructions for building and running this sample
###################################################################################
1. Download package: https://github.com/shawnmckinney/wicketsecurity/archive/master.zip
2. Extract
3. Set JAVA_HOME
4. Set M2_Home
5. Run the build from the root package:
$ mvn tomcat:deploy
6. Go to this URL:
http://localhost:8080/myfortressproject
7. Use the credentials defined in demo-fortressproject-users.xml (from step installing Fortress step 3):
user1/password
user2/password
user3/password
___________________________________________________________________________________
###################################################################################
# Sample Policy with Fortress
###################################################################################
user1 can view all pages but only buttons on Page1
user2 can only view Page2 and Page2 buttons
user3 can only view Page3 and Page3 buttons