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
           current = insert(element,root,null);
           if(!current.parent.getColor()){
               return;
           }
           else{
               if(current.parent.parent.leftChild==null||current.parent.parent.rightChild==null){
                   if(current.parent.parent.leftChild==current.parent){
                       if(current.parent.leftChild==current){
                           current=Rotation.rotateRight(current.parent.parent);
                           current.changeColor();
                           current.rightChild.changeColor();
                       }
                       else{
                           current=Rotation.doubleRotationLeft(current.parent.parent);
                           current.changeColor();
                           current.rightChild.changeColor();
                       }
                   }
                   else{
                       if(current.parent.leftChild==current){
                           current= Rotation.doubleRotationRight(current.parent.parent);
                           current.changeColor();
                           current.leftChild.changeColor();
                       }
                       else{
                           current=Rotation.rotateLeft(current.parent.parent);
                           current.changeColor();
                           current.leftChild.changeColor();
                       }
                   }
               }
               else if(current.parent.parent.leftChild.getColor()&&current.parent.parent.rightChild.getColor()){
                   current.parent.parent.leftChild.changeColor();
                   current.parent.parent.rightChild.changeColor();
               }
               else if(!current.parent.parent.rightChild.getColor()){
                   if(current.parent.leftChild==current){
                       current = Rotation.rotateRight(current.parent.parent);
                       current.changeColor();
                       current.rightChild.changeColor();
                   }
                   else{
                       current= Rotation.doubleRotationLeft(current.parent.parent);
                       current.changeColor();
                       current.rightChild.changeColor();
                   }
               }
               else{
                   if(current.parent.leftChild==current){
                       current = Rotation.rotateLeft(current.parent.parent);
                       current.changeColor();
                       current.leftChild.changeColor();
                   }
                   else{
                       current= Rotation.doubleRotationRight(current.parent.parent);
                       current.changeColor();
                       current.leftChild.changeColor();
                   }
               }
           }
        }
    }

    private ColorNode<T> insert(T element, ColorNode<T> node,ColorNode<T> parent) {
        if(node.element==null){
            node=new ColorNode<T>(element,parent);
            return node;
        }
        else if(element.compareTo(node.element)>=0){
            insert(element,node.rightChild,node);
        }
        else{
            insert(element,node.leftChild,node);
        }
        throw new RuntimeException();
    }

}
