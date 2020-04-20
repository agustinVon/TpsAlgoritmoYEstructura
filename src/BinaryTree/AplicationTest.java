package BinaryTree;

import org.junit.Test;

import static org.junit.Assert.*;

public class AplicationTest {

    @Test
    public void whenCalculatingAmmountOfElementsInTreeShouldSucced(){
        OtherBinaryTree<Integer> integerBinaryTree=new OtherBinaryTree<Integer>(4,
        new OtherBinaryTree<Integer>(4),
        new OtherBinaryTree<Integer>(5,new OtherBinaryTree<Integer>(3),new OtherBinaryTree<Integer>(2)));

        Aplication<Integer> app=new Aplication<Integer>();

        System.out.println(app.sumOfElements(integerBinaryTree));
    }

    @Test
    public void whenCalculatingAmmountOfElementsMultOf3InTreeShouldSucced(){
        OtherBinaryTree<Integer> integerBinaryTree=new OtherBinaryTree<Integer>(4,
                new OtherBinaryTree<Integer>(4),
                new OtherBinaryTree<Integer>(5,new OtherBinaryTree<Integer>(3),new OtherBinaryTree<Integer>(2)));

        Aplication<Integer> app=new Aplication<Integer>();

        System.out.println(app.sumOfElementsMultOf3(integerBinaryTree));
    }


}