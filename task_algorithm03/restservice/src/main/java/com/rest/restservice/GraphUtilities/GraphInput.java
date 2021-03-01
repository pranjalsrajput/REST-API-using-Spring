/**
 * 
 */
package com.rest.restservice.GraphUtilities;


import java.util.Arrays;
import java.util.List;

/**
 * @author pranj
 *
 */
public class GraphInput {
	
	private String inputArray;	
	private String nodePair;
	private String[][] parentChildPairs;
	private List<String> targetNodeList;
	
	public GraphInput() {
		super();
		// TODO Auto-generated constructor stub
	}


	public GraphInput(String inputArray, String nodePair) {
		super();
		this.inputArray = inputArray;
		this.nodePair = nodePair;
	}


	public String getInputArray() {
		return inputArray;
	}


	public void setInputArray(String inputArray) {
		this.inputArray = inputArray;
	}


	public String getNodePair() {
		return nodePair;
	}


	public void setNodePair(String nodePair) {
		this.nodePair = nodePair;
	}


	public String[][] getParentChildPairs() {
		return parentChildPairs;
	}


	public void setParentChildPairs(String[][] parentChildPairs) {
		this.parentChildPairs = parentChildPairs;
	}
	
	public List<String> getTargetNodeList() {
		return targetNodeList;
	}


	public void setTargetNodeList(List<String> targetNodeList) {
		this.targetNodeList = targetNodeList;
	}
	
	public GraphInput processInput(GraphInput graphInput) throws NumberOfTargetNodesExceeded{
		
//		String input = "{{10,3},{5,3},{3,2}}";
//		GraphConstants constants = new GraphConstants();
//		constants.setGraphValues(input);
		var input = graphInput.getInputArray();
		input = input.replaceAll("\\s+","");
//		var graphInput = new GraphInput();
		List<String> nodeList = Arrays.asList(graphInput.getNodePair().split(","));
		if(nodeList.size()>2) {
			throw new NumberOfTargetNodesExceeded("Number of target nodes more than 2");
		}
		else {
			graphInput.setTargetNodeList(nodeList);
		}
		
		String[][] output = Arrays.stream(input.substring(2, input.length() - 2).split("\\},\\{"))
				.map(e -> Arrays.stream(e.split("\\s*,\\s*"))
				.toArray(String[]::new)).toArray(String[][]::new);
		

//		int[][] output1 =Arrays.stream(input.substring(2, input.length() - 2).split("\\},\\{")).map(r
//		        -> // It transforms a String 'r' into a int[]
//		        Arrays.stream(r.split("\\s*,\\s*")).mapToInt(Integer::parseInt).toArray()
//		// It transforms a Stream of int[] into int [][]
//		).toArray(int[][]::new);
		
		graphInput.setParentChildPairs(output);
//		System.out.println("input array: "+Arrays.deepToString(output));
		System.out.println("input array: "+Arrays.deepToString(graphInput.getParentChildPairs()));
		return graphInput;
	}

}
