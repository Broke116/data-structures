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

    // DFS - Post order traversal - iterative approach
    List<Integer> postOrderTraversalIterative() {
        traversal.clear();
        postOrderIterative(root);
        return traversal;
    }

    /*
    *            7
    *        5       10
    *      4   6     8    15
    *
    *    4 6 5 8 15 10 7
    * */

    private void postOrderIterative(Node root) {
        if (root == null)
            return;

        Deque<Node> nodeStack = new ArrayDeque<>(); // as sonar and java documentation is concerned Deque shall be used instead of stack. Stack implements Vector interface which uses synchronized block
        nodeStack.push(root); // root node must be pushed first. therefore due to the structure of stack, its going to be popped out at last.

        Node previous = null;
        while (!nodeStack.isEmpty()) {
            Node currentNode = nodeStack.peek(); // popped out the top value of stack.

            if (previous == null || previous.right == currentNode || previous.left == currentNode) { // used for downward movement through the list
                if (currentNode.left != null)
                    nodeStack.push(currentNode.left); // moving to leftmost node first
                else if (currentNode.right != null)
                    nodeStack.push(currentNode.right);
                else {
                    nodeStack.pop();
                    traversal.add(currentNode.data);
                }
            } else if (currentNode.left == previous) { // when returning from left node to its parent
                if (currentNode.right != null)
                    nodeStack.push(currentNode.right); // if right node is not empty then push into list, as we are going to enter into next right block
                else { // if there is no right node available, then we are going to popped out the current value of node
                    nodeStack.pop();
                    traversal.add(currentNode.data);
                }
            } else if (currentNode.right == previous) { // when returning from right node to its parent. popped the current value directly as we are going upwards direction
                nodeStack.pop();
                traversal.add(currentNode.data);
            }

            previous = currentNode;
        }

    }
}
