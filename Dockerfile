FROM openjdk:8
EXPOSE 8080
ADD target/spring-boot-mysql.jar app.jar
ENTRYPOINT ["java","-Dspring.datasource.url=jdbc:mysql://mysql:3306/petdata?useSSL=false","-Dspring.datasource.username=pet-user","-Dspring.datasource.password=123","-jar","/app.jar"]
