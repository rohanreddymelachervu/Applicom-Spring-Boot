# Applicom-Spring-Boot
 Java Version - 1.8  
 Maven build  
 Server port - 9191  
 Server address - 127.0.0.1  
 Database - MySQL Database  
 Database address - 127.0.0.1  
 Database port - 3306  
 Change the username and password for database in application.properties which is under src/main/resources according to your own database.
 Run the Spring Boot app, Endpoints are  
 
 /users/address (POST) 
Sample post request for this endpoint  
![image](https://user-images.githubusercontent.com/81566132/193198548-ce9d12c9-224b-4d1e-8374-0a345e6fa1e2.png)  



/users/address (GET)  
Returns all the users with their addresses in the Database.  

(Updating user with new address information)  
/users/address (PUT)  
Puts the user if not already in database. If there in the database then updates the addresses and modifies it in the database.  

/users/address/find/{name} (GET)  
Returns user with name as {name} and their addresses from Database.  
![image](https://user-images.githubusercontent.com/81566132/193197636-e40feedc-d384-41c2-b870-b39b2d3475bc.png)
![image](https://user-images.githubusercontent.com/81566132/193197690-077e7081-6703-4f14-932b-93abcc7db000.png)
![image](https://user-images.githubusercontent.com/81566132/193197769-3525839f-1164-432f-a4c6-dd5f47067bab.png)
