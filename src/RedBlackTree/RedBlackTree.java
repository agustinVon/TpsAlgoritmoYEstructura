package RedBlackTree;

public class RedBlackTree<T extends Comparable<T>> {

    private ColorNode<T> root;
    private ColorNode<T> current;
    private ColorNode<T> parent;
    private ColorNode<T> grand;
    private ColorNode<T> great;

    public RedBlackTree(){
    }

    public RedBlackTree(T element){
        root=new ColorNode<T>(element,null);
        current=root;
        parent=root;
        grand=root;
        great=root;
    }

    public boolean isEmpty(){
        if(root==null) return true;
        else return false;
    }

    public void insert(T element){
        if(isEmpty()){
            root=new ColorNode<T>(element,null);
            root.changeColor();
        }
        else{
            insert(element,root,null);

        }
    }

    private void insert(T element, ColorNode<T> node,ColorNode<T> parent) {
        if(node.element==null){
            node=new ColorNode<T>(element,parent);
        }
        else if(element.compareTo(node.element)>=0){
            insert(element,node.rightChild,node);
        }
        else{
            insert(element,node.leftChild,node);
        }
    }

}
