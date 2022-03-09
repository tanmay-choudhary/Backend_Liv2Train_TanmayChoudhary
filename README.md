# Backend_Liv2Train_TanmayChoudhary
made an MVP for a registry for Govt funded Training Centers with the following minimum requirements. In the MVP,I had created a Spring project with support for two APIs

please take pull of live2train branch.

1.I have used ODM, db and other configuration for .properties file :- server.port = 9090 spring.data.mongodb.uri=mongodb://localhost:27017/test

2.use mvn clean install to load all the dependencies.

3.use mvn spring-boot:run to start the project.

4.use http://localhost:9090/saveCenter for saving a center in db. sample form collection:- "centerName" : "tanmay", "centerCode" : "123456789123", "address" : { "detailedAddress" : "abc", "city" : "s", "pinCode" : "000000", "state" : "mp" }, "studentCapacity" : "9", "coursesOffered" : ["1","2"], "contactEmail" : "a1@gmail.com", "contactPhone" : "826945495"

5.use http://localhost:9090/getCenter for getting centers.
