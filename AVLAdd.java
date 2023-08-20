public class AVLAdd<T extends Comparable<T>> implements Tree<T>{


    //Initialise a root node.
    private Node<T> root;

    //Add method to add data into the AVL Tree.
    @Override
    public Tree<T> add(T data) {
        root = add(data, root);
        return this;
    }

    private Node<T> add(T data, Node<T> node) {
        //If the node is null, create a new node with the data.
        if (node == null) {
            return new Node<>(data);
        }
        //If the data is less than the node data, add the data into the left child.
        if (data.compareTo(node.getData()) < 0) {
            node.setLeftChild(add(data, node.getLeftChild()));
        //If the data is greater than the node data, add the data into the right child.
        } else if (data.compareTo(node.getData()) > 0) {
            node.setRightChild(add(data, node.getRightChild()));
        //If the data is equal to the node data, return the node.
        } else {
            return node;
        }
        //Change the height of the node.
        changeHeight(node);
        //Apply the rotation to the node.
        return applyRotation(node);
    }

    @Override
    public void traverse() {
     //traverse method just calls the traverseInOrder method.
        traverseInOrder(root);
    }

    private void traverseInOrder(Node<T> node) {
        //If the node is null, return.
        if (node == null) {
            return;
        }
        //Perform a Pre-Order traversal, i.e. travel from root node to leftmode child, then rightmost of the left node
        //Then visit the right child of the root node.
        System.out.println(node.getData());
        traverseInOrder(node.getLeftChild());
        traverseInOrder(node.getRightChild());
    }

    private Node<T> applyRotation(Node<T> node) {
        //Apply the rotation to the node.
        int balance = balance(node);
        //This is done using balance - if the balance is greater than 1, rotate right (left, left case)
        if (balance > 1) {
            //However, if the balance of the left child is less than 0, rotate left on the left child first (left, right case)
            if (balance(node.getLeftChild()) < 0) {
                node.setLeftChild(rotateLeft(node.getLeftChild()));
            }
            return rotateRight(node);
        }
        //If the balance is less than -1, rotate left (right, right case)
        if (balance < -1) {
            //However, if the balance of the right child is greater than 0, rotate right on the right child first (right, left case)
            if (balance(node.getRightChild()) > 0) {
                node.setRightChild(rotateRight(node.getRightChild()));
            }
            return rotateLeft(node);
        }
        return node;
    }

    private Node<T> rotateRight(Node<T> node) {
        //Setting left node as the chosen node's leftChild
        Node<T> leftNode = node.getLeftChild();
        //Setting middle node as the left node's rightChild
        Node<T> middleNode = leftNode.getRightChild();
        //Now set the left node's rightChild as the chosen node
        leftNode.setRightChild(node);
        //Set the chosen node's leftChild as the middle node
        node.setLeftChild(middleNode);
        //update Height after rotation
        changeHeight(node);
        changeHeight(leftNode);
        return leftNode;
    }

    private Node<T> rotateLeft(Node<T> node) {
        //Same as rotateRight, but in reverse
        Node<T> rightNode = node.getRightChild();
        Node<T> middleNode = rightNode.getLeftChild();
        rightNode.setLeftChild(node);
        node.setRightChild(middleNode);
        changeHeight(node);
        changeHeight(rightNode);
        return rightNode;
    }

    private void changeHeight(Node<T> node) {
        //Change the height of the node
        int maxHeight = Math.max(
                height(node.getLeftChild()),
                height(node.getRightChild())
        );
        node.setHeight(maxHeight + 1);
    }

    private int balance(Node<T> node) {
        //Balance is the height of the left child minus the height of the right child
        //However, return 0, if the node is null
        return node != null ? height(node.getLeftChild()) - height(node.getRightChild()) : 0;
    }

    private int height(Node<T> node) {
        //Height is the height of the node, or 0 if the node is null
        return node != null ? node.getHeight() : 0;
    }
    
}
