package br.com.sinergiavirtual.algorithms.graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * In the iterative approach: You first insert all the elements into the stack - and then handle the head of the stack [which is the last node inserted] - thus the first node you handle is the last child.
 * In the recursive approach: You handle each node when you see it. Thus the first node you handle is the first child.
 *
 */
public class GraphDFSRecursiveStrategy<T> implements GraphDFSStrategy {

    public Set<GraphNode> search(GraphNode vertex) {

        Set<GraphNode> hasVisitedSet = new LinkedHashSet<>();

        Deque<GraphNode> dfsStack = new ArrayDeque<>();

        dfsStack.push(vertex);

        search(dfsStack, hasVisitedSet);

        return hasVisitedSet;

    }

    private void search(Deque<GraphNode> stack, Set<GraphNode> pathVisited) {

        System.out.println("Stack: " + stack + "\t");

        if (stack.isEmpty()) {
            return;
        }

        GraphNode topGraphNode = stack.pop();
        pathVisited.add(topGraphNode);

        for (Iterator<GraphNode> iter = topGraphNode.getNodesConnections().iterator(); iter.hasNext(); ) {

            GraphNode graphNodeFriend = iter.next();

            if (!pathVisited.contains(graphNodeFriend)) {
                stack.push(graphNodeFriend);
            }

        }

        search(stack, pathVisited);

    }
}