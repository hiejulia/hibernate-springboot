# hibernate-springboot 
Project overview : Company management hub 
+ Company manager web app that manage all the workflow from employee  


### Stack using 
+ Spring boot 
+ REST
+ Hibernate ORM 
    + NamedQuery 
    + Criteria 
    + Transaction management 
    + Hibernate search
        + Lucene index  
    + Hibernate Validator 
    + Hibernate cache : 1st level and 2nd level cache 
    + HCQL hibernate criteria query language
    + HQL query 
    + Hibernate design pattern : Data mapper pattern, Domain model pattern, lazy loading pattern, template pattern
+ Messaging with RabbitMQ      
+ JPA
+ MySQL 
+ Maven 
+ JPA
+ Tomcat 7 
+ Spring cache - EhCache - Redis
+ JMS - RabbitMQ
+ External API source : Captcha
+ ElasticSearch 
    + Sync data with MySQL database : 
+ Design pattern 
    + Spring framework 
        + Factory pattern 
        + Singleton pattern 
        + MVC pattern 
        + Builder pattern 
        + Decorator pattern 
    + Java 8 
        + Lambda expression 
        + Functional interfaces
        + Streams 
        + Filter 
+ Scheduled task - cron job run everyday at 1.am to back up MySQL database ( local instance )
+ Hibernate cache 
    + Cache structure 
        + Cache scope, First level cache, Second level cache, Query cache 
        + Cache strategies : Read only, Non strict read write, read write, transactional, object identity
        + Manage cache: remove cache entities, cache modes 
+ FTP client         
+ ActiveMQ 
### Run the project
+ Run the Redis server :`redis-server` (local)
+ Run the ElasticSearch server : `brew services start elasticsearch` (local)
+ Install and set up RabbitMQ server : 
    + Install 
    + Enable rabbitmq plugin: `rabbitmq-plugins enable rabbitmq_management --online`
    + Go to `http://localhost:15672`, login with guest/guest 
    + Start rabbitMQ server : `./rabbitmq_server-3.5.1/sbin/rabbitmq-server`
    + Add exchange : 






### API docs 
+ Employes: Keep a list of all employee in the company



+ Articles : User (Employee) create article on their profile about daily work, share useful information for other colleagues as well 
    + GET `v1/api/articles`: get all articles
    + GET `v1/api/articles/id` : get one article by id 
    + GET `v1/api/articles/get5`: get 5 articles 
    + POST `v1/api/articles/` : create new article
    + PUT `v1/api/articles/id`: edit one article
    + DELETE `v1/api/articles/id` : delete one article by id 
+ Category : Category type for course 
    + GET `v1/api/category`: get all categories
    + GET `v1/api/category/id` : get one category by id  
    + POST `v1/api/category/` : create new category
    + PUT `v1/api/category/id`: edit one category
    + DELETE `v1/api/category/id` : delete one category by id
+ Tag : Tag for post - and article 
    + GET `v1/api/tags`: get list of tags 
    + GET `v1/api/tags/{id}` : get tag by id 
    + POST `v1/api/tags` : create new tag 
    + GET `v1/api/tags/{id}/posts` : get all post by tag 
+ Course : Company / Each department offer course for employee to take to learn 
    + GET `v1/api/courses`: get all courses
    + GET `v1/api/courses/id` : get one course by id  
    + POST `v1/api/courses/` : create new course with category 
    + PUT `v1/api/courses/id`: edit one course with category
    + DELETE `v1/api/courses/id` : delete one course by id
+ Topic : topic of the course 
    + GET `/v1/api/topics` : list all topics
    + GET `/v1/api/topics/id` :get one topic by id 
    + POST `/v1/api/topics` : create new topic
    + DELETE `/v1/api/topics/id` : delete topic by id 
    + PUT `/v1/api/topics/id` : edit topic by id 
+ Project : Department post their new/ incoming/ongoing projects 

+ Meetup
    + GET `/v1/api/meetups` : get all current meetups list 
    + GET 
    + POST : `/v1/api/meetups` : create new meetup 
+ Customer 
    + GET `v1/api/customers`: get all customer
    + GET `v1/api/customers/id` : get customer by id 
    + GET `v1/api/customers/name` : get customer by name
    + POST : `v1/api/customers` : create new customer
    + DELETE : `v1/api/customers/id` : delete customer
    + PUT : `v1/api/customers/id` : edit customer

+ Event : Each department have events (tech event, party event, travel event, sports event ) for company 

+ Department
    + GET : `/v1/api/departments` : get all departments
    + GET : `/v1/api/departments/id` : get department by id 
    + POST : `/v1/api/departments`: create new department 
    + GET : `/v1/api/departments/{id}/employees`: get list all employees by department id 
    + DELETE :`/v1/api/departments/id` : delete one department by id 
    + PUT :`/v1/api/departments/id`: edit one department by id 

+ User : Employee api doc 
    + GET 
    + GET 
    + POST 
    
+ Appointment: Each user / employee can book an appointment with the appointment room  
    + GET `/v1/api/appointments` : get all current appointments from the company 
    + POST `/v1/api/appointments` : user create new appointment 
    + GET `/v1/api/appointments/users/{userId}` : get all appointment by user id 
    + GET `/v1/api/appointments/{appointmentId}`: user confirm the apppointment
    
+ File 
    + GET : `/v1/api/files` : get all files in the database
    + GET : `/v1/api/files/id` : get file by id 
    + POST : `/v1/api/files` : create new file  
    + DELETE `/v1/api/files/id` : delete file by id 
    + PUT : `/v1/api/files` : edit existing file  
+ Meeting :

+ Project Review : User will create a project review 
    + GET 

+ Book : 
    +  
    
+ Query ElasticSearch database 
    + `locahost:9200/category/category/_search?pretty=true`    
   
   
+ FTP endpoint
    + GET `/v1/api/upload` : upload file to local FTP server     
#### Some optimization for this project
+ Maven build time : 
    + https://zeroturnaround.com/rebellabs/your-maven-build-is-slow-speed-it-up/
    + https://stackoverflow.com/questions/32368976/ways-to-make-maven-build-faster
    + 
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
#### Reference
+ ElasticSearch book 
+ Redis book
+ Spring design pattern book