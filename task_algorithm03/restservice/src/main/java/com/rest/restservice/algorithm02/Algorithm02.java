/**
 * 
 */
package com.rest.restservice.algorithm02;

import com.rest.restservice.GraphUtilities.Graph;
import com.rest.restservice.GraphUtilities.GraphInput;

/**
 * @author pranj
 *
 */
public class Algorithm02 {

	/**
	 * @param args
	 */
	public boolean main(GraphInput graphInput) {
		// TODO Auto-generated method stub
		// Java
//		int[][] parentChildPairs = new int[][] { { 10, 3 }, { 2, 3 }, { 3, 6 }, { 5, 6 }, { 5, 7 }, { 4, 5 }, { 4, 8 },
//				{ 8, 9 } };
//		var targetNodes = new ArrayList<>(Arrays.asList(3, 9));
		var result = false;

		try {
//			var graphInput = new GraphInput();
			var parentChildPairs= graphInput.getParentChildPairs();
			var graph = new Graph();
			graph = graph.generateGraph(parentChildPairs);
			var graphTraversal = new GraphTraversal();
			result = graphTraversal.checkCommonAncestors(graphInput.getTargetNodeList().get(0), graphInput.getTargetNodeList().get(1), graph);
			System.out.println(graphInput.getTargetNodeList() +" => "+ result);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;

	}

}
