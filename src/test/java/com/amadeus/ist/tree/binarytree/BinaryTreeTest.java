package com.amadeus.ist.tree.binarytree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.List;

import static java.util.Arrays.asList;

public class BinaryTreeTest {

    @Mock
    BinaryTree binaryTree = new BinaryTree();

    @Mock
    List<Integer> traversal;

    @Before
    public void setup(){
        binaryTree.addElement(7);
        binaryTree.addElement(10);
        binaryTree.addElement(15);
        binaryTree.addElement(5);
        binaryTree.addElement(8);
    }

    @Test
    public void checkBinaryTreeSize() {
        Assert.assertEquals(5, binaryTree.getSize());
    }

    @Test
    public void addNewElement() {
        binaryTree.addElement(20);
        Assert.assertEquals(6, binaryTree.getSize());
    }

    @Test
    public void searchElement() {
        Assert.assertFalse(binaryTree.searchElement(22));
        Assert.assertTrue(binaryTree.searchElement(7));
    }

    @Test
    public void findHeightOfBinaryTree() {
        Assert.assertEquals(2, binaryTree.height());
    }

    /* Implementation of pre order traversal (depth first search) of binary tree */
    @Test
    public void binaryTreePreOrderRecursive() {
        traversal = asList(7, 5, 10, 8, 15);
        Assert.assertTrue(binaryTree.preOrderTraversal().equals(traversal));
    }

    @Test
    public void binaryTreePreOrderIterative() {
        traversal = asList(7, 5, 10, 8, 15);
        Assert.assertTrue(binaryTree.preOrderTraversalIterative().equals(traversal));
    }

    /* Implementation of post order traversal (depth first search) of binary tree */

    @Test
    public void binaryTreePostOrderRecursive() {
        traversal = asList(5, 8, 15, 10, 7);
        Assert.assertTrue(binaryTree.postOrderTraversalRecursive().equals(traversal));
    }
}
