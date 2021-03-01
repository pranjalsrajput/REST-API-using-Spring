package com.rest.restservice.algorithm01;
/**
 * 
 */

import com.rest.restservice.GraphUtilities.Graph;
import com.rest.restservice.GraphUtilities.GraphInput;

/**
 * @author pranj
 *
 */
public class Algorithm01Main {

	/**
	 * @param args
	 */
	public String main(GraphInput graphInput) {
		// TODO Auto-generated method stub
		// Java 
//		int[][] parentChildPairs = new int[][] {
//		    {10, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7},
//		    {4, 5}, {4, 8}, {8, 9}
//		};
		
		var result = "";
		try {
			var parentChildPairs= graphInput.getParentChildPairs();
			var graph = new Graph();
			graph = graph.generateGraph(parentChildPairs);
			result = graph.countNumberOfParents().toString();
			System.out.println(result);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
		
	}

}
