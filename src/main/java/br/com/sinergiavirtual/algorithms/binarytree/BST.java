package br.com.sinergiavirtual.algorithms.binarytree;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

public class BST {

    /**
     * Dist(n1, n2) = Dist(root, n1) + Dist(root, n2) - 2*Dist(root, lca)
     * 'n1' and 'n2' are the two given keys
     * 'root' is root of given Binary Tree.
     * 'lca' is lowest common ancestor of n1 and n2
     * Dist(n1, n2) is the distance between n1 and n2.
     */
    public int findDistanceBetweenNodes(BSTNode bstNodeRoot, BSTNode bstNode1, BSTNode bstNode2) {

        Deque<BSTNode> pathRootToNode1 = findPathFromRoot(bstNodeRoot, bstNode1);
        Deque<BSTNode> pathRootToNode2 = findPathFromRoot(bstNodeRoot, bstNode2);
        BSTNode BSTNodeLca = findLcaNode(bstNodeRoot, bstNode1, bstNode2);
        Deque<BSTNode> pathRootToNodeLca = findPathFromRoot(bstNodeRoot, BSTNodeLca);

        System.out.println("1=" + pathRootToNode1.size() + " 2=" + pathRootToNode2.size() + " 3=" + pathRootToNodeLca.size());
        if (pathRootToNode1.size() == 0 || pathRootToNode2.size() == 0) {
            return -1;
        } else {
            return (pathRootToNode1.size() - 1 + pathRootToNode2.size() - 1) - (2 * (pathRootToNodeLca.size() - 1));
        }
    }

    public Deque<BSTNode> findPathFromRoot(BSTNode bstNodeRoot, BSTNode bstNode2) {
        Deque<BSTNode> deque = new ArrayDeque<>();
        findPathFromRoot(bstNodeRoot, bstNode2, deque);


        return deque;
    }

    public BSTNode fillBst(BSTNode bstNode, int valueToAdd) {

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

    public void printBST(BSTNode bstNodeRoot) {
        System.out.println("Node: " + bstNodeRoot.toStringFull());
        if (bstNodeRoot.getLeft() != null) {
            printBST(bstNodeRoot.getLeft());
        }
        if (bstNodeRoot.getRight() != null) {
            printBST(bstNodeRoot.getRight());
        }
    }

    private BSTNode findLcaNode(BSTNode bstNodeRoot, BSTNode bstNode1, BSTNode bstNode2) {

        Deque<BSTNode> pathRootToNode1 = findPathFromRoot(bstNodeRoot, bstNode1);
        Deque<BSTNode> pathRootToNode2 = findPathFromRoot(bstNodeRoot, bstNode2);

        if (pathRootToNode1 != null && pathRootToNode2 != null) {

            List<BSTNode> pathRootToNode1List = pathRootToNode1.stream().collect(Collectors.toList());
            Collections.reverse(pathRootToNode1List);
            BSTNode[] pathRootToNode1Array = pathRootToNode1List.stream().toArray(BSTNode[]::new);

            List<BSTNode> pathRootToNode2List = pathRootToNode2.stream().collect(Collectors.toList());
            Collections.reverse(pathRootToNode2List);
            BSTNode[] pathRootToNode2Array = pathRootToNode2List.stream().toArray(BSTNode[]::new);

            for (int i = 0; i < pathRootToNode1Array.length && i < pathRootToNode2Array.length; i++) {
                if (!pathRootToNode1Array[i].equals(pathRootToNode2Array[i])) {
                    return pathRootToNode1Array[i - 1];
                }
            }
            return bstNodeRoot;
        }
        return null;
    }

    private boolean findPathFromRoot(BSTNode bstNode1, BSTNode bstNode2, Deque<BSTNode> path) {
        //System.out.println(path);
        if (bstNode1 == null) {
            return false;
        }
        path.push(bstNode1);
        if (bstNode1.getValue().equals(bstNode2.getValue())) {
            return true;
        }
        if (findPathFromRoot(bstNode1.getLeft(), bstNode2, path) || findPathFromRoot(bstNode1.getRight(), bstNode2, path)) {
            return true;
        }
        path.pop();
        return false;
    }
}