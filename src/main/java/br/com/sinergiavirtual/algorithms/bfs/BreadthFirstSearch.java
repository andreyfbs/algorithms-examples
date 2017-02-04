package br.com.sinergiavirtual.algorithms.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BreadthFirstSearch {

    public static void main(String[] args) {

        Node node8 = new Node(8, new TreeSet<>());
        //Node node7 = new Node(7, new TreeSet<>());
        Node node7 = new Node(7, Stream.of(node8).collect(Collectors.toSet()));
        Node node6 = new Node(6, new TreeSet<>());
        Node node5 = new Node(5, new TreeSet<>());
        Node node4 = new Node(4, Stream.of(node7).collect(Collectors.toSet()));
        Node node3 = new Node(3, Stream.of(node6).collect(Collectors.toSet()));
        Node node2 = new Node(2, Stream.of(node4, node5).collect(Collectors.toSet()));
        Node node1 = new Node(1, Stream.of(node2, node3).collect(Collectors.toSet()));

        //node7.addNewNodeConnection(node1);

        Node nodeTarget = node8;
        Node nodeRoot = node1;

        Queue<Node> queue = new LinkedList<>();
        queue.add(nodeRoot);

        Set<Node> shortPathSet = new HashSet<>();
        Node nodeFounded = null;

        while (!queue.isEmpty()) {
            Node vertex = queue.poll();
            if (!vertex.isVisited())
                for (Node nodeFriend : vertex.getNodesConnections()) {

                    nodeFriend.setLastNode(vertex);

                    if (nodeFriend.equals(nodeTarget)) {
                        System.out.println("Yes:" + nodeFriend);
                        nodeFounded = nodeFriend;
                    } else {
                        System.out.println("No:" + nodeFriend);
                        if (!nodeFriend.isVisited()) {
                            queue.add(nodeFriend);
                        }
                        vertex.setVisited(true);
                    }
                }
        }

        if (nodeFounded != null) {
            Node nodeActual = nodeFounded;
            while (nodeActual.getLastNode() != null) {
                shortPathSet.add(nodeActual);
                nodeActual = nodeActual.getLastNode();
            }
            queue.clear();
        }
        System.out.println("Set short path: "+shortPathSet);
    }
}

class Node {
    private int value;
    private Node lastNode;
    private Set<Node> nodesConnections;
    private boolean visited;

    public Node(int value, Set<Node> nodesConnections) {
        this.value = value;
        this.nodesConnections = nodesConnections;
    }

    public int getValue() {
        return value;
    }

    public Set<Node> getNodesConnections() {
        return nodesConnections;
    }

    public Node getLastNode() {
        return lastNode;
    }

    public void setLastNode(Node lastNode) {
        this.lastNode = lastNode;
    }

    public void addNewNodeConnection(Node node) {
        nodesConnections.add(node);
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        return value == node.value;

    }

    @Override
    public int hashCode() {
        return value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", lastNodeValue=" + (lastNode != null ? lastNode.getValue() : "") +
                '}';
    }
}
