package org.abondar.experimental.crackinginterview.tests;

import org.abondar.experimental.crackinginterview.IntNode;
import org.abondar.experimental.crackinginterview.Lists;
import org.abondar.experimental.crackinginterview.StrNode;
import org.junit.Assert;
import org.junit.Test;

public class ListsTest {

    private Lists ll = new Lists();

    @Test
    public void removeDupsTest() {
        IntNode head = new IntNode(1);

        IntNode next1 = new IntNode(1);
        head.setNext(next1);

        IntNode next2 = new IntNode(2);
        next1.setNext(next2);

        IntNode next3 = new IntNode(3);
        next2.setNext(next3);


        IntNode expectedHead = new IntNode(1);
        expectedHead.setNext(next2);

        IntNode actualHead = ll.removeDups(head);
        Assert.assertEquals(expectedHead.getNext(), actualHead.getNext());


    }

    @Test
    public void removeDupsMiddleTest() {
        IntNode head = new IntNode(1);

        IntNode next1 = new IntNode(2);
        head.setNext(next1);

        IntNode next2 = new IntNode(1);
        next1.setNext(next2);

        IntNode next3 = new IntNode(3);
        next2.setNext(next3);

        IntNode actualNext2 = ll.removeDups(head).getNext().getNext();
        Assert.assertEquals(next3, actualNext2);
    }


    @Test
    public void kToLastTest() {
        IntNode head = new IntNode(1);

        IntNode next = new IntNode(2);
        head.setNext(next);

        IntNode next1 = new IntNode(3);
        next.setNext(next1);

        IntNode next2 = new IntNode(4);
        next1.setNext(next2);

        IntNode next3 = new IntNode(5);
        next2.setNext(next3);

        IntNode res = ll.kToLast(head, 2);

        Assert.assertEquals(next2, res);

    }


    @Test
    public void kToLastTestRetLast() {
        IntNode head = new IntNode(1);

        IntNode next = new IntNode(2);
        head.setNext(next);

        IntNode next1 = new IntNode(3);
        next.setNext(next1);

        IntNode next2 = new IntNode(4);
        next1.setNext(next2);

        IntNode next3 = new IntNode(5);
        next2.setNext(next3);

        IntNode res = ll.kToLast(head, 1);

        Assert.assertEquals(next3, res);
    }

    @Test
    public void kToLastTestRetNull() {
        IntNode head = new IntNode(1);

        IntNode next = new IntNode(2);
        head.setNext(next);

        IntNode next1 = new IntNode(3);
        next.setNext(next1);

        IntNode next2 = new IntNode(4);
        next1.setNext(next2);

        IntNode next3 = new IntNode(5);
        next2.setNext(next3);

        IntNode res = ll.kToLast(head, 7);

        Assert.assertEquals(null, res);
    }


    @Test
    public void deleteMiddleNodeTest() {

        StrNode head = new StrNode("a");

        StrNode b = new StrNode("b");
        head.setNext(b);

        StrNode c = new StrNode("c");
        b.setNext(c);

        StrNode d = new StrNode("d");
        c.setNext(d);

        StrNode e = new StrNode("e");
        d.setNext(e);

        StrNode f = new StrNode("f");
        e.setNext(f);

        StrNode res = ll.deleteMiddleNode(d);
        Assert.assertEquals(e, res);


        res = ll.deleteMiddleNode(f);
        Assert.assertEquals(res, f);

    }

}
