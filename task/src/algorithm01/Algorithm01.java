package algorithm01;
/**
 * This is the main class for task 01.
 * The graph is input as a single String in form of an array of (parent,child) pairs.
 * 
 */

/**
 * @author pranj
 *
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import common.Graph;
import common.GraphInput;


public class Algorithm01 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
			
		try {
			System.out.println("Enter the graph as string:(e.x. {{10,3},{2,3},{3,6}})");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			var parentChildPairs = reader.readLine();
			System.out.println("Entered Input Graph : " + parentChildPairs);
			var graphInput = new GraphInput(parentChildPairs,"");
			graphInput = graphInput.processInput(graphInput);
			var graph = new Graph();
			graph = graph.generateGraph(graphInput.getParentChildPairs());
			graph.countNumberOfParents();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
