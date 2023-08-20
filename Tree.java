public interface Tree <T extends Comparable<T>>{

    Tree<T> add(T data);
    void traverse();
    
}
