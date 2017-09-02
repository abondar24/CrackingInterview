package org.abondar.experimental.crackinginterview.tests;

import org.abondar.experimental.crackinginterview.Lists;
import org.abondar.experimental.crackinginterview.Node;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ListsTest {

    private Lists ll = new Lists();

    @Test
    public void removeDupsTest(){
        Node head = new Node(1);

        Node next1 = new Node(1);
        head.setNext(next1);

        Node next2 = new Node(2);
        next1.setNext(next2);

        Node next3 = new Node(3);
        next2.setNext(next3);


        Node expectedHead = new Node(1);
        expectedHead.setNext(next2);

        Node actualHead = ll.removeDups(head);
        Assert.assertEquals(expectedHead.getNext(),actualHead.getNext());


    }

    @Test
    public void removeDupsMiddleTest(){
        Node head = new Node(1);

        Node next1 = new Node(2);
        head.setNext(next1);

        Node next2 = new Node(1);
        next1.setNext(next2);

        Node next3 = new Node(3);
        next2.setNext(next3);

        Node actualNext2 = ll.removeDups(head).getNext().getNext();
        Assert.assertEquals(next3,actualNext2);
    }


    @Test
    public void kToLastTest(){
        Node head = new Node(1);

        Node next = new Node(2);
        head.setNext(next);

        Node next1 = new Node(3);
        next.setNext(next1);

        Node next2 = new Node(4);
        next1.setNext(next2);

        Node next3 = new Node(5);
        next2.setNext(next3);

        Node res =ll.kToLast(head,2);

        Assert.assertEquals(next2,res);
    }


    @Test
    public void kToLastTestRetLast(){
        Node head = new Node(1);

        Node next = new Node(2);
        head.setNext(next);

        Node next1 = new Node(3);
        next.setNext(next1);

        Node next2 = new Node(4);
        next1.setNext(next2);

        Node next3 = new Node(5);
        next2.setNext(next3);

        Node res =ll.kToLast(head,1);

        Assert.assertEquals(next3,res);
    }

    @Test
    public void kToLastTestRetNull(){
        Node head = new Node(1);

        Node next = new Node(2);
        head.setNext(next);

        Node next1 = new Node(3);
        next.setNext(next1);

        Node next2 = new Node(4);
        next1.setNext(next2);

        Node next3 = new Node(5);
        next2.setNext(next3);

        Node res =ll.kToLast(head,7);

        Assert.assertEquals(null,res);
    }

}
