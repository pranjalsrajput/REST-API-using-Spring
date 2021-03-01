package common;


/**
 * Class containing methods to create a graph
 * Nodes and edges between any two nodes are added.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph implements GraphInterface {

	private Map<String, Node> nodes = new HashMap<>();

	/**
	 * @return the nodes
	 */
	public Map<String, Node> getNodes() {
		return nodes;
	}

	private Map<Node, List<Node>> adjacencyList = new HashMap<>();

	/**
	 * @return the adjacencyList
	 */
	public Map<Node, List<Node>> getAdjacencyList() {
		return adjacencyList;
	}

	@Override
	public void addNode(String value) {
		var node = new Node(value, new ArrayList<>(), new ArrayList<>());
		nodes.putIfAbsent(value, node);
		adjacencyList.putIfAbsent(node, new ArrayList<>());
	}

	@Override
	public void addEdge(String source, String destination) {
		var sourceNode = nodes.get(source);
		if (sourceNode == null)
			throw new IllegalArgumentException();

		var destinationNode = nodes.get(destination);
		if (destinationNode == null)
			throw new IllegalArgumentException();

		adjacencyList.get(sourceNode).add(destinationNode);
		sourceNode.getListOfChildren().add(destinationNode);
		adjacencyList.get(destinationNode).add(sourceNode);
		if (destinationNode.getListOfParents().size() == 2) {
			System.out.println("Cannot have more than two parents of node " + destinationNode);
			throw new IndexOutOfBoundsException();
		} else {
			destinationNode.getListOfParents().add(sourceNode);
		}

	}

	@Override
	public void printGraph() {
		for (var source : adjacencyList.keySet()) {
			var destinations = adjacencyList.get(source);
			if (!destinations.isEmpty())
				System.out.println(source + " is connected to " + destinations);
		}

		for (var source : nodes.keySet()) {
			System.out.println("Node " + nodes.get(source).getValue() + ": Parents: "
					+ nodes.get(source).getListOfParents() + " Children: " + nodes.get(source).getListOfChildren());
		}
	}

	@Override
	public void countNumberOfParents() {
		List<String> zeroParentList = new ArrayList<>();
		List<String> oneParentList = new ArrayList<>();

		for (var source : nodes.keySet()) {
			if (nodes.get(source).getListOfParents().size() == 0) {
				zeroParentList.add(nodes.get(source).getValue());
			} else if (nodes.get(source).getListOfParents().size() == 1) {
				oneParentList.add(nodes.get(source).getValue());
			}
		}
		System.out.println("Zero parent: " + zeroParentList);
		System.out.println("One parent: " + oneParentList);
	}

	@Override
	public Graph generateGraph(String[][] parentChildPairs) throws InvalidPairException {
		var graph = new Graph();
		for (var pair : parentChildPairs) {
//			var parent = Integer.toString(pair[0]);
//			var child = Integer.toString(pair[1]);
			var parent = pair[0];
			var child = pair[1];
			if (parent.equals(child)) {
				throw new InvalidPairException("Invalid Pair (" + parent + "," + child + ")");
			}
			graph.addNode(parent);
			graph.addNode(child);
			graph.addEdge(parent, child);

		}
		graph.printGraph();
		return graph;
//		graph.countNumberOfParents();
	}

}
