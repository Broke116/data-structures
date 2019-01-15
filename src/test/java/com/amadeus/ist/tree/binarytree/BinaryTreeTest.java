package com.amadeus.ist.tree.binarytree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class BinaryTreeTest {

    @Mock
    BinaryTree binaryTree = new BinaryTree();

    @Before
    public void setup(){
        binaryTree.addElement(7);
    }

    @Test
    public void checkBinaryTreeSize() {
        Assert.assertEquals(1, binaryTree.getSize());
    }

    @Test
    public void addNewElement() {
        binaryTree.addElement(5);
        Assert.assertEquals(2, binaryTree.getSize());
    }

    @Test
    public void searchElement() {
        Assert.assertFalse(binaryTree.searchElement(8));
        Assert.assertTrue(binaryTree.searchElement(7));
    }

    @Test
    public void findHeightOfBinaryTree() {
        binaryTree.addElement(10);
        binaryTree.addElement(15);
        binaryTree.addElement(5);
        binaryTree.addElement(8);

        Assert.assertEquals(2, binaryTree.height());
    }
}
