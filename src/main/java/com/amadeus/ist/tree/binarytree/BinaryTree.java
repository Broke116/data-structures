package com.amadeus.ist.tree.binarytree;

class BinaryTree {
    int getSize(Node node) {
        if (node == null)
            return 0;

        return 1 + getSize(node.right) + getSize(node.left);
    }
}
