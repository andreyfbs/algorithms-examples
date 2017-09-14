package br.com.sinergiavirtual.algorithms.graph;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.Set;

public class GraphNode<T> {

    private T value;
    private Set<GraphNode> nodesConnections;

    public GraphNode(T value, Set<GraphNode> nodesConnections) {
        this.value = value;
        this.nodesConnections = nodesConnections;
    }

    public T getValue() {
        return value;
    }

    public Set<GraphNode> getNodesConnections() {
        return nodesConnections;
    }

    public void addConnection(GraphNode connection) {
        nodesConnections.add(connection);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        GraphNode<?> graphNode = (GraphNode<?>) o;

        return new EqualsBuilder()
                .append(value, graphNode.value)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(value)
                .toHashCode();
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder()//
                .append("Node [")//
                .append("value=")//
                .append(value)//
                .append("]");
        return builder.toString();
    }
}