package com.amadeus.ist.tree.binarytree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.List;

import static java.util.Arrays.asList;

public class BinaryTreeTest {

    @Mock
    BinaryTree binaryTree1 = new BinaryTree();

    @Mock
    BinaryTree binaryTree2 = new BinaryTree();

    @Mock
    List<Integer> traversal;

    @Before
    public void setup(){
        binaryTree1.addElement(7);
        binaryTree1.addElement(10);
        binaryTree1.addElement(15);
        binaryTree1.addElement(5);
        binaryTree1.addElement(8);
        binaryTree1.addElement(4);
        binaryTree1.addElement(6);

        binaryTree2.addElement(7);
        binaryTree2.addElement(10);
        binaryTree2.addElement(15);
        binaryTree2.addElement(5);
        binaryTree2.addElement(8);
        binaryTree2.addElement(4);
        binaryTree2.addElement(6);
    }

    @Test
    public void checkBinaryTreeSize() {
        Assert.assertEquals(7, binaryTree1.getSize());
    }

    @Test
    public void addNewElement() {
        binaryTree1.addElement(20);
        Assert.assertEquals(8, binaryTree1.getSize());
    }

    @Test
    public void searchElement() {
        Assert.assertFalse(binaryTree1.searchElement(22));
        Assert.assertTrue(binaryTree1.searchElement(7));
    }

    @Test
    public void findHeightOfBinaryTree() {
        Assert.assertEquals(2, binaryTree1.height());
    }

    /* Implementation of pre order traversal (depth first search) of binary tree */
    @Test
    public void binaryTreePreOrderRecursive() {
        traversal = asList(7, 5, 4, 6, 10, 8, 15);
        Assert.assertTrue(binaryTree1.preOrderTraversal().equals(traversal));
    }

    @Test
    public void binaryTreePreOrderIterative() {
        traversal = asList(7, 5, 4, 6, 10, 8, 15);
        Assert.assertTrue(binaryTree1.preOrderTraversalIterative().equals(traversal));
    }

    /* Implementation of post order traversal (depth first search) of binary tree */

    @Test
    public void binaryTreePostOrderRecursive() {
        traversal = asList(4, 6, 5, 8, 15, 10, 7);
        Assert.assertTrue(binaryTree1.postOrderTraversalRecursive().equals(traversal));
    }

    @Test
    public void binaryTreePostOrderIterative() {
        traversal = asList(4, 6, 5, 8, 15, 10, 7);
        Assert.assertTrue(binaryTree1.postOrderTraversalIterative().equals(traversal));
    }

    /* Implementation of in order traversal (depth first search) of binary tree */
    @Test
    public void binaryTreeInOrderRecursive() {
         traversal = asList(4, 5, 6, 7, 8, 10, 15);
         Assert.assertTrue(binaryTree1.inOrderTraversalRecursive().equals(traversal));
     }

    @Test
    public void binaryTreeInOrderIterative() {
        traversal = asList(4, 5, 6, 7, 8, 10, 15);
        Assert.assertTrue(binaryTree1.inOrderTraversalIterative().equals(traversal));
    }

    // Print the right view of a Binary Tree
    @Test
    public void printRightViewOfBinaryTree(){
        traversal = asList(7, 10, 15);
        Assert.assertEquals(binaryTree1.printView("right"), traversal);
    }

    // Print the left view of a Binary Tree
    @Test
    public void printLeftViewOfBinaryTree(){
        traversal = asList(7, 5, 4);
        Assert.assertEquals(binaryTree1.printView("left"), traversal);
    }
}
