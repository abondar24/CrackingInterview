package org.abondar.experimental.crackinginterview.tests;

import org.abondar.experimental.crackinginterview.Node;
import org.abondar.experimental.crackinginterview.Lists;
import org.junit.Assert;
import org.junit.Test;

public class ListsTest {

    private Lists ll = new Lists();

    @Test
    public void removeDupsTest() {
        Node<Integer> head = new Node<>(1);

        Node<Integer> next1 = new Node<>(1);
        head.setNext(next1);

        Node<Integer> next2 = new Node<>(2);
        next1.setNext(next2);

        Node<Integer> next3 = new Node<>(3);
        next2.setNext(next3);


        Node expectedHead = new Node<>(1);
        expectedHead.setNext(next2);

        Node actualHead = ll.removeDups(head);
        Assert.assertEquals(expectedHead.getNext(), actualHead.getNext());


    }

    @Test
    public void removeDupsMiddleTest() {
        Node<Integer> head = new Node<>(1);

        Node<Integer> next1 = new Node<>(2);
        head.setNext(next1);

        Node<Integer> next2 = new Node<>(1);
        next1.setNext(next2);

        Node<Integer> next3 = new Node<>(3);
        next2.setNext(next3);

        Node<Integer> actualNext2 = ll.removeDups(head).getNext().getNext();
        Assert.assertEquals(next3, actualNext2);
    }


    @Test
    public void kToLastTest() {
        Node<Integer> head = new Node<>(1);

        Node<Integer> next = new Node<>(2);
        head.setNext(next);

        Node<Integer> next1 = new Node<>(3);
        next.setNext(next1);

        Node<Integer> next2 = new Node<>(4);
        next1.setNext(next2);

        Node<Integer> next3 = new Node<>(5);
        next2.setNext(next3);

        Node res = ll.kToLast(head, 2);

        Assert.assertEquals(next2, res);

    }


    @Test
    public void kToLastTestRetLast() {
        Node<Integer> head = new Node<>(1);

        Node<Integer> next = new Node<>(2);
        head.setNext(next);

        Node<Integer> next1 = new Node<>(3);
        next.setNext(next1);

        Node<Integer> next2 = new Node<>(4);
        next1.setNext(next2);

        Node<Integer> next3 = new Node<>(5);
        next2.setNext(next3);

        Node res = ll.kToLast(head, 1);

        Assert.assertEquals(next3, res);
    }

    @Test
    public void kToLastTestRetNull() {
        Node<Integer> head = new Node<>(1);

        Node<Integer> next = new Node<>(2);
        head.setNext(next);

        Node<Integer> next1 = new Node<>(3);
        next.setNext(next1);

        Node<Integer> next2 = new Node<>(4);
        next1.setNext(next2);

        Node<Integer> next3 = new Node<>(5);
        next2.setNext(next3);

        Node res = ll.kToLast(head, 7);

        Assert.assertEquals(null, res);
    }


    @Test
    public void deleteMiddleNodeTest() {

        Node<String> head = new Node<>("a");

        Node<String> b = new Node<>("b");
        head.setNext(b);

        Node<String> c = new Node<>("c");
        b.setNext(c);

        Node<String> d = new Node<>("d");
        c.setNext(d);

        Node<String> e = new Node<>("e");
        d.setNext(e);

        Node<String> f = new Node<>("f");
        e.setNext(f);

        Node res = ll.deleteMiddleNode(d);
        Assert.assertEquals(e, res);


        res = ll.deleteMiddleNode(f);
        Assert.assertEquals(res, f);

    }

}
