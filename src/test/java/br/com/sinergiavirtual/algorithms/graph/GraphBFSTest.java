package br.com.sinergiavirtual.algorithms.graph;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GraphBFSTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void search() throws Exception {

        // Arrange Parameter
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

        GraphNode<Integer> graphNode8 = new GraphNode<>(8, new LinkedHashSet<>());
        graphNode8.addConnection(graphNode3);
        graphNode3.addConnection(graphNode8);

        graphNode8.addConnection(graphNode7);
        graphNode7.addConnection(graphNode8);

        GraphOfNodes<Integer> graphOfNodes = new GraphOfNodes<>(graphNode1);
        GraphDFS<Integer> graphDFS = new GraphDFS<>(graphOfNodes, new GraphDFSRecursiveStrategy<>());

        // Arrange
        final LinkedHashSet<GraphNode> graphNodeExpected = new LinkedHashSet<>();
        graphNodeExpected.add(graphNode1);
        graphNodeExpected.add(graphNode2);
        graphNodeExpected.add(graphNode4);
        graphNodeExpected.add(graphNode7);
        graphNodeExpected.add(graphNode8);
        graphNodeExpected.add(graphNode3);
        graphNodeExpected.add(graphNode6);
        graphNodeExpected.add(graphNode5);

        // Act
        Set<GraphNode> dfsPath = graphDFS.search();

        // Tranform to List to do the Assert with Order
        List<GraphNode> dfsPathReturned = dfsPath.stream().collect(Collectors.toList());
        List<GraphNode> dfsPathExpected = graphNodeExpected.stream().collect(Collectors.toList());

        // Print
        dfsPathReturned.forEach(node -> System.out.print(node + ", "));

        // Assert
        Assert.assertThat(dfsPathReturned, Matchers.equalTo(dfsPathExpected));

    }
}