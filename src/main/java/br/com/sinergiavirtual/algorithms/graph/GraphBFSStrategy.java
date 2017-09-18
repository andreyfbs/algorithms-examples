package br.com.sinergiavirtual.algorithms.graph;

import java.util.Set;

public interface GraphBFSStrategy<T> {

    Set<GraphNode> search(GraphNode vertex);

}