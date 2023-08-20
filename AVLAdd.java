public class AVLAdd<T extends Comparable<T>> implements Tree<T>{


    private Node<T> root;
    @Override
    public Tree<T> insert(T data) {
        root = insert(data, root);
        return this;
    }

    private Node<T> insert(T data, Node<T> node) {
        if (node == null) {
            return new Node<>(data);
        }
        if (data.compareTo(node.getData()) < 0) {
            node.setLeftChild(insert(data, node.getLeftChild()));
        } else if (data.compareTo(node.getData()) > 0) {
            node.setRightChild(insert(data, node.getRightChild()));
        } else {
            return node;
        }
        return node;
    }

    @Override
    public void traverse() {
        traverseInOrder(root);
    }

    private void traverseInOrder(Node<T> node) {
        if (node == null) {
            return;
        }
        traverseInOrder(node.getLeftChild());
        System.out.println(node.getData());
        traverseInOrder(node.getRightChild());
    }

    
    
}
