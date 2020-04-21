package BinaryTree;

import java.util.Scanner;

public class UserInterface {

    public static void main(String[] args) {
        System.out.println("Integer Tree Program");
        System.out.println("\n\n");
        System.out.println("Build tree: ");
        MyBinaryTree<Integer> tree=treeBuilder();
        System.out.println("Tree was built successfully");
    }

    private static MyBinaryTree<Integer> treeBuilder(){
        Scanner scan=new Scanner(System.in);
        System.out.println("\n\n");
        System.out.println("Root is: ");
        Integer root=scan.nextInt();
        MyBinaryTree<Integer> leftTree=new MyBinaryTree<Integer>();
        MyBinaryTree<Integer> rightTree=new MyBinaryTree<Integer>();
        System.out.println("Do you want to create left tree? (y/n): ");
        if(scan.nextBoolean()){
            leftTree=treeBuilder();
        }
        System.out.println("Do you want to create right tree? (y/n): ");
        if(scan.nextBoolean()){
            rightTree=treeBuilder();
        }
        return new MyBinaryTree<Integer>(root,leftTree,rightTree);
    }
}
