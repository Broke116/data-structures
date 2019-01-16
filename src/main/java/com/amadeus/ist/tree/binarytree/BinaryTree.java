package com.amadeus.ist.tree.binarytree;

import java.util.*;

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
            return data == node.data &&
                    Objects.equals(left, node.left) &&
                    Objects.equals(right, node.right);
        }

        @Override
        public int hashCode() {
            return Objects.hash(data, left, right);
        }
    }

    private Node root;
    private List<Integer> traversal = new ArrayList<>();

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
        traversal.clear();
        preOrderRecursive(root);
        return traversal;
    }

    private void preOrderRecursive(Node root){
        traversal.add(root.data);

        if (root.left != null)
            preOrderRecursive(root.left);

        if (root.right != null)
            preOrderRecursive(root.right);
    }

    // DFS - Pre order traversal - iterative approach
    List<Integer> preOrderTraversalIterative() {
        traversal.clear();
        preOrderIterative(root);
        return traversal;
    }

    private void preOrderIterative(Node root) {
        if (root == null)
            return;

        Deque<Node> nodeStack = new ArrayDeque<>(); // as sonar and java documentation is concerned Deque shall be used instead of stack. Stack implements Vector interface which uses synchronized block
        nodeStack.push(root);

        int index = 0;
        int treeSize = getSizeRecursive(root);

        while (index < treeSize) {
            Node topNode = nodeStack.peek();
            traversal.add(topNode.data);
            nodeStack.pop();

            if (topNode.right != null) {
                nodeStack.push(topNode.right);
            }

            if (topNode.left != null) {
                nodeStack.push(topNode.left);
            }
            index++;
        }
    }

    // DFS - Post order traversal - recursive approach
    List<Integer> postOrderTraversalRecursive() {
        traversal.clear();
        postOrderRecursive(root);
        return traversal;
    }

    private void postOrderRecursive(Node root) {
        if (root.left != null)
            postOrderRecursive(root.left);

        if (root.right != null)
            postOrderRecursive(root.right);

        traversal.add(root.data);
    }
}
