package common;
/**
 * An interface containing methods of Graph class
 */

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

	void countNumberOfParents();

	public Graph generateGraph(String[][] parentChildPairs) throws InvalidPairException;
}
