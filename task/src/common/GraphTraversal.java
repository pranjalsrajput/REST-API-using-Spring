/**
 * This class is used to traverse the graph from a given node.
 */

/**
 * @author pranj
 *
 */
package common;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;


public class GraphTraversal {

	public List<Node> traverseNodesBFS(String startNode, Graph graph) {
		var nodes = graph.getNodes();
		List<Node> listOfparents = new ArrayList<>();
		List<Node> listOfAncestors = new ArrayList<>();

		var node = nodes.get(startNode);
		if (node == null)
			return listOfAncestors;

		Set<Node> nodeVisited = new HashSet<>();

		Queue<Node> queue = new ArrayDeque<>();
		queue.add(node);

		while (!queue.isEmpty()) {
			var currentNode = queue.remove();

			if (nodeVisited.contains(currentNode)) {
				continue;
			}
			nodeVisited.add(currentNode);

			listOfparents = currentNode.getListOfParents();
			listOfAncestors.addAll(listOfparents);

			for (var ancestor : listOfAncestors) {
				if (!nodeVisited.contains(ancestor))
					queue.add(ancestor);
			}

		}

		System.out.println("List of ancestors of node " + startNode + ": " + listOfAncestors);
		return listOfAncestors;
	}

	public boolean checkCommonAncestors(String node1, String node2, Graph graph) {

		List<Node> lisOfParentsNode1 = new ArrayList<>();
		List<Node> lisOfParentsNode2 = new ArrayList<>();

		lisOfParentsNode1 = traverseNodesBFS(node1, graph);
		lisOfParentsNode2 = traverseNodesBFS(node2, graph);

		var commonAncestors = lisOfParentsNode1.stream().distinct().filter(lisOfParentsNode2::contains)
				.collect(Collectors.toSet());
		System.out.println("commonAncestors: " + commonAncestors);
		if (commonAncestors.isEmpty())
			return false;
		else
			return true;

	}
}
