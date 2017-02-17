package br.com.sinergiavirtual.algorithms.binarytree;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

/**
 * In computer science, binary search trees (BST), sometimes called ordered or sorted binary trees, are a particular type of containers:
 * data structures that store "items" (such as numbers, names etc.) in memory.
 * They allow fast lookup, addition and removal of items, and can be used to implement either dynamic sets of items,
 * or lookup tables that allow finding an item by its key (e.g., finding the phone number of a person by name).
 *
 * Note: This implementation is not Balanced
 *
 */
public class BST {

    /**
     * The Root Node. In fact, it is the whole tree because through its, you can find all nodes.
     */
    private BSTNode bstNodeRoot;

    /**
     * It Stores the tree drawing
     * {@link #printBST(BSTNode)}
     */
    private StringBuilder treePrint = new StringBuilder();

    /**
     * Constructor default
     */
    public BST() {
        super();
    }

    /**
     * This Constructor receives an array as a parameter and populates the Tree through the Root Node.
     */
    public BST(int[] bstNodes) {
        bstNodeRoot = new BSTNode(bstNodes[0]);

        for (int i = 1; i < bstNodes.length; i++) {
            fillBst(bstNodeRoot, bstNodes[i]);
        }
    }

    /**
     * Find the distance between 2 nodes
     *
     * Below the Formula:
     *
     * Dist(n1, n2) = Dist(root, n1) + Dist(root, n2) - 2*Dist(root, lca)
     * 'n1' and 'n2' are the two given keys
     * 'root' is root of given Binary Tree.
     * 'lca' is lowest common ancestor of n1 and n2
     * Dist(n1, n2) is the distance between n1 and n2.
     */
    public int findDistanceBetweenNodes(BSTNode bstNode1, BSTNode bstNode2) {

        BSTNode[] pathRootToNode1 = findPathFromRoot(bstNode1);
        BSTNode[] pathRootToNode2 = findPathFromRoot(bstNode2);
        BSTNode bstNodeLCA = findLcaNodeFromNodePaths(bstNode1, bstNode2, pathRootToNode1, pathRootToNode2);

        BSTNode[] pathRootToNodeLca = findPathFromRoot(bstNodeLCA);

        System.out.println("1=" + pathRootToNode1.length + " 2=" + pathRootToNode2.length + " 3=" + pathRootToNodeLca.length);
        if (pathRootToNode1.length == 0 || pathRootToNode2.length == 0) {
            return -1;
        } else {
            return (pathRootToNode1.length - 1 + pathRootToNode2.length - 1) - (2 * (pathRootToNodeLca.length - 1));
        }
    }

    /**
     * Find the Path between the Root Node and any other
     * @param bstNode
     * @return An Array with the complete Path
     */
    public BSTNode[] findPathFromRoot(BSTNode bstNode) {

        Deque<BSTNode> dequeStack = new ArrayDeque<>();
        findPathFromRootDFS(bstNodeRoot, bstNode, dequeStack);

        List<BSTNode> pathRootToNode1List = dequeStack.stream().collect(Collectors.toList());
        Collections.reverse(pathRootToNode1List);

        return pathRootToNode1List.stream().toArray(BSTNode[]::new);
    }

    /**
     * Return the representation of the Tree's Nodes
     * @return String with this representation
     */
    public String printBST() {
        printBST(bstNodeRoot);
        return treePrint.toString();
    }

    private BSTNode findLcaNodeFromNodePaths(BSTNode bstNode1, BSTNode bstNode2, BSTNode[] pathRootToNode1, BSTNode[] pathRootToNode2) {

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

    /**
     * Find the Lca(Lowest common ancestor) Node of two nodes
     *
     * Recursive approach.
     *
     * @param bstNode1
     * @param bstNode2
     * @return BSTNode Lca
     */
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

    /**
     * This method searches through the Tree using DFS search and mount a path in the parameter pathStack
     *
     * Recursive approach.
     *
     * @param bstNode1 It Starts with the NodeRoot and after it uses the others nodes
     * @param bstNode2 Node to be located
     * @param pathStack Fill this parameter with the path between the nodes
     * @return True if it found the node
     */
    private boolean findPathFromRootDFS(BSTNode bstNode1, BSTNode bstNode2, Deque<BSTNode> pathStack) {
        //System.out.println(path);
        if (bstNode1 == null) {
            return false;
        }
        pathStack.push(bstNode1);
        if (bstNode1.getValue().equals(bstNode2.getValue())) {
            return true;
        }
        if (findPathFromRootDFS(bstNode1.getLeft(), bstNode2, pathStack) || findPathFromRootDFS(bstNode1.getRight(), bstNode2, pathStack)) {
            return true;
        }
        pathStack.pop();
        return false;
    }

    /**
     * Fill the BST.
     *
     * Recursive approach.
     *
     * @param bstNode
     * @param valueToAdd
     * @return
     */
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
}