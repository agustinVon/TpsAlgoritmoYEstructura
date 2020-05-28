package MetroVias.PilaStatic;

import org.junit.Assert;
import org.junit.Test;

public class StackStaticTest {

    @Test
    public void whenCalculatingSizeShouldSucced(){
        StackStatic<TestObject> stack=new StackStatic<>();

        stack.push(new TestObject("1"));
        stack.push(new TestObject("2"));
        stack.push(new TestObject("3"));
        stack.push(new TestObject("4"));
        stack.push(new TestObject("5"));
        stack.push(new TestObject("6"));


        Assert.assertEquals(6,stack.size());
    }

}