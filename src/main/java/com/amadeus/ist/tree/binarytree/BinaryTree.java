package com.amadeus.ist.tree.binarytree;

class BinaryTree {
    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    int getSize() {
        return getSizeRecursive(root);
    }

    private int getSizeRecursive(Node root) {
        if (root == null)
            return 0;

        return 1 + getSizeRecursive(root.left) + getSizeRecursive(root.right);
    }

    void addElement(int value) {
        root = addRecursive(root, value);
    }

    private Node addRecursive(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }

        if (root.data > value)
            root.left = addRecursive(root.left, value);

        if (root.data < value)
            root.right = addRecursive(root.right, value);

        return root;
    }
}
