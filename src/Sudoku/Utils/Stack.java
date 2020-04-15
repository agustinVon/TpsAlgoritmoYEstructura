package Sudoku.Utils;

import Sudoku.Sudoku;
import Sudoku.Utils.IStack;

public class Stack<T> implements IStack<T> {

    private class Node<S> {

        public S data;
        public Node<S> next;

        public Node(S data, Node<S> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<T> top;
    private int size;

    @Override
    public void push(T t) {
        this.top = new Node<>(t, this.top);
        this.size++;
    }

    @Override
    public void pop() {
        if(this.top != null){
            this.top = this.top.next;
            this.size--;
        }
    }

    @Override
    public T peek() {
        return this.top.data;
    }

    @Override
    public boolean isEmpty() {
        return (this.top == null);
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void empty() {
        this.top = null;
        this.size = 0;
    }

}