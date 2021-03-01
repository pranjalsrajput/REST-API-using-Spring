package com.rest.restservice.GraphUtilities;
/**
 * 
 */

import java.util.List;
import java.util.Map;

/**
 * @author pranj
 *
 */
public interface GraphInterface {

//	Node[] getListOfAllNodes();
//	void setListOfAllNodes(Node[] listOfAllNodes);
	void addNode(String value);

	void addEdge(String source, String destination);

	void printGraph();

	Map<String, List<String>> countNumberOfParents();

	public Graph generateGraph(String[][] parentChildPairs) throws InvalidPairException;
}
