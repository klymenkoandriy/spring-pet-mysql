# spring-pet-mysql
**Experimental project to try Spring, SpringBoot, SpringData, Docker, MySQL.**

### **Deployment and start using Docker Compose**
- From your project directory, start up your application by running:

        docker-compose up --build -d

### Default properties
**_Database access_**
- **name**      : petdata
- **host** :
    - (external docker access) : 192.168.99.100
    - (internal docker access) : mysql
- **port**      : 3306
- **user**      : pet-user
- **password**  : 123


### **Custom properties**

**_Database parameters in application properties_**

If you want to change default Database properties, set them in the command line or in the 'application.properties' file.

If application is started in Docker and you use command line parameters, you should set them in the 'Docker' file.

To change the path to the database, change the properties 'spring.datasource.url', 'spring.datasource.username', 'spring.datasource.password'.

   - Example for using an external DB server ('dbname' - schema name): 
    
            spring.datasource.url=jdbc:mysql://111.222.333.444:3306/dbname?useSSL=false

   - Example for a local DB and application: 

            -Dspring.datasource.url=jdbc:mysql://localhost:3306/petdata?useSSL=false -Dspring.datasource.username=pet-user -Dspring.datasource.password=123

**_Database parameters in Docker_**

To change the DB access parameters, set them in the 'docker-compose.yml' file.

   - Example:
           
            environment:
              - MYSQL_ROOT_PASSWORD=AAA
              - MYSQL_DATABASE=dbname
              - MYSQL_USER=some-user
              - MYSQL_PASSWORD=BBB


### **Performance improvement**

You should use Apache Portable Runtime (APR) based Native library for Tomcat in a production environment.
See more information on
    
    http://tomcat.apache.org/tomcat-7.0-doc/apr.html
    http://tomcat.apache.org/native-doc/

If you use Windows, add the library path:

    -Djava.library.path="./lib/x64"

### **Useful docker commands**:
**Show all containers**:
    docker ps -a

**Show running containers**:
    docker ps

**Stop running container**:
    docker stop <id>

**Stop all running containers**:
    docker stop $(docker ps -a -q)

**Start container**:
    docker start <id>

**Remove container**:
    docker rm <id>

**Remove all containers**:
    docker rm $(docker ps -a -q)
        
**Show all images**:
    docker images

**Remove image**:
    docker rmi <id>

**Remove unused data (containers, networks, images)**:
    docker system prune -a -f

### **REST API**
**_CRUD operations for materialrequest entity._**

- MaterialRequest entity fields:

        id              : Long
        requestNumber   : Integer
        customerName    : String
        priority        : Integer
        invoice         : String
    
- Root endpoint:

        /materialrequest


- **GET** (type JSON):

        /get 
            Returns all entities.
        
        /get/{id}
            Returns entitiy by id.
        
        /getByCustomerName?customerName={customer Name}
            Returns entities with specified customer name.
        
        /getByInvoice?invoice={invoice}
            Returns entities with specified invoice.

- **POST** (type JSON):

        /save
            Saves the entity and returns it.
            If the id parameter is missing, it will be generated automatically.
        
            Example:
                {
                    "requestNumber": 2,
                    "customerName": "JD",
                    "priority": 4,
                    "invoice": "A51"
                }

        
- **DELETE**

        /delete/{id}
            Deletes the entity with the specified id.

        Example:
            http://192.168.99.100:8080/materialrequest/get
        
