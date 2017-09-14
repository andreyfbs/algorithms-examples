package br.com.sinergiavirtual.algorithms.graph;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class GraphBFSTest {

    @Test
    public void search() throws Exception {

        GraphNode<Integer> graphNode1 = new GraphNode<>(1, new HashSet<>());

        GraphNode<Integer> graphNode2 = new GraphNode<>(2, new HashSet<>());
        graphNode2.addConnection(graphNode1);
        graphNode1.addConnection(graphNode2);

        GraphNode<Integer> graphNode3 = new GraphNode<>(3, new HashSet<>());
        graphNode3.addConnection(graphNode1);
        graphNode1.addConnection(graphNode3);

        GraphNode<Integer> graphNode4 = new GraphNode<>(4, new HashSet<>());
        graphNode4.addConnection(graphNode2);
        graphNode2.addConnection(graphNode4);

        GraphNode<Integer> graphNode5 = new GraphNode<>(5, new HashSet<>());
        graphNode5.addConnection(graphNode2);
        graphNode2.addConnection(graphNode5);

        GraphNode<Integer> graphNode6 = new GraphNode<>(6, new HashSet<>());
        graphNode6.addConnection(graphNode3);
        graphNode3.addConnection(graphNode6);

        GraphNode<Integer> graphNode7 = new GraphNode<>(7, new HashSet<>());
        graphNode7.addConnection(graphNode4);
        graphNode4.addConnection(graphNode7);

        GraphNode<Integer> graphNode8 = new GraphNode<>(8, new HashSet<>());
        graphNode8.addConnection(graphNode7);
        graphNode7.addConnection(graphNode8);

        graphNode8.addConnection(graphNode3);
        graphNode3.addConnection(graphNode8);

        GraphOfNodes<Integer> graphOfNodes = new GraphOfNodes<>(graphNode1);

        GraphBFS<Integer> graphBFS = new GraphBFS<>();

        Set<GraphNode> bfsPath = graphBFS.search(graphOfNodes.getVertexGraphNode());

        Stream.of(bfsPath).forEach(node -> System.out.print(node));

    }

}