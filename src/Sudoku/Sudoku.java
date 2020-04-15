package Sudoku;

import Sudoku.Utils.Stack;
import Sudoku.Utils.UnableToSolveSudokuBoardException;

public class Sudoku {

    private int[][] board;
    private int size = 9;

    //Default constructor, creates an empty board.
    public Sudoku() {
        this.board = new int[size][size];
    }

    //Constructor, creates a board from values.
    public Sudoku(int[][] board){
        setBoard(board);
    }

    //Solve using recursive backtracking method.
    public int[][] solve() throws UnableToSolveSudokuBoardException {
        if (solveNext()) return board;
        throw new UnableToSolveSudokuBoardException();
    }

    //Auxiliary method to recursive backtracking method.
       private boolean solveNext(){
        Stack<Integer[]> emptyPositions = findEmptyPositions();

        while (!emptyPositions.isEmpty()) {

            //get the top empty position from the stack.
            Integer[] position = emptyPositions.peek();
            int row = position[0];
            int col = position[1];

            for (int value = 1; value <= size; value++) {
                if (isPositionValid(row, col, value)){

                    //value is valid, we can set it to the board.
                    board[row][col] = value;

                    //recursive backtracking
                    if(solveNext()) {

                        //if the value leads to a solution, pop it from the stack.
                        emptyPositions.pop();
                        return true;
                    }
                    else board[row][col] = 0;

                }
            }
            return false;
        }
        return true;
    }

    //Finds all empty positions in the board and pushes them into a dynamic stack in the form {row, col}.
    private Stack<Integer[]> findEmptyPositions() {
        Stack<Integer[]> stack = new Stack<Integer[]>();

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                //check if a position is empty
                if (board[row][col] == 0) {
                    stack.push(new Integer[]{row, col});
                }
            }
        }
        return stack;
    }

    //Checks if it's valid to set a value in a position.
    public boolean isPositionValid(int row, int col, int value){
        return !isInRow(row, value) && !isInCol(col, value) && !isInBox(row, col, value);
    }

    //Checks if a value is already in a row.
    private boolean isInRow(int row, int value) {
        for(int i = 0; i < size; i++){
            if (board[row][i] == value) return true;
        }
        return false;
    }

    //Checks if a value is already in a column.
    private boolean isInCol(int col, int value) {
        for(int i = 0; i < size; i++){
            if (board[i][col] == value) return true;
        }
        return false;
    }

    //Checks if a value is already in a box.
    private boolean isInBox(int row, int col, int value) {
        int r = row - row % 3;
        int c = col - col % 3;

        for (int i = r; i < r + 3; i++){
            for (int j = c; j < c + 3; j++){
                if (board[i][j] == value) return true;
            }
        }
        return false;
    }

    //Getter.
    public int[][] getBoard(){
        return board;
    }

    //Setter, sets a board from values.
    public void setBoard(int[][] board) {
        this.board = board;
    }

    //Setter, sets a value in a given position of the board.
    public void setBoard(int row, int col, int value) {
        this.board[row][col] = value;
    }

}