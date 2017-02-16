package br.com.sinergiavirtual.algorithms.binarytree;

// http://www.geeksforgeeks.org/sorted-array-to-balanced-bst/
public class FindDistanceBST {

    public static void main(String[] args) {
        int[] array = new int[]{5, 6, 3, 1, 2, 4};
        System.out.println("Distance 1: " + bstDistance(array, 6, 5, 2));
        System.out.println("Distance 2: " + bstDistance(array, 6, 2, 4));
        System.out.println("Distance 3: " + bstDistance(array, 6, 6, 20));
    }

    public static int bstDistance(int[] values, int n, int node1, int node2) {

        BSTNode bstNodeRoot = new BSTNode(values[0]);

        BST bst = new BST();

        for (int i = 1; i < values.length; i++) {
            BSTNode newBstNode = bst.fillBst(bstNodeRoot, values[i]);
        }
        bst.printBST(bstNodeRoot);

        BSTNode bstNode1 = new BSTNode(node1);
        BSTNode bstNode2 = new BSTNode(node2);

        System.out.println("Path: " + bst.findPathFromRoot(bstNodeRoot, bstNode2));

        int distance = bst.findDistanceBetweenNodes(bstNodeRoot, bstNode1, bstNode2);
        return distance;
    }
}

