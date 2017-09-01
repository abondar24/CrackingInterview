package org.abondar.experimental.crackinginterview;

public class Node {

    private Node next=null;
    private int data;


    public Node(int data) {
        this.data = data;
    }

    public void appendToTail(int data){
        Node end = new Node(data);
        Node n = this;
        while (n.next!=null){
            n = n.next;
        }

        n.setNext(end);
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "next=" + next +
                ", data=" + data +
                '}';
    }
}
