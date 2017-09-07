package br.com.sinergiavirtual.algorithms.binarytree;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Represents a Node of The Binary Tree
 */
public class BSTNode {

    /**
     * Value of the Node
     */
    private Integer value;

    /**
     * The left Node of the Tree
     */
    private BSTNode left;

    /**
     * The right Node of the Tree
     */
    private BSTNode right;

    public BSTNode(int value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public BSTNode getLeft() {
        return left;
    }

    public void setLeft(BSTNode left) {
        this.left = left;
    }

    public BSTNode getRight() {
        return right;
    }

    public void setRight(BSTNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "BSTNode{" +
                "value=" + value +
                '}';
    }

    public String toStringFull() {
        return "BSTNode{" +
                "value=" + value +
                ", left=" + (left != null && left.getValue() != null ? left.getValue().toString() : "") +
                ", right=" + (right != null && right.getValue() != null ? right.getValue().toString() : "") +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        BSTNode bstNode = (BSTNode) o;

        return new EqualsBuilder()
                .append(value, bstNode.value)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(value)
                .toHashCode();
    }
}
