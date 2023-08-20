public class Main {

    public static void main(String[] args) {

        Tree<Integer> avlTree = new AVLAdd<>();
        //adding data into the AVL Tree to test whether rotations work correctly
        avlTree.add(1).add(2).add(3).add(4).add(5).add(6);
        //traversing the AVL Tree, to print all data as it traverses
        avlTree.traverse();
        //Should print 4,2,1,3,5,6 as it traverses in Pre-Order.
        //This confirms that the AVLTree and rotations work correctly.

    }
    
}
