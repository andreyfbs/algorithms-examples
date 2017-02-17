package br.com.sinergiavirtual.algorithms.binarytree;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

// http://www.geeksforgeeks.org/sorted-array-to-balanced-bst/
public class BSTTest {

    @Test
    public void findDistanceBetweenNodesIncludeCompareRoot() throws Exception {

        // Arrange
        final int[] arrayBst = new int[]{5, 6, 3, 1, 2, 4};
        final int node1 = 5;
        final int node2 = 2;

        final BSTNode bstNode1 = new BSTNode(node1);
        final BSTNode bstNode2 = new BSTNode(node2);
        final BST bst = new BST(arrayBst);

        // Log
        System.out.println("Tree:");
        System.out.println(bst.printBST());

        // Act
        int distance = bst.findDistanceBetweenNodes(bstNode1, bstNode2);

        // Assert
        Assert.assertThat(distance, Matchers.comparesEqualTo(3));
    }

    @Test
    public void findDistanceBetweenNodesWithoutCompareRoot() throws Exception {

        // Arrange
        final int[] arrayBst = new int[]{5, 6, 3, 1, 2, 4};
        final int node1 = 2;
        final int node2 = 4;

        final BSTNode bstNode1 = new BSTNode(node1);
        final BSTNode bstNode2 = new BSTNode(node2);
        final BST bst = new BST(arrayBst);

        // Log
        System.out.println("Tree:");
        System.out.println(bst.printBST());

        // Act
        int distance = bst.findDistanceBetweenNodes(bstNode1, bstNode2);

        // Assert
        Assert.assertThat(distance, Matchers.comparesEqualTo(3));
    }

    @Test
    public void findDistanceBetweenNodesOneOfThemOut() throws Exception {

        // Arrange
        final int[] arrayBst = new int[]{9, 7, 5, 3, 1};
        final int node1 = 7;
        final int node2 = 20;

        final BSTNode bstNode1 = new BSTNode(node1);
        final BSTNode bstNode2 = new BSTNode(node2);
        final BST bst = new BST(arrayBst);

        // Log
        System.out.println("Tree:");
        System.out.println(bst.printBST());

        // Act
        int distance = bst.findDistanceBetweenNodes(bstNode1, bstNode2);

        // Assert
        Assert.assertThat(distance, Matchers.comparesEqualTo(-1));
    }

    @Test
    public void findDistanceBetweenNodesTwoOfThemOut() throws Exception {

        // Arrange
        final int[] arrayBst = new int[]{9, 7, 5, 3, 1};
        final int node1 = 2;
        final int node2 = 20;

        final BSTNode bstNode1 = new BSTNode(node1);
        final BSTNode bstNode2 = new BSTNode(node2);
        final BST bst = new BST(arrayBst);

        // Log
        System.out.println("Tree:");
        System.out.println(bst.printBST());

        // Act
        int distance = bst.findDistanceBetweenNodes(bstNode1, bstNode2);

        // Assert
        Assert.assertThat(distance, Matchers.comparesEqualTo(-1));
    }

    @Test
    public void findDistanceBetweenNodesOnlyOneNode() throws Exception {

        // Arrange
        final int[] arrayBst = new int[]{9};
        final int node1 = 9;
        final int node2 = 10;

        final BSTNode bstNode1 = new BSTNode(node1);
        final BSTNode bstNode2 = new BSTNode(node2);
        final BST bst = new BST(arrayBst);

        // Log
        System.out.println("Tree:");
        System.out.println(bst.printBST());

        // Act
        int distance = bst.findDistanceBetweenNodes(bstNode1, bstNode2);

        // Assert
        Assert.assertThat(distance, Matchers.comparesEqualTo(-1));
    }

    @Test
    public void findDistanceBetweenNodesBothEquals() throws Exception {

        // Arrange
        final int[] arrayBst = new int[]{9, 7, 5, 3, 1};
        final int node1 = 9;
        final int node2 = 9;

        final BSTNode bstNode1 = new BSTNode(node1);
        final BSTNode bstNode2 = new BSTNode(node2);
        final BST bst = new BST(arrayBst);

        // Log
        System.out.println("Tree:");
        System.out.println(bst.printBST());

        // Act
        int distance = bst.findDistanceBetweenNodes(bstNode1, bstNode2);

        // Assert
        Assert.assertThat(distance, Matchers.comparesEqualTo(0));
    }
    
}