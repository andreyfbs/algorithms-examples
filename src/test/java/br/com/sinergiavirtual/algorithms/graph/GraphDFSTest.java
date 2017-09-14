package br.com.sinergiavirtual.algorithms.graph;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Stream;

public class GraphDFSTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void search() throws Exception {

        GraphNode<Integer> graphNode1 = new GraphNode<>(1, new LinkedHashSet<>());

        GraphNode<Integer> graphNode3 = new GraphNode<>(3, new LinkedHashSet<>());
        graphNode3.addConnection(graphNode1);
        graphNode1.addConnection(graphNode3);

        GraphNode<Integer> graphNode2 = new GraphNode<>(2, new LinkedHashSet<>());
        graphNode2.addConnection(graphNode1);
        graphNode1.addConnection(graphNode2);

        GraphNode<Integer> graphNode5 = new GraphNode<>(5, new LinkedHashSet<>());
        graphNode5.addConnection(graphNode2);
        graphNode2.addConnection(graphNode5);

        GraphNode<Integer> graphNode4 = new GraphNode<>(4, new LinkedHashSet<>());
        graphNode4.addConnection(graphNode2);
        graphNode2.addConnection(graphNode4);

        GraphNode<Integer> graphNode6 = new GraphNode<>(6, new LinkedHashSet<>());
        graphNode6.addConnection(graphNode3);
        graphNode3.addConnection(graphNode6);

        GraphNode<Integer> graphNode7 = new GraphNode<>(7, new LinkedHashSet<>());
        graphNode7.addConnection(graphNode4);
        graphNode4.addConnection(graphNode7);

        GraphNode<Integer> graphNode8 = new GraphNode<>(8, new HashSet<>());
        graphNode8.addConnection(graphNode3);
        graphNode3.addConnection(graphNode8);

        graphNode8.addConnection(graphNode7);
        graphNode7.addConnection(graphNode8);

        GraphOfNodes<Integer> graphOfNodes = new GraphOfNodes<>(graphNode1);

        GraphDFS<Integer> graphDFS = new GraphDFS<>(graphOfNodes, new GraphDFSRecursiveStrategy<>());

        Set<GraphNode> bfsPath = graphDFS.search();

        //Li[Node [value=1], Node [value=2], Node [value=4], Node [value=7], Node [value=8], Node [value=3], Node [value=6], Node [value=5]]

        Stream.of(bfsPath).forEach(node -> System.out.print(node));

    }
}