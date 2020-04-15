package Sudoku.Utils;

import Sudoku.Sudoku;

public interface IStack<T> {
    void push(T t);
    void pop();
    T peek();
    boolean isEmpty();
    int size();
    void empty();
}