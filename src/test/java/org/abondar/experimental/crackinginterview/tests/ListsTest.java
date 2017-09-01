package org.abondar.experimental.crackinginterview.tests;

import org.abondar.experimental.crackinginterview.Lists;
import org.abondar.experimental.crackinginterview.Node;
import org.junit.Assert;
import org.junit.Test;

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

        Node expectedNext2 = next3;
        Node actualNext2 = ll.removeDups(head).getNext().getNext();
        Assert.assertEquals(expectedNext2,actualNext2);
    }
}
