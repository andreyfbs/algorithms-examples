package br.com.sinergiavirtual.algorithms.graph;

import java.util.Set;

public class GraphDFS<T> {

    private GraphOfNodes<T> graph;

    private GraphDFSStrategy<T> graphDFSStrategy;

    public GraphDFS(GraphOfNodes<T> graph, GraphDFSStrategy<T> graphDFSStrategy) {
        this.graph = graph;
        this.graphDFSStrategy = graphDFSStrategy;
    }

    public Set<GraphNode> search() {

        return graphDFSStrategy.search(graph.getVertexGraphNode());

    }

}

/*
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
*/
