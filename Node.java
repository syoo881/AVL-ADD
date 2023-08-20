public class Node<T extends Comparable<T>>{
    
    private int height =1;
    private T data;
    private Node<T> leftChild;
    private Node<T> rightChild;

    //Constructor for the node
    public Node(T data){
        this.data = data;
        this.height = 1;
        this.leftChild = null;
        this.rightChild = null;
    }

    //getters, Setters for the data, height, leftChild, rightChild.
    public int getHeight(){
        return height;
    }

    public void setHeight(int height){
        this.height = height;
    }

    public T getData(){
        return data;
    }

    public void setData(T data){
        this.data = data;
    }

    public Node<T> getLeftChild(){
        return leftChild;
    }

    public void setLeftChild(Node<T> leftChild){
        this.leftChild = leftChild;
    }

    public Node<T> getRightChild(){
        return rightChild;
    }

    public void setRightChild(Node<T> rightChild){
        this.rightChild = rightChild;
    }

}