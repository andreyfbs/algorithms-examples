package br.com.sinergiavirtual.algorithms.graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class GraphBFS<T> {

    private GraphOfNodes<T> graph;

    public Set<GraphNode> search(GraphNode vertex) {

        Set<GraphNode> hasVisitedSet = new LinkedHashSet<>();

        Deque<GraphNode> bfsQueue = new ArrayDeque<>();

        search(vertex, bfsQueue, hasVisitedSet);

        return hasVisitedSet;

    }

    private void search(GraphNode vertex, Deque<GraphNode> queue, Set<GraphNode> pathVisited) {

        queue.offer(vertex);

        pathVisited.add(vertex);

        System.out.println("Queue: " + queue + "\t");


        for (Iterator<GraphNode> iter = vertex.getNodesConnections().iterator(); iter.hasNext(); ) {

            GraphNode graphNodeFriend = iter.next();
            pathVisited.add(graphNodeFriend);

        }

        /*
        if (!pathVisited.contains(nodeFriend)) {
            search(nodeFriend, queue, pathVisited);
        }*/


        System.out.println("Queue: " + queue + "\t");

        queue.poll();

    }
}