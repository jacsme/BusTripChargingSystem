# BusTripChargingSystem

This project is developed using Java 1.8, Spring Boot, Junit and Mockito and Maven 3.3.9. Spring Boot Framework is implemented as it will give some advantages for the setup, we don't need to setup the application server because it has its built-in appserver. I used for json as a request instead of csv, as it will give good process. Follow the below instruction and email jack.lord.hermoso@gmail.com if you have any comments and questions.

# Configuration
## Maven:
- Download and extract apache-maven-3.3.9 
- Save it to c:\apache-maven-3.3.9
## Java:
- Download Java 1.8 and save it to c:\Program Files\Java\jdk1.8.0_91
## Environment Variable:
- Setup the System Variable with the following:
	```	
	-- Variable		| Value	
	-- CATALINA_HOME   	| c:\apache-maven-3.3.9
	-- M2_HOME		| c:\apache-maven-3.3.9
	-- M2			| %M2_HOME%\bin
	-- JAVA_HOME		| c:\Program Files\Java\jdk1.8.0_91
	-- Path			| %JAVA_HOME%\bin; %M2%;  [add this at the end of the path value]
	```
## Eclipse:
- Download the latest Eclipse IDE with maven plugins [Oxygen]	
- Clone this project to your local repository, and import the project to eclipse	- Refresh the project
- Right click on the project, select properties. On the properties window, configure the Java Build Path point the JRE System Library to jdk1.8.0_91. 
- And on the Java Compiler select the version 1.8 on the drop down box.
- Make a clean and build to your local project in eclipse.
## Data:
- Data should only be persisted in memory, using simple data structures using List
## Run the program:
- Run the spring boot application, on your project right click on the BusTripApplication located in the com.bustrip package, Run As > Java Application
- The system will be ran in http://localhost:8080/BusTripCharging and it is predefined in my postman
- Download the postman from Chrome which will be used for accessing the program for integration testing. Import the predefined collection and run it, it is located in src/main/resources [BusTrip.postman_collection.json] of the project BusTripChargingSystem.

## API URL
http://localhost:8080/BusTripCharging/v1/submit/transaction
This will be saved the records to List data structure from a json formatted requestbody
Request
Headers: None
Body :
```
[{
	"Id": 1, 
	"dateTimeUTC": "2018-10-23T12:04:07.049", 
	"tapType": "ON", 
	"stopId": "Stop 1", 
	"companyId": "Company 1", 
	"busId": "Bus 37", 
	"pan": "550000555555559" 
},
{
	"Id": 2, 
	"dateTimeUTC": "2018-10-23T12:09:07.049", 
	"tapType": "OFF", 
	"stopId": "Stop 2", 
	"companyId": "Company 1", 
	"busId": "Bus 37", 
	"pan": "550000555555559"
},
{
	"Id": 3, 
	"dateTimeUTC": "2018-10-23T12:09:07.049", 
	"tapType": "ON", 
	"stopId": "Stop 1", 
	"companyId": "Company 1", 
	"busId": "Bus 37", 
	"pan": "550000555555556"
}]
Response
Body :
[
    {
        "started": [
            2018,
            10,
            23,
            12,
            4,
            7,
            49000000
        ],
        "finished": [
            2018,
            10,
            23,
            12,
            9,
            7,
            49000000
        ],
        "durationSecs": "0:5:0",
        "fromStopId": "Stop 1",
        "toStopId": "Stop 2",
        "chargeAmount": 3.25,
        "companyId": "Company 1",
        "busId": "Bus 37",
        "pan": "550000555555559",
        "status": "COMPLETED"
    },
    {
        "started": [
            2018,
            10,
            23,
            12,
            9,
            7,
            49000000
        ],
        "finished": null,
        "durationSecs": "2:20:9",
        "fromStopId": "Stop 1",
        "toStopId": null,
        "chargeAmount": 7.3,
        "companyId": "Company 1",
        "busId": "Bus 37",
        "pan": "550000555555556",
        "status": "INCOMPLETE"
    }
]
