package com.amadeus.ist.tree.binarytree;

import java.util.ArrayList;
import java.util.List;

class BinaryTree {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            if (data != node.data) return false;
            if (left != null ? !left.equals(node.left) : node.left != null) return false;
            return right != null ? right.equals(node.right) : node.right == null;
        }

        @Override
        public int hashCode() {
            int result = data;
            result = 31 * result + (left != null ? left.hashCode() : 0);
            result = 31 * result + (right != null ? right.hashCode() : 0);
            return result;
        }
    }

    private Node root;
    private List<Integer> traversal = new ArrayList<Integer>();

    // used for returning the size of a binary tree
    int getSize() {
        return getSizeRecursive(root);
    }

    private int getSizeRecursive(Node root) {
        if (root == null)
            return 0;

        return 1 + getSizeRecursive(root.left) + getSizeRecursive(root.right);
    }

    // used for returning the maximum height of a binary tree
    int height() {
        return recursiveHeight(root);
    }

    private int recursiveHeight(Node root){
        int leftHeight = 0;
        int rightHeight = 0;

        if (root.right != null)
            rightHeight = 1 + recursiveHeight(root.right);

        if (root.left != null)
            leftHeight = 1 + recursiveHeight(root.left);

        return (leftHeight > rightHeight) ? leftHeight : rightHeight;
    }

    // add a new element for binary tree
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

    // search an element of binary tree
    boolean searchElement(int value) {
        Node node = searchRecursive(root, value);
        return node != null;
    }

    private Node searchRecursive(Node root, int value) {
        if (root == null)
            return root;

        if (root.data == value)
            return root;

        if (root.data > value)
            return searchRecursive(root.left, value);

        return searchRecursive(root.right, value);
    }

    // DFS - Pre order traversal - recursive approach

    List<Integer> preOrderTraversal() {
        preOrderTraversalRecursive(root);
        return traversal;
    }

    private void preOrderTraversalRecursive(Node root){
        traversal.add(root.data);

        if (root.left != null)
            preOrderTraversalRecursive(root.left);

        if (root.right != null)
            preOrderTraversalRecursive(root.right);
    }
}
