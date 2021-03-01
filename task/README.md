# Task 01 and Task 02 Readme

## Intro

* This project contains source code for implemention of Task 1 and Task 2 using Java 11. 

## Requirements 
 * To run the application, Java 11 or higher are needed.
 * An IDE of your choice (Optional)

## Getting started
 The source code for the tasks is available at `jbu-1613587791\task\src`.  

### Package and File Description

Folder `algorithm01` contains files for task 01.
Folder `algorithm02` contains files for task 02.
Folder `common` contains common utilities files for creating graphs for task 01 and task 02.

File `common`


## How to run Task 01?

Given a graph as input, the task is to find nodes with no or one parents. The main file to run task 01 is `algorithm01\Algorithm01.java`. To execute the task, run the main method in the class `Algorithm01.java`. The graph is input as a single String in form of an array of (parent,child) pairs. Press enter to convert and generate the graph. The class method countNumberofParents() is then called that traverses the parents for each node using Breadth First Traversal and returns nodes with zero or one parent. A sample run for the task is shown in screenshot below.

<img src="/task/screenshots/algorithm01.JPG" width="60%" />


## How to run Task 02?

Given a graph and a node-pair present in the graph as input, the task is to find if the node-pair share atleast one common ancestor. The main file to run task 02 is `algorithm02\Algorithm02.java`. To execute the task, run the main method in the class `Algorithm02.java`. Similar to task 01, the graph is input as a single String in form of an array of (parent,child) pairs. Press enter and then input node-pair present in the graph as a String. Press enter again to generate the graph and find common ancestors of the node-pair. The class method checkCommonAncestors() is then called that traverses the graph to find the ancestors of specified node-pair and returns true if they have at least one common ancestor otherwise false. A sample run of the task is shown in screenshot below

<img src="/task/screenshots/algorithm02.JPG" width="60%" />
