package com.amadeus.ist.tree.binarytree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class BinaryTreeTest {

    @Mock
    Node node;

    @Mock
    BinaryTree binaryTree;

    @Before
    public void setup(){
        node = new Node(5);
        binaryTree = new BinaryTree();
    }

    @Test
    public void checkBinaryTreeSize() {
        Assert.assertEquals(1, binaryTree.getSize(node));
    }
}
