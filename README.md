# JPAExample

Download or git clone the project

# Edit

Open this project inside Intellij

or

Import this project as a Gradle project inside Eclipse

# Run
Launch the main program: https://github.com/charroux/JPAExample/blob/master/src/main/java/com/efrei/JPAExample/JpaExampleApplication.java


Open the H2 web console: http://localhost:8080/h2-console

In the login page make sure that you use jdbc:h2:mem:testdb as JDBC URL and org.h2.Driver as the Driver class.


Web Service: http://localhost:8080/cities

# Transactions management

The Web Service contains a method annotated with @Transactionnal

https://github.com/charroux/JPAExample/blob/master/src/main/java/com/efrei/JPAExample/RestWebService.java

This means that the requests in the database will be cancelled is an exception occurs.