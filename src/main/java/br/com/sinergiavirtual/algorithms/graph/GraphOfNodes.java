package br.com.sinergiavirtual.algorithms.graph;

public class GraphOfNodes<T> {

    private GraphNode<T> vertexGraphNode;

    public GraphOfNodes(GraphNode<T> vertexGraphNode) {
        this.vertexGraphNode = vertexGraphNode;
    }

    public GraphNode<T> getVertexGraphNode() {
        return vertexGraphNode;
    }
}