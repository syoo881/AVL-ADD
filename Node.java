public class Node<T extends Comparable<T>>{
    
    private int height;
    private T data;
    private Node<T> leftChild;
    private Node<T> rightChild;

    public Node(T data){
        this.data = data;
        this.height = height;
        this.leftChild = null;
        this.rightChild = null;
    }

}