# XM

# Short description
This repository contains setup for test automation of XM web application.
Following tools are use:
chrome, java 21, selenium 4, cucumber, maven, spring framework, assertJ, lombok

# How to run tests
Test feature file is stored in \resources\features directory.
I can be run wit command line with following commands:

a) Full screen test:
```sh
mvn clean verify -Dspring.profiles.active=chromeFullScreen   
```

b) Medium resolution (1024x768) test:
```sh
mvn clean verify -Dspring.profiles.active=chromeMediumResolution   
```

c) Low resolution (800x600) test:
```sh
mvn clean verify -Dspring.profiles.active=chromeLowResolution   
```

# Selenium drivers update
Selenium drivers are stored in \resources\drivers directory.
Used chromedriver (v. 125.0.6422.141) compatible with macOS (mac-x_64), if you need to run test with other setup , please replace
chromedriver with compatible version. The same for web browsers versions.

# Test reports
Test reports are generated after each test run and are stored in
\target\cucumber-report\cucumber.html
If test fails, cucumber reports shows assertion stacktrace and screenshot.
Screenshot are taken only for failed tests.