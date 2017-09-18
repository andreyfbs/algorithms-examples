package br.com.sinergiavirtual.algorithms.graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class GraphBFSRecursiveStrategy<T> implements GraphBFSStrategy {

    public Set<GraphNode> search(GraphNode vertex) {

        Set<GraphNode> hasVisitedSet = new LinkedHashSet<>();

        Deque<GraphNode> bfsStack = new ArrayDeque<>();

        bfsStack.offer(vertex);

        search(bfsStack, hasVisitedSet);

        return hasVisitedSet;

    }

    private void search(Deque<GraphNode> queue, Set<GraphNode> pathVisited) {

        System.out.println("Queue: " + queue + "\t");

        if (queue.isEmpty()) {
            return;
        }

        GraphNode topGraphNode = queue.poll();
        pathVisited.add(topGraphNode);

        for (Iterator<GraphNode> iter = topGraphNode.getNodesConnections().iterator(); iter.hasNext(); ) {

            GraphNode graphNodeFriend = iter.next();

            if (!pathVisited.contains(graphNodeFriend)) {
                queue.offer(graphNodeFriend);
            }

        }

        search(queue, pathVisited);

    }
}