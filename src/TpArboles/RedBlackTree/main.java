package TpArboles.RedBlackTree;

public class main {
    public static void main(String[] args) {

        RBTree tree=new RBTree(-1);
        for (int i = 2; i < 11; i++) {
            tree.insert(i);
        }
        System.out.println(tree.height());

    }
}
