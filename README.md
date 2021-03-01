# Java REST in Spring

A REST API is developed using spring framework. The API takes the input, and provides the results of task 1 and task 2. The two tasks are described below in details. The code and documentation for task 1 and task 2  is provided inside the `task` folder, whereas for task 3 it is provided in `task_algorithm03` folder.

# Tasks 

## Task 1 - The Algorithm

Suppose we have some input data describing relationships between nodes over multiple generations. The input data is formatted as a list of 
(parent, child) pairs, where each is assigned a unique integer 
identifier.

For example, in this diagram, 3 is a child of 10 and 2, and 5 is a child of 4:

```            
10  2   4
 \ /   / \
  3   5   8
   \ / \   \
    6   7   9
```

Sample graph as input data

```java
// Java 
int[][] parentChildPairs = new int[][] {
    {10, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7},
    {4, 5}, {4, 8}, {8, 9}
};
```

The main task is to take this data as input and return collections:

* one containing all individuals with zero known parents, and 
* one containing all individuals with exactly one known parent.

Sample result for the sample graph

```
Zero parents: 10, 2, 4
One parent: 5, 7, 8, 9
```


###  Requirments

* Output order is irrelevant.
* The IDs are not guaranteed to be contiguous.
* The input is not necessarily a connected graph. There may be >3 generations.
* No node in the input set will have more than two parents, nor will there be duplicate entries.
* No node in the input is their parent.


## Task 2 - Complex relationships

Based on Task 1, check that if any two given individuals in the dataset share at least one known ancestor.


Example based on the sample graph of Task 1 two nodes input:
```
[3, 8] => false
[5, 8] => true
[6, 8] => true
```

## Task 3 - REST with Spring

The task is to develop a REST service that provides Task 1 and Task 2 via an API. Given an input graph, the application must provide the result for Task 1 and Task 2 via API. For Task 2 it shall take user input (for the node pair).