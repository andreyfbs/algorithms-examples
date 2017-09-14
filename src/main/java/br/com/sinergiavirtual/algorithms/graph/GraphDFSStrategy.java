package br.com.sinergiavirtual.algorithms.graph;

import java.util.Set;

public interface GraphDFSStrategy<T> {

    Set<GraphNode> search(GraphNode vertex);

}