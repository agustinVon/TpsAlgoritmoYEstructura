package BinarySearchTree;

import junit.framework.TestCase;
import org.junit.Assert;

public class SearchBinaryTreeTest extends TestCase {

    public void testIsEmpty() {
        //Should return true
        SearchBinaryTree<Integer> searchTree = new SearchBinaryTree<Integer>();
        Assert.assertTrue(searchTree.isEmpty());

        //Should return false
        SearchBinaryTree<Integer> searchTree2 = new SearchBinaryTree<Integer>(4);
        Assert.assertFalse(searchTree2.isEmpty());
    }

    public void testGetRoot() {
        //Should give root value
        SearchBinaryTree<Integer> searchTree = new SearchBinaryTree<Integer>(68);
        Assert.assertEquals(68, (int) searchTree.getRoot());
    }

    public void testGetRight() {
        SearchBinaryTree<Integer> searchTree = new SearchBinaryTree<Integer>(7,new SearchBinaryTree<Integer>(null),new SearchBinaryTree<Integer>(9));
        Assert.assertEquals(9, (int) searchTree.getRight().getRoot());
    }

    public void testGetLeft() {
        SearchBinaryTree<Integer> searchTree = new SearchBinaryTree<Integer>(7,new SearchBinaryTree<Integer>(6),new SearchBinaryTree<Integer>());
        Assert.assertEquals(6, (int) searchTree.getLeft().getRoot());
    }

    public void testInsert() {
        //Should insert 9 to the right of 8
        SearchBinaryTree<Integer> searchTree = new SearchBinaryTree<Integer>(7,new SearchBinaryTree<Integer>(6),new SearchBinaryTree<Integer>(8));
        searchTree.insert(9);
        Assert.assertEquals(9,(int) searchTree.rootNode.right.right.element);

        //Should insert 420 to the right of 9
        searchTree.insert(420);
        Assert.assertEquals(420,(int) searchTree.rootNode.right.right.right.element);

        //Should insert 9 to the left of 8
        SearchBinaryTree<Integer> searchTree2 = new SearchBinaryTree<Integer>(7,new SearchBinaryTree<Integer>(5, new SearchBinaryTree<Integer>(3), new SearchBinaryTree<Integer>(6) ),new SearchBinaryTree<Integer>(8, new SearchBinaryTree<Integer>(),new SearchBinaryTree<Integer>(28, new SearchBinaryTree<Integer>(), new SearchBinaryTree<Integer>(29))));
        searchTree2.insert(9);
        Assert.assertEquals(9, (int) searchTree2.rootNode.right.right.left.element);
    }

    public void testDelete() {
        //Should delete the leaf integer 6
        SearchBinaryTree<Integer> searchTree = new SearchBinaryTree<Integer>(7,new SearchBinaryTree<Integer>(5, new SearchBinaryTree<Integer>(3), new SearchBinaryTree<Integer>(6) ),new SearchBinaryTree<Integer>(8, new SearchBinaryTree<Integer>(),new SearchBinaryTree<Integer>(28, new SearchBinaryTree<Integer>(9), new SearchBinaryTree<Integer>(29))));
        searchTree.delete(6);
        Assert.assertFalse(searchTree.exists(6));
        Assert.assertTrue(searchTree.rootNode.left.right == null);

        //Should delete the value of 5 and make 6 the new root of the subtree
        SearchBinaryTree<Integer> searchTree2 = new SearchBinaryTree<Integer>(7,new SearchBinaryTree<Integer>(5, new SearchBinaryTree<Integer>(3), new SearchBinaryTree<Integer>(6) ),new SearchBinaryTree<Integer>(8, new SearchBinaryTree<Integer>(),new SearchBinaryTree<Integer>(28, new SearchBinaryTree<Integer>(9), new SearchBinaryTree<Integer>(29))));
        searchTree2.delete(5);
        Assert.assertFalse(searchTree2.exists(5));
        Assert.assertEquals(6, (int) searchTree2.rootNode.left.element);
        Assert.assertTrue(searchTree2.rootNode.left.right == null);

        //Should delete the root and make 8 the new root
        SearchBinaryTree<Integer> searchTree3 = new SearchBinaryTree<Integer>(7,new SearchBinaryTree<Integer>(5, new SearchBinaryTree<Integer>(3), new SearchBinaryTree<Integer>(6) ),new SearchBinaryTree<Integer>(8, new SearchBinaryTree<Integer>(),new SearchBinaryTree<Integer>(28, new SearchBinaryTree<Integer>(9), new SearchBinaryTree<Integer>(29))));
        searchTree3.delete(7);
        Assert.assertFalse(searchTree3.exists(7));
        Assert.assertEquals(8, (int) searchTree3.rootNode.element);
    }

    public void testExists() {
        SearchBinaryTree<Integer> searchTree = new SearchBinaryTree<Integer>(7,new SearchBinaryTree<Integer>(5, new SearchBinaryTree<Integer>(3), new SearchBinaryTree<Integer>(6) ),new SearchBinaryTree<Integer>(8, new SearchBinaryTree<Integer>(),new SearchBinaryTree<Integer>(28)));
        Assert.assertTrue(searchTree.exists(8));
        Assert.assertTrue(searchTree.exists(6));
        Assert.assertTrue(searchTree.exists(28));
        Assert.assertFalse(searchTree.exists(192));
    }
}