package BinarySearchTree;

import junit.framework.TestCase;
import org.junit.Assert;

public class GenomeTreeTest extends TestCase {

    public void testGeneral() throws CodeIsNotCorrectSize{
        //When a is the root and other elements are inserted
        Genome a = new Genome(new GenomeCode("00001"), "a", "a",1);
        Genome b = new Genome(new GenomeCode("00002"), "b", "b",2);
        Genome c = new Genome(new GenomeCode("00003"), "c", "c",3);
        Genome d = new Genome(new GenomeCode("00004"), "d", "d",4);
        Genome e = new Genome(new GenomeCode("00005"), "e", "e",5);
        Genome f = new Genome(new GenomeCode("00006"), "f", "f",6);
        SearchBinaryTree<Genome> genomeTree = new SearchBinaryTree<Genome>(a);
        genomeTree.insert(b);
        genomeTree.insert(c);
        genomeTree.insert(d);
        genomeTree.insert(e);
        genomeTree.insert(f);
        Assert.assertEquals(b, genomeTree.rootNode.right.element);
        Assert.assertEquals(c, genomeTree.rootNode.right.right.element);

        //When c is the root and other general testing
        SearchBinaryTree<Genome> genomeTree2 = new SearchBinaryTree<Genome>(c);
        genomeTree2.insert(b);
        genomeTree2.insert(a);
        genomeTree2.insert(e);
        genomeTree2.insert(d);
        genomeTree2.insert(f);
        Assert.assertTrue(genomeTree2.exists(d));
        Assert.assertEquals(genomeTree2.rootNode.left.left.element, a);
        Assert.assertEquals(genomeTree2.rootNode.left.element, b);
        Assert.assertEquals(genomeTree2.rootNode.right.element, e);
        Assert.assertEquals(genomeTree2.rootNode.right.right.element, f);
        Assert.assertEquals(genomeTree2.rootNode.right.left.element, d);

        genomeTree2.delete(e);
        Assert.assertFalse(genomeTree2.exists(e));
        Assert.assertEquals(genomeTree2.rootNode.right.element, f);

        genomeTree2.delete(a);
        Assert.assertFalse(genomeTree2.exists(a));
        Assert.assertEquals(genomeTree2.rootNode.left.left, null);
    }

}