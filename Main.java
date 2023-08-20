public class Main {

    public static void main(String[] args) {

        Tree<Integer> avlTree = new AVLAdd<>();
        avlTree.insert(10).insert(2).insert(6).insert(8).insert(25).insert(18).insert(35).insert(15).insert(22).insert(42)
                .insert(30).insert(40).insert(12).insert(17).insert(19).insert(24).insert(28).insert(33).insert(38);
                avlTree.traverse();

    }
    
}
