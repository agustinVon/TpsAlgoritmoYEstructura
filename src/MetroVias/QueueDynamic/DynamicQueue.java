package MetroVias.QueueDynamic;

public class DynamicQueue<T> implements Queue<T> {

    int ammount=0;
    DynamicNode<T> frontNode;
    DynamicNode<T> backNode;

    @Override
    public void enqueue(T t) {
        DynamicNode<T> newNode =new DynamicNode<>(t);
        if(ammount==0){
            frontNode=newNode;
            backNode=newNode;
        }
        else{
            backNode.next=newNode;
            backNode=newNode;
        }
        ammount++;
    }

    @Override
    public T dequeue() {
        if(ammount>1){
            T data=frontNode.data;
            frontNode=frontNode.next;
            ammount--;
            return data;
        }
        else if(ammount==1){
            T data=frontNode.data;
            frontNode=null;
            backNode=null;
            ammount--;
            return data;
        }
        else throw new RuntimeException();
    }

    @Override
    public boolean isEmpty() {
        return ammount==0;
    }

    @Override
    public int length() {
        return ammount;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void empty() {
        ammount=0;
        frontNode=null;
        backNode=null;
    }
}
