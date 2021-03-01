/**
 * Class containing input values used for
 * creating a graph. Also contains a method to
 * process the input values provided by the user.
 */
package common;


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
	
//	Method helps in processing the input provided by the user.
//	Input string is converted to a 2D array of string.
//	If number of node pairs is more than 2, an exception is thrown.
	public GraphInput processInput(GraphInput graphInput) throws NumberOfTargetNodesExceeded{
		

		var input = graphInput.getInputArray();
		input = input.replaceAll("\\s+","");
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
		
		graphInput.setParentChildPairs(output);
		System.out.println("input array: "+Arrays.deepToString(graphInput.getParentChildPairs()));
		return graphInput;
	}

}
