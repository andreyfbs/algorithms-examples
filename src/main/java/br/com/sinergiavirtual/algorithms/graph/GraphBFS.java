package br.com.sinergiavirtual.algorithms.graph;

import java.util.Set;

public class GraphBFS<T> {

    private GraphOfNodes<T> graph;

    private GraphBFSStrategy<T> graphBFSStrategy;

    public GraphBFS(GraphOfNodes<T> graph, GraphBFSStrategy<T> graphBFSStrategy) {
        this.graph = graph;
        this.graphBFSStrategy = graphBFSStrategy;
    }

    public Set<GraphNode> search() {

        return graphBFSStrategy.search(graph.getVertexGraphNode());

    }

}