## Task 1 - Result Management System

Task details :
A simple console application to add the student's marks for each semester in an engineering college. A college can have multiple departments and a department can have different subjects for each semester.

      Types of user who interact with the system,
            1) Admin -> This might be the system admin / principal. They have control over all department's data.
            2) HOD -> They have control over their departments data. Only read control.
            3) Advisors -> They have control over their class data. Only read control.
            4) Faculty -> They have read control over student's data for their subject.
            5) Student -> They have read control over their data.

---

## Prerequisites

This program was run on Ubuntu 20.04.

- C++ Libs (or) JDK Libs [Version 11+]
- C++/MySQL Connector Driver || Java/MySQL Connector Driver
- Local or Hosted MySQL Server
- VSCode or any IDE

Web Application Requires Tomcat V9 With Java 16.
Deploy using the WAR.

- Built on the Eclipse IDE.
- Local or Hosted MySQL Server.

---

## Instructions to run

### C++

```bash
  sudo apt-get install mysql-client mysql-server libmysqlcppconn-dev g++ gcc
  g++ -o Task1 Task1.cpp -lmysqlcppconn
  ./Task1
```

### Java

```bash
  sudo apt-get install default-jdk
  javac Results.java
  java -cp .:mysql-connector.jar Results
```

### Tomcat

```bash
  sudo add-apt-repository ppa:linuxuprising/java
  sudo apt-get install oracle-java16-installer
  sudo apt-get install tomcat9 tomcat9-admin
```

Now before starting the Webserver make sure you complete the below procedure

1. Make a file called **jaas.conf** in the Tomcat conf folder.
2. `sudo nano $TOMCAT_SERVER_LOCATION/conf/jaas.conf`
3. Paste the following into the file and save

```bash
WowLoginModule {
    com.security.myLoginModule required debug=true;
};
```

4. Add this to your launch flags.

> -Djava.security.auth.login.config==$CATALINA_BASE/conf/jaas.config"

---

## Schema

![Schema](https://i.imgur.com/89eKBSO.png)

---

## References

[C++ Driver](https://dev.mysql.com/doc/connector-cpp/1.1/en/connector-cpp-examples-complete-example-1.html)

[Java Driver](https://dev.mysql.com/doc/connector-j/8.0/en/connector-j-examples.html)

[Tomcat](https://linuxhint.com/install_apache_tomcat_server_ubuntu/)

[JAAS](https://www.byteslounge.com/tutorials/jaas-authentication-in-tomcat-example)
[Auth](https://docs.oracle.com/cd/E19879-01/819-3669/6n5sg7cf9/index.html)
