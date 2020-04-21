package ChessHorse;

public class StackDynamic<T> implements Stack<DynamicNode> {

    DynamicNode<T> top;

    @Override
    public void push(DynamicNode dynamicNode) {
        dynamicNode.next=top;
        top=dynamicNode;
    }

    @Override
    public void pop() {
        if(top!=null)
        top=top.next;
    }

    @Override
    public DynamicNode peek() {
        return top;
    }

    @Override
    public boolean isEmpty() {
        if(top==null) return true;
        else return false;
    }

    @Override
    public int size() {
        DynamicNode<T> aux;
        aux=top;
        int size=0;
        while(aux!=null){
            aux=aux.next;
            size++;
        }
        return size;
    }

    @Override
    public void empty() {
        while (top!=null){
            pop();
        }
    }
}
