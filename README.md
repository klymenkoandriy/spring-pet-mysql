# spring-pet-mysql
**Experimental project to try Spring, SpringBoot, SpringData, Docker, MySQL.**

You should use Apache Portable Runtime (APR) based Native library for Tomcat in a production environment.
See more information on
    
    https://tomcat.apache.org/tomcat-7.0-doc/apr.html
    http://tomcat.apache.org/native-doc/

If you use Windows, add the library path:

    -Djava.library.path="./lib/x64"

Set database properties (URL, user name and password) using the command line to start the application.

Example:

    -Dspring.datasource.url=jdbc:mysql://10.40.102.119:3306/petdata?useSSL=false -Dspring.datasource.username=pet-user -Dspring.datasource.password=123
