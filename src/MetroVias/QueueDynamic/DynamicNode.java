package MetroVias.QueueDynamic;

public class DynamicNode<T> {

    public T data;
    public DynamicNode<T> next;

    public DynamicNode(T data){
        this.data=data;
    }
}
