package br.com.sinergiavirtual.algorithms.binarytree;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

public class BST {

    private BSTNode bstNodeRoot;

    private StringBuilder treePrint = new StringBuilder();

    public BST() {
        super();
    }

    public BST(int[] bstNodes) {
        bstNodeRoot = new BSTNode(bstNodes[0]);

        for (int i = 1; i < bstNodes.length; i++) {
            fillBst(bstNodeRoot, bstNodes[i]);
        }
    }

    /**
     * Dist(n1, n2) = Dist(root, n1) + Dist(root, n2) - 2*Dist(root, lca)
     * 'n1' and 'n2' are the two given keys
     * 'root' is root of given Binary Tree.
     * 'lca' is lowest common ancestor of n1 and n2
     * Dist(n1, n2) is the distance between n1 and n2.
     */
    public int findDistanceBetweenNodes(BSTNode bstNode1, BSTNode bstNode2) {

        BSTNode[] pathRootToNode1 = findPathFromRoot(bstNode1);
        BSTNode[] pathRootToNode2 = findPathFromRoot(bstNode2);
        BSTNode bstNodeLCA = findLcaNode(bstNode1, bstNode2);

        BSTNode[] pathRootToNodeLca = findPathFromRoot(bstNodeLCA);

        System.out.println("1=" + pathRootToNode1.length + " 2=" + pathRootToNode2.length + " 3=" + pathRootToNodeLca.length);
        if (pathRootToNode1.length == 0 || pathRootToNode2.length == 0) {
            return -1;
        } else {
            return (pathRootToNode1.length - 1 + pathRootToNode2.length - 1) - (2 * (pathRootToNodeLca.length - 1));
        }
    }

    public BSTNode[] findPathFromRoot(BSTNode bstNode2) {
        Deque<BSTNode> deque = new ArrayDeque<>();
        findPathFromRoot(bstNodeRoot, bstNode2, deque);

        List<BSTNode> pathRootToNode1List = deque.stream().collect(Collectors.toList());
        Collections.reverse(pathRootToNode1List);

        return pathRootToNode1List.stream().toArray(BSTNode[]::new);
    }

    public String printBST() {
        printBST(bstNodeRoot);
        return treePrint.toString();
    }

    private BSTNode fillBst(BSTNode bstNode, int valueToAdd) {

        final BSTNode newBstNode;
        if (bstNode.getValue() > valueToAdd) {
            // left
            if (bstNode.getLeft() != null) {
                newBstNode = fillBst(bstNode.getLeft(), valueToAdd);
            } else {
                newBstNode = new BSTNode(valueToAdd);
                bstNode.setLeft(newBstNode);
            }
        } else {
            // right
            if (bstNode.getRight() != null) {
                newBstNode = fillBst(bstNode.getRight(), valueToAdd);
            } else {
                newBstNode = new BSTNode(valueToAdd);
                bstNode.setRight(newBstNode);
            }
        }
        return newBstNode;
    }

    private void printBST(BSTNode bstNodeRoot) {
        treePrint.append(bstNodeRoot.toStringFull()).append("\n").toString();

        if (bstNodeRoot.getLeft() != null) {
            printBST(bstNodeRoot.getLeft());
        }
        if (bstNodeRoot.getRight() != null) {
            printBST(bstNodeRoot.getRight());
        }
    }

    private BSTNode findLcaNode(BSTNode bstNode1, BSTNode bstNode2) {

        BSTNode[] pathRootToNode1 = findPathFromRoot(bstNode1);
        BSTNode[] pathRootToNode2 = findPathFromRoot(bstNode2);

        if (pathRootToNode1 != null && pathRootToNode2 != null) {


            for (int i = 0; i < pathRootToNode1.length && i < pathRootToNode2.length; i++) {
                if (!pathRootToNode1[i].equals(pathRootToNode2[i])) {
                    return pathRootToNode1[i - 1];
                }
            }
            return bstNodeRoot;
        }
        return null;
    }

    private boolean findPathFromRoot(BSTNode bstNode1, BSTNode bstNode2, Deque<BSTNode> pathStack) {
        //System.out.println(path);
        if (bstNode1 == null) {
            return false;
        }
        pathStack.push(bstNode1);
        if (bstNode1.getValue().equals(bstNode2.getValue())) {
            return true;
        }
        if (findPathFromRoot(bstNode1.getLeft(), bstNode2, pathStack) || findPathFromRoot(bstNode1.getRight(), bstNode2, pathStack)) {
            return true;
        }
        pathStack.pop();
        return false;
    }
}