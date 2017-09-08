package br.com.sinergiavirtual.algorithms.graph;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class GraphDFSTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void search() throws Exception {

        Node<Integer> node1 = new Node<>(1, new HashSet<>());

        Node<Integer> node2 = new Node<>(2, new HashSet<>());
        node2.addConnection(node1);
        node1.addConnection(node2);

        Node<Integer> node3 = new Node<>(3, new HashSet<>());
        node3.addConnection(node1);
        node1.addConnection(node3);

        Node<Integer> node4 = new Node<>(4, new HashSet<>());
        node4.addConnection(node2);
        node2.addConnection(node4);

        Node<Integer> node5 = new Node<>(5, new HashSet<>());
        node5.addConnection(node2);
        node2.addConnection(node5);

        Node<Integer> node6 = new Node<>(6, new HashSet<>());
        node6.addConnection(node3);
        node3.addConnection(node6);

        Node<Integer> node7 = new Node<>(7, new HashSet<>());
        node7.addConnection(node4);
        node4.addConnection(node7);

        Node<Integer> node8 = new Node<>(8, new HashSet<>());
        node8.addConnection(node7);
        node7.addConnection(node8);

        node8.addConnection(node3);
        node3.addConnection(node8);

        /*
        Node<Integer> node8 = new Node<>(8, new HashSet<>());
        //Node node7 = new Node(7, new TreeSet<>());
        Node<Integer> node7 = new Node<>(7, Stream.of(node8).collect(Collectors.toSet()));
        Node<Integer> node6 = new Node<>(6, new HashSet<>());
        Node<Integer> node5 = new Node<>(5, new HashSet<>());
        Node<Integer> node4 = new Node<>(4, Stream.of(node7).collect(Collectors.toSet()));
        Node<Integer> node3 = new Node<>(3, Stream.of(node6).collect(Collectors.toSet()));
        Node<Integer> node2 = new Node<>(2, Stream.of(node4, node5).collect(Collectors.toSet()));
        Node<Integer> node1 = new Node<>(1, Stream.of(node2, node3).collect(Collectors.toSet()));
        node8.addConnection(node3);
        */

        GraphOfNodes<Integer> graphOfNodes = new GraphOfNodes<>(node1);

        GraphDFS<Integer> graphDFS = new GraphDFS<>();

        Set<Node> bfsPath = graphDFS.search(graphOfNodes.getVertexNode());

        Stream.of(bfsPath).forEach(node -> System.out.print(node));

    }
}