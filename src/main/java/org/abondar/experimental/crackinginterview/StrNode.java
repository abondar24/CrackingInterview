package org.abondar.experimental.crackinginterview;

public class StrNode {
    private StrNode next=null;
    private String data;


    public StrNode(String data) {
        this.data = data;
    }

    public void appendToTail(String data){
        StrNode end = new StrNode(data);
        StrNode n = this;
        while (n.next!=null){
            n = n.next;
        }

        n.setNext(end);
    }

    public StrNode getNext() {
        return next;
    }

    public void setNext(StrNode next) {
        this.next = next;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "StrNode{" +
                "next=" + next +
                ", data='" + data + '\'' +
                '}';
    }
}
