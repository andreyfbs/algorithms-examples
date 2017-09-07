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
 * Vocabulary: Node, parent, child, leaf (final node)
 *
 * Time complexity in big O notation:
 *
 * Algorithm	Average	    Worst Case
 * Space		O(n)	    O(n)
 * Search		O(log n)	O(n)
 * Insert		O(log n)	O(n)
 * Delete		O(log n)	O(n)
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
        BSTNode bstNodeLCA = findLcaNode(pathRootToNode1, pathRootToNode2);

        BSTNode[] pathRootToNodeLca = findPathFromRoot(bstNodeLCA);

        System.out.println("1=" + pathRootToNode1.length + " 2=" + pathRootToNode2.length + " 3=" + pathRootToNodeLca.length);

        // Calcule the Distance
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

        // Create the Stack to be used in the DFS
        Deque<BSTNode> dequeStack = new ArrayDeque<>();

        // Find The Path, check dequeStack
        findPathFromRootWithDFS(bstNodeRoot, bstNode, dequeStack);

        // Transform to List
        List<BSTNode> pathRootToNode1List = dequeStack.stream().collect(Collectors.toList());

        // Reverse Order of The List
        Collections.reverse(pathRootToNode1List);

        // Transform from List to Array
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

    /**
     * Find the Lca (Lowest common ancestor) Node of two nodes. It uses the paths of the nodes already found.
     *
     * @param pathRootToNode1
     * @param pathRootToNode2
     * @return BSTNode Lca
     */
    private BSTNode findLcaNode(BSTNode[] pathRootToNode1, BSTNode[] pathRootToNode2) {

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
     * Find the Lca (Lowest common ancestor) Node of two nodes
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
     * This method searches through the Tree using DFS search and mount a path in the collection pathStack
     *
     * Recursive approach.
     *
     * @param bstNodeRoot It Starts with the NodeRoot and after it uses the others nodes
     * @param bstNodeToFind Node to be located
     * @param pathStack Fill this parameter with the path between the nodes
     * @return True if it found the node
     */
    private boolean findPathFromRootWithDFS(final BSTNode bstNodeRoot, final BSTNode bstNodeToFind, final Deque<BSTNode> pathStack) {

        // If the Node doesnt exist, is a leaf, so "false" and back to the parent
        if (bstNodeRoot == null) {
            return false;
        }

        // Push in the Stack
        pathStack.push(bstNodeRoot);

        // If the nodes are equal, it has found out the element, we already have the path!
        if (bstNodeRoot.equals(bstNodeToFind)) {
            return true;
        }

        // Check if the root value is higher, in this case, continue the search in Left Tree. Otherwise, go to Right Tree
        final BSTNode nextRoot;
        if (bstNodeRoot.getValue() > bstNodeToFind.getValue()) {
            nextRoot = bstNodeRoot.getLeft();
        } else {
            nextRoot = bstNodeRoot.getRight();
        }

        // Recursive algorithm, replace the root and keep going
        // If find the Node, return true
        if (findPathFromRootWithDFS(nextRoot, bstNodeToFind, pathStack)) {
            return true;
        }

        // If not find the element in the path, pop the current root
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