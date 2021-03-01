# Task 03: REST API with SPRING BOOT

## Intro

* This project contains source code for implementing the REST API with Spring Boot. The service provides the results for tasks implemented in algorithms 1 and 2.

## Requirements 
 To run the application, the following are needed:
* Java 11 or higher. 
* Maven 3+. 
* Spring Boot 2.4.3.
* API is tested on windows 10

## Getting started
 The source code for the API is available at `jbu-1613587791\task_algorithm03\restservice`.  

### Package and File Description
All the files are present in `src\main\java\`

Folder `algorithm01` contains files for task 01.
Folder `algorithm02` contains files for task 02.
Folder `GraphUtilities` contains files for common files for graph creation and exception handling.

File `TaskController.java` handles the routing of the api requests.
File `RestserviceApplication.java` is the main file for launching the application.

## How to launch the app?
To run the application,

Navigate to restservice directory using `cd jbu-1613587791\task_algorithm03\restservice`
Run `./mvnw spring-boot:run` via terminal

## Sending requests to the API

A chrome extension [Postman](https://chrome.google.com/webstore/detail/postman/fhbjgbiflinjbdggehcddcbncdddomop?hl=en) is used for sending API requests.
Data is sent using Post requests to the API. The input is a json object with 2 fields `inputArray` and `nodePair`. The `inputArray` is the graph input that consists of an array of (parent,child) pairs, which is passed as string to the API. The `nodePair` is pair of two nodes present in the graph that is used to identify if they share common ancestor.

For Task 1, the API url is `http://localhost:8080/algorithm01`

A sample request is shown in figure below. Only `inputArray` field is required and `nodePair` is sent as empty string. The API returns 2 lists `Zero parent` and  `One parent`that specifies number of nodes having no parent and one parent respectively.
```
	{
		"inputArray": "{{10, 3}, {2, 3},{3, 6}, { 5, 6},{5, 7},{4, 5},{4, 8},{8, 9}}",
		"nodePair": ""
	}

```
  <img src="/task_algorithm03/screenshots/task01.JPG" width="100%" />
</p>

For Task 2, the API url is `http://localhost:8080/algorithm02`. Both `inputArray` field as well as `nodePair` are required. The API returns boolean value that specifies if the nodes in `nodePair` share at least one common ancestor.

A sample request is shown in figure below, 
```
{
	"inputArray": "{{10, 3}, {2, 3},{3, 6}, { 5, 6},{5, 7},{4, 5},{4, 8},{8, 9}}",
	"nodePair": "3,8"
}
```
<p float="center">
  <img src="/task_algorithm03/screenshots/task02.JPG" width="100%" />
</p>
