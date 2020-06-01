package MetroVias.PilaStatic;

public class StackStatic<T> implements Stack<T>{

    T array[];
    int top;

    public StackStatic(){
        this.array=(T[]) new Object[5];
        top=-1;
    }

    @Override
    public void push(T t) {
        if(top+1>array.length-1){
            array=dobleSizeArray(array);
        }
        array[top+1]=t;
        top++;
    }

    @Override
    public void pop() {
        top--;
    }

    @Override
    public T peek() {
        return array[top];
    }

    @Override
    public boolean isEmpty() {
        if(top==-1) return true;
        else return false;
    }

    @Override
    public int size() {
        return top+1;
    }

    @Override
    public void empty() {
        top=-1;
    }

    private T[] dobleSizeArray(T[] array){
        T[] dobleArray=(T[]) new Object[array.length*2];
        for (int i = 0; i < array.length; i++) {
            dobleArray[i]=array[i];
        }
        return dobleArray;
    }
}
