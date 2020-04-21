package BinaryTree;

import java.util.Scanner;

public class UserInterface {

    public static void main(String[] args) {
        boolean exit = false;
        Application<Integer> app = new Application<Integer>();

        System.out.println("Integer Tree Program");
        System.out.println("---------------------");
        MyBinaryTree<Integer> tree = treeBuilder();

        while(!exit){
            System.out.println("-----------------------------------------------------");
            System.out.println("Actions list:" + "\n" +
                    "1. Tree weight" + "\n" +
                    "2. Tree leave quantity" + "\n" +
                    "3. How many times does a number appear on the tree" + "\n" +
                    "4. Number of elements at a level" + "\n" +
                    "5. Tree height" + "\n" +
                    "6. Sum of all tree elements" + "\n" +
                    "7. Sum of all tree elements that are multiples of 3" + "\n" +
                    "8. Check if two trees are equal" + "\n" +
                    "9. Check if two trees are isomorphic" + "\n" +
                    "10. Check if two trees are similar" + "\n" +
                    "11. Check if the tree is complete" + "\n" +
                    "12. Check if the tree is full" + "\n" +
                    "13. Check if the tree is stable" + "\n" +
                    "14. Check if a tree occurs inside another tree" + "\n" +
                    "15. Show border" + "\n" +
                    "16. Tree border" + "\n" +
                    "0. Exit");
            System.out.println("-----------------------------------------------------");
            System.out.println("Insert what action do you want to perform:");
            Scanner scan = new Scanner(System.in);
            int action = scan.nextInt();
            switch (action) {
                case 0:
                    exit = true;
                    break;
                case 1:
                    System.out.println(app.getSize(tree));
                    break;
                case 2:
                    System.out.println(app.getCompleteNodes(tree));
                    break;
                case 3:
                    System.out.println("What element do you want to search for?");
                    int element = scan.nextInt();
                    System.out.println(app.find(tree, element));
                    break;
                case 4:
                    System.out.println("What level do you want to search in?");
                    int level = scan.nextInt();
                    System.out.println(app.elementsAt(tree, level));
                    break;
                case 5:
                    System.out.println(app.height(tree));
                    break;
                case 6:
                    System.out.println(app.sumOfElements(tree));
                    break;
                case 7:
                    System.out.println(app.sumOfElementsMultOf3(tree));
                    break;
                case 8:
                    System.out.println("What tree do you want to compare to?");
                    MyBinaryTree<Integer> eq = treeBuilder();
                    System.out.println(app.equals(tree, eq));
                    break;
                case 9:
                    System.out.println("What tree do you want to compare to?");
                    MyBinaryTree<Integer> iso = treeBuilder();
                    System.out.println(app.isomorphic(tree, iso));
                    break;
                case 10:
                    System.out.println("What tree do you want to compare to?");
                    MyBinaryTree<Integer> sim = treeBuilder();
                    System.out.println(app.similar(tree, sim));
                    break;
                case 11:
                    System.out.println(app.isComplete(tree));
                    break;
                case 12:
                    System.out.println(app.isFull(tree));
                    break;
                case 13:
                    System.out.println(app.isStable(tree));
                    break;
                case 14:
                    System.out.println("What tree do you want to search in?");
                    MyBinaryTree<Integer> child = treeBuilder();
                    System.out.println(app.isInside(tree, child));
                    break;
                case 15:
                    app.showBorder(tree);
                    break;
                case 16:
                    System.out.println(app.getBorderTree(tree));;
                    break;
            }
        }
    }

    private static MyBinaryTree<Integer> treeBuilder(){
        System.out.println("Build tree");
        MyBinaryTree tree = treeBuilder(1);
        System.out.println("Tree was built successfully");
        return tree;
    }

    private static MyBinaryTree<Integer> treeBuilder(int level){
        Scanner scan = new Scanner(System.in);
        System.out.println("Root is: ");
        Integer root=scan.nextInt();
        MyBinaryTree<Integer> leftTree=new MyBinaryTree<Integer>();
        MyBinaryTree<Integer> rightTree=new MyBinaryTree<Integer>();
        level++;
        System.out.println("Do you want to create left node at level " + level + " ? (true/false): ");
        if(scan.nextBoolean()){
            leftTree = treeBuilder(level);
        }
        System.out.println("Do you want to create left node at level " + level + " ? (true/false): ");
        if(scan.nextBoolean()){
            rightTree = treeBuilder(level);
        }
        return new MyBinaryTree<Integer>(root,leftTree,rightTree);
    }
}
