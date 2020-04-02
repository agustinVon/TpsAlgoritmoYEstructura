package Sudoku;

public class Board {

    Block[][] boardRowAndColumns;

    Board(){
        boardRowAndColumns= new Block[9][9];
    }

    public void setValues(int row, int column,int value){
        boardRowAndColumns[row][column].setVelue(value);
    }

}
