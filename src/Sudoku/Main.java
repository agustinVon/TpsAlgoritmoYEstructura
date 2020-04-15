package Sudoku;

import Sudoku.Utils.UnableToSolveSudokuBoardException;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[][] board = {
                {8,0,0,0,0,0,0,0,0},
                {0,0,3,6,0,0,0,0,0},
                {0,7,0,0,9,0,2,0,0},
                {0,5,0,0,0,7,0,0,0},
                {0,0,0,0,4,5,7,0,0},
                {0,0,0,1,0,0,0,3,0},
                {0,0,1,0,0,0,0,6,8},
                {0,0,8,5,0,0,0,1,0},
                {0,9,0,0,0,0,4,0,0},
        };

        try {
            Sudoku sudoku = new Sudoku(board);
            sudoku.solve();
            System.out.println(Arrays.deepToString(sudoku.getBoard()));

        } catch (UnableToSolveSudokuBoardException e) {
            e.printStackTrace();
        }
    }
}
