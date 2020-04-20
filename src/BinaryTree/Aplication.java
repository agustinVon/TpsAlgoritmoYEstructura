package BinaryTree;

public class Aplication<T> {

    public Aplication(){

    }

    public int getSize(BinaryTree<T> binaryTree){
        if(binaryTree.isEmpty()){
            return 0;
        }
        return 1 + getSize(binaryTree.getRight()) + getSize(binaryTree.getLeft());
    }

    public int getCompleteNodes(BinaryTree<T> binaryTree){
        if(binaryTree.isEmpty() || (binaryTree.getLeft().isEmpty() && binaryTree.getRight().isEmpty())){
            return 0;
        }
        if(binaryTree.getRight().isEmpty()){
            return getCompleteNodes(binaryTree.getLeft());
        }
        if(binaryTree.getLeft().isEmpty()){
            return getCompleteNodes(binaryTree.getRight());
        }
        return 1 + getCompleteNodes(binaryTree.getRight()) + getCompleteNodes(binaryTree.getLeft());
    }

    public int find(BinaryTree<T> binaryTree, T element){
        if(binaryTree.isEmpty()){
            return 0;
        }
        if(binaryTree.getRoot().equals(element)){
            return 1 + find(binaryTree.getRight(), element) + find(binaryTree.getLeft(), element);
        }
        return find(binaryTree.getRight(), element) + find(binaryTree.getLeft(), element);
    }

    public int elementsAt(BinaryTree<T> binaryTree, int level){
        return elementsAtAuxMethod(binaryTree,level,0);
    }

    public int elementsAtAuxMethod(BinaryTree<T> binaryTree, int level,int currentLevel){
        if(binaryTree.isEmpty()){
            return 0;
        }
        else if(level==currentLevel) return 1;
        else return elementsAtAuxMethod(binaryTree.getLeft(),level,currentLevel++)
                    +elementsAtAuxMethod(binaryTree.getRight(),level,currentLevel++);
    }

    public int height(BinaryTree<T> binaryTree){
        if(binaryTree.isEmpty()){
            return 0;
        }
        else{
            return height(binaryTree.root);
        }
    }

    public int height(DoubleNode node){
        if (node == null) {
            return -1;
        }
        int heightLeft = height(node.left);
        int heightRight = height(node.right);

        if (heightLeft > heightRight) {
            return heightLeft + 1;
        } else {
            return heightRight + 1;
        }
    }

    public int sumOfElements(BinaryTree<Integer> binaryTree){
        return 0;
    }
}
