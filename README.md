# SneakerBeast
SneakerBeast is a RESTFul API created for my CSC 435 (Web Services) course. It is heavily modeled after the existing website [StockX](http://www.stockx.com). 
StockX is an online trading platform where users can buy and sell luxury items, such as rare sneakers and designer handbags. 

## Implementation and Frameworks
This project was implmented in 4 different frameworks over the course of the semester (Java EE, Spark Java, Grails, Dropwizard). My API allows users to create an account in order to gain proper credentials.  With the proper credentials, users are able to perform actions via various HTTP methods (POST, GET, PUT, etc.), which will be reflected in the database. Error messages and credentials can be monitored using an API Development Environment (ADE) such as Postman.

## Required Tools and Technoologies
* [Spark Java](http://sparkjava.com/documentation)

* [Grails](https://grails.org/download.html)

* [Dropwizard](https://www.dropwizard.io/1.3.11/docs/getting-started.html) Loads in as a Maven Dependency. 

* [Apache Tomcat](https://tomcat.apache.org/download-80.cgi)- Please note that my project uses Tomcat 7, due to compatability errors

* [MySQL](https://dev.mysql.com/downloads/)

* [Netbeans + Apache Tomcat + Java EE](https://netbeans.org/downloads/8.0.2/). Make sure to press the "All" button, as this option will include Java EE and Apache Tomcat plugins.

* [Postman](https://www.getpostman.com/downloads/)

## System Requirements
* Java 8
* JDK version 


## Helpful Links for Setup

If you're new to top level networking concepts, I'd strongly suggest that you check out the following websites:
### Java EE Servlet API
[NTU Tutorial-](http://www.ntu.edu.sg/home/ehchua/programming/java/javaservlets.html) In-depth explainations of HTTP concpets and methods. Also contains a tutorial on how to write an API with Java EE.

## Instructions (Netbeans)
1. Clone the repository.
2. Open Netbeans.
3. Import the project (File > Open Project > Sneakerbeast).
4. Build and clean the project.
5. Run the project.
