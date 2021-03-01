/**
 * This is the main class for task 02.
 * The graph is input as a single String in form of an array of (parent,child) pairs.
 * 
 */

/**
 * @author pranj
 *
 */
package algorithm02;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import common.Graph;
import common.GraphInput;
import common.GraphTraversal;

public class Algorithm02 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			System.out.println("Enter the graph as string:(e.x. {{10,3},{2,3},{3,6}})");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			var parentChildPairs = reader.readLine();
			System.out.println("Enter node pairs as string:(e.x. (\"2,3\")");
			BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
			var nodePairs = reader1.readLine();
			System.out.println("Entered Input Graph : " + parentChildPairs);
			var graphInput = new GraphInput(parentChildPairs,nodePairs);
			graphInput = graphInput.processInput(graphInput);
			var graph = new Graph();
			graph = graph.generateGraph(graphInput.getParentChildPairs());
			var graphTraversal = new GraphTraversal();
			var result = graphTraversal.checkCommonAncestors(graphInput.getTargetNodeList().get(0), graphInput.getTargetNodeList().get(1), graph);
			System.out.println(graphInput.getTargetNodeList() +" => "+ result);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
