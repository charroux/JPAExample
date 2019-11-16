# JPAExample

Download or git clone the project

# build

Build it with: gradlew build

Convert the project into an Eclipse project with: gradlew eclipse

Import the project inside Eclipse: File -> Import -> General -> Existing projects into workspace

# Run
Launch the main program: https://github.com/charroux/JPAExample/blob/master/src/main/java/com/efrei/JPAExample/JpaExampleApplication.java


Open the H2 web console: http://localhost:8080/h2-console

In the login page make sure that you use jdbc:h2:mem:testdb as JDBC URL and org.h2.Driver as the Driver class.


Web Service: http://localhost:8080/cities

# Transactions management

https://github.com/charroux/JPAExample/blob/master/src/main/java/com/efrei/JPAExample/TransactionManagement.java
