package org.abondar.experimental.crackinginterview;

public class IntNode {

    private IntNode next=null;
    private int data;


    public IntNode(int data) {
        this.data = data;
    }

    public void appendToTail(int data){
        IntNode end = new IntNode(data);
        IntNode n = this;
        while (n.next!=null){
            n = n.next;
        }

        n.setNext(end);
    }

    public IntNode getNext() {
        return next;
    }

    public void setNext(IntNode next) {
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
        return "IntNode{" +
                "next=" + next +
                ", data=" + data +
                '}';
    }
}
