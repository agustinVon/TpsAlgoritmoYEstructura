package BinarySearchTree;

import java.util.Scanner;

public class UserInterface {
    public static void main(String[] args) {

        SearchBinaryTree<Genome> tree=new SearchBinaryTree<>();
        Scanner scn=new Scanner(System.in);

        while (true) {
            System.out.println("\n");
            System.out.println("Select operation: ");
            System.out.println("\n");
            System.out.println("1. Insert Genome");
            System.out.println("2. Delete Genome");
            System.out.println("3. Search Genome");
            System.out.println("\n");

            int operationSelected = scn.nextInt();
            switch (operationSelected) {
                case 1:
                    System.out.println("\n");
                    System.out.println("Select genome to insert");
                    System.out.println("\n");
                    System.out.println("Type genome type: ");
                    String type = scn.next();
                    System.out.println("\n");
                    System.out.println("Type genome description: ");
                    String descr = scn.next();
                    System.out.println("\n");
                    System.out.println("Type genome code (5 characters) : ");
                    String codeString=scn.next();
                    try {
                        GenomeCode code = new GenomeCode(codeString);
                        System.out.println("\n");
                        System.out.println("Type genome size: ");
                        int size = scn.nextInt();
                        tree.insert(new Genome(code, type, descr, size));
                        System.out.println("\n");
                        System.out.println("Successfully inserted");
                        break;
                    } catch (CodeIsNotCorrectSize codeIsNotCorrectSize) {
                        System.out.println("Not correct length");
                        break;
                    }
                case 2:
                    System.out.println("\n");
                    System.out.println("Select genome to delete");
                    System.out.println("\n");
                    System.out.println("Type genome type: ");
                    String type1 = scn.next();
                    System.out.println("\n");
                    System.out.println("Type genome description: ");
                    String descr1 = scn.next();
                    System.out.println("\n");
                    System.out.println("Type genome code (5 characters) : ");
                    String codeString1=scn.next();
                    try {
                        GenomeCode code = new GenomeCode(codeString1);
                        System.out.println("\n");
                        System.out.println("Type genome size: ");
                        int size1 = scn.nextInt();
                        tree.delete(new Genome(code, type1, descr1, size1));
                        System.out.println("\n");
                        System.out.println("Successfully deleted");
                        break;
                    } catch (CodeIsNotCorrectSize codeIsNotCorrectSize) {
                        break;
                    }
                case 3:
                    System.out.println("\n");
                    System.out.println("Select genome to search");
                    System.out.println("\n");
                    System.out.println("Type genome type: ");
                    String type2 = scn.next();
                    System.out.println("\n");
                    System.out.println("Type genome description: ");
                    String descr2 = scn.next();
                    System.out.println("\n");
                    System.out.println("Type genome code (5 characters) : ");
                    String codeString2=scn.next();
                    try {
                        GenomeCode code = new GenomeCode(codeString2);
                        System.out.println("\n");
                        System.out.println("Type genome size: ");
                        int size2 = scn.nextInt();
                        System.out.println("\n");
                        if(tree.exists(new Genome(code, type2, descr2, size2))){
                            System.out.println("Tree contains Genome");
                        }
                        else System.out.println("Tree does not contain Genome");
                        System.out.println("\n");

                        break;
                    } catch (CodeIsNotCorrectSize codeIsNotCorrectSize) {
                        break;
                    }
                default:
                    System.out.println("Select a valid operation");
            }
        }
    }
}
