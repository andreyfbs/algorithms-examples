package br.com.sinergiavirtual.algorithms.graph;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class GraphDFS<T> {

    private GraphOfNodes<T> graph;

    public Set<Node> search(Node vertex) {

        Set<Node> hasVisitedSet = new LinkedHashSet<>();

        Deque<Node> dfsStack = new ArrayDeque<>();

        search(vertex, dfsStack, hasVisitedSet);

        return hasVisitedSet;

    }

    private void search(Node vertex, Deque<Node> stack, Set<Node> pathVisited) {

        stack.push(vertex);

        pathVisited.add(vertex);

        for (Iterator<Node> iter = vertex.getNodesConnections().iterator(); iter.hasNext(); ) {

            Node nodeFriend = iter.next();

            if (!pathVisited.contains(nodeFriend)) {
                search(nodeFriend, stack, pathVisited);
            }
        }

        stack.pop();

    }
}

class NodeComparator implements Comparator<Node<Integer>> {

    public int compare(Node<Integer> node1, Node<Integer> node2) {

        //Set<Node> hasVisitedSet = new TreeSet<>((Node<Integer> node1, Node<Integer> node2) -> node1.getValue() - node2.getValue());
        //Set<Node> hasVisitedSet = new TreeSet<>(Comparator.comparing((Node<Integer> node) -> node.getValue()));

        return node1.getValue() - node2.getValue();
    }

}

class NodeComparator2 implements Comparator<Node> {

    public int compare(Node node1, Node node2) {
        return (Integer) node1.getValue() - (Integer) node2.getValue();
    }

}

