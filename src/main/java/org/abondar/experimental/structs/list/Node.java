package org.abondar.experimental.structs.list;

public class Node<T> {

    private Node next = null;
    private T data;


    public Node(T data) {
        this.data = data;
    }



    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "next=" + next +
                ", data=" + data +
                '}';
    }
}
