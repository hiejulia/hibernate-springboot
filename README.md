# hibernate-springboot 
Project overview : Company management hub 
+ Company manager web app that manage all the workflow from employee  


### Stack using 
+ Spring boot 
+ REST
+ Hibernate ORM 
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



### Run the project
+ Run the Redis server :`redis-server` (local)
+ Run the ElasticSearch server : `brew services start elasticsearch` (local)
 






### API docs 
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
    
+ Course : Company / Each department offer course for employee to take to learn 
    + GET `v1/api/courses`: get all courses
    + GET `v1/api/courses/id` : get one course by id  
    + POST `v1/api/courses/` : create new course with category 
    + PUT `v1/api/courses/id`: edit one course with category
    + DELETE `v1/api/courses/id` : delete one course by id
    
+ Project : Department post their new/ incoming/ongoing projects 

+ Meetup


+ Event : Each department have events (tech event, party event, travel event, sports event ) for company 

+ User : Employee 
    
    
    
+ Meeting : 
    
+ Query ElasticSearch database 
    + `locahost:9200/category/category/_search?pretty=true`    
    
#### Some optimization for this project
+ Maven build time : 
    + https://zeroturnaround.com/rebellabs/your-maven-build-is-slow-speed-it-up/
    + https://stackoverflow.com/questions/32368976/ways-to-make-maven-build-faster
    + 
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
#### Reference
+ ElasticSearch book 
+ Redis book
+ Spring design pattern book