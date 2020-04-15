package Sudoku.PilaDynamic;

import ChessHorse.DynamicNode;
import ChessHorse.StackDynamic;
import org.junit.Assert;
import org.junit.Test;

public class StackDynamicTest {

    @Test
    public void whenCalculatingStackSizeShouldSucced(){
        StackDynamic<TestObject> stackDynamic=new StackDynamic<>();
        stackDynamic.push(new DynamicNode(new TestObject("1")));
        stackDynamic.push(new DynamicNode(new TestObject("2")));

        Assert.assertEquals(2,stackDynamic.size());
    }

    @Test
    public void whenCalculatingEmptyStackSizeShouldSucced(){
        StackDynamic<TestObject> stackDynamic=new StackDynamic<>();
        stackDynamic.push(new DynamicNode(new TestObject("1")));
        stackDynamic.push(new DynamicNode(new TestObject("2")));
        stackDynamic.empty();

        Assert.assertEquals(0,stackDynamic.size());
    }


}