package br.com.sinergiavirtual.algorithms.graph;

public class GraphOfNodes<T> {

    private Node<T> vertexNode;

    public GraphOfNodes(Node<T> vertexNode) {
        this.vertexNode = vertexNode;
    }

    public Node<T> getVertexNode() {
        return vertexNode;
    }
}