package Sudoku;

public class Block {

    int value;


    Block(){
        this.value=0;
    }

    public void setVelue(int value){
        this.value=value;
    }

    public int getValue() {
        return value;
    }

    public boolean checkIfItsPosible(Block blockToCompare){
        return blockToCompare.getValue()==this.value;
    }

}
