package org.abondar.experimental.tasks.stacksqueues;

import java.util.EmptyStackException;

public class CustomStack<T> {
    private static class StackNode<T> {
        private T data;
        private StackNode<T> next;

        public StackNode(T data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "StackNode{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }

    private StackNode<T> top;

    public T pop() {
        if (top == null) throw new EmptyStackException();
        T item = top.data;
        top = top.next;
        return item;
    }

    public void push(T item){
        StackNode<T> t = new StackNode<>(item);
        t.next = top;
        top = t;
    }

    public T peek(){
        if (top == null) throw new EmptyStackException();
        return top.data;
    }

    public boolean isEmpty(){
        return top==null;
    }

    @Override
    public String toString() {
        return "CustomStack{" +
                "top=" + top +
                '}';
    }
}