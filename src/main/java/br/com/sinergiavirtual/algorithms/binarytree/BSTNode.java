package br.com.sinergiavirtual.algorithms.binarytree;

public class BSTNode {
    private Integer value;
    private BSTNode left;
    private BSTNode right;
    //private

    public BSTNode(int value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
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
                //", left=" + (left != null ? left : "NULL") +
                //", right=" + (right != null ? right: "NULL") +
                '}';
    }

}
