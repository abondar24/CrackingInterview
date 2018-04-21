package org.abondar.experimental.crackinginterview.tests;

import org.abondar.experimental.crackinginterview.lists.Node;
import org.abondar.experimental.crackinginterview.lists.Lists;
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

    @Test
    public void  sumListsReverseTest(){
        //it represents 617
        Node<Integer> n1 = new Node<>(7);
        Node<Integer> n1Next = new Node<>(1);
        Node<Integer> n1Next1 = new Node<>(6);
        n1.setNext(n1Next);
        n1Next.setNext(n1Next1);

        //it represents 295
        Node<Integer> n2 = new Node<>(5);
        Node<Integer> n2Next = new Node<>(9);
        Node<Integer> n2Next1 = new Node<>(2);
        n2.setNext(n2Next);
        n2Next.setNext(n2Next1);

        //ExpectedSum
        Node<Integer> sum = new Node<>(2);
        Node<Integer> sumNext = new Node<>(1);
        Node<Integer> sumNext1 = new Node<>(9);
        sum.setNext(sumNext);
        sumNext.setNext(sumNext1);


        Node actualSum = ll.sumListsReverse(n1,n2);
        Assert.assertEquals(sum.toString(),actualSum.toString());
    }

    @Test
    public void  sumListsStraightTest(){
        //it represents 617
        Node<Integer> n1 = new Node<>(6);
        Node<Integer> n1Next = new Node<>(1);
        Node<Integer> n1Next1 = new Node<>(7);
        n1.setNext(n1Next);
        n1Next.setNext(n1Next1);

        //it represents 295
        Node<Integer> n2 = new Node<>(2);
        Node<Integer> n2Next = new Node<>(9);
        Node<Integer> n2Next1 = new Node<>(5);
        n2.setNext(n2Next);
        n2Next.setNext(n2Next1);

        //ExpectedSum
        Node<Integer> sum = new Node<>(9);
        Node<Integer> sumNext = new Node<>(1);
        Node<Integer> sumNext1 = new Node<>(2);
        sum.setNext(sumNext);
        sumNext.setNext(sumNext1);


        Node actualSum = ll.sumListsStraight(n1,n2);
        Assert.assertEquals(sum.toString(),actualSum.toString());
    }


    @Test
    public void checkPalindromeTestInt(){
        Node<Integer> head = new Node<>(0);
        Node<Integer> next = new Node<>(1);
        Node<Integer> next1 = new Node<>(2);
        Node<Integer> next2 = new Node<>(1);
        Node<Integer> next3 = new Node<>(0);

        head.setNext(next);
        next.setNext(next1);
        next1.setNext(next2);
        next2.setNext(next3);

        boolean isPalindrome = ll.checkPalindrome(head);
        Assert.assertTrue(isPalindrome);
    }

    @Test
    public void checkPalindromeTestStr(){
        Node<String> head = new Node<>("a");
        Node<String> next = new Node<>("b");
        Node<String> next1 = new Node<>("b");
        Node<String> next2 = new Node<>("a");

        head.setNext(next);
        next.setNext(next1);
        next1.setNext(next2);

        boolean isPalindrome = ll.checkPalindrome(head);
        Assert.assertTrue(isPalindrome);
    }

    @Test
    public void checkPalindromeTestNotPalindrome(){
        Node<Integer> head = new Node<>(0);
        Node<Integer> next = new Node<>(1);
        Node<Integer> next1 = new Node<>(2);
        Node<Integer> next2 = new Node<>(1);
        Node<Integer> next3 = new Node<>(2);

        head.setNext(next);
        next.setNext(next1);
        next1.setNext(next2);
        next2.setNext(next3);

        boolean isPalindrome = ll.checkPalindrome(head);
        Assert.assertFalse(isPalindrome);
    }


    @Test
    public void detectLoopTest(){
        Node<String> head = new Node<>("a");
        Node<String> next = new Node<>("b");
        Node<String> next1 = new Node<>("c");
        Node<String> next2 = new Node<>("d");
        Node<String> next3 = new Node<>("e");

        head.setNext(next);
        next.setNext(next1);
        next1.setNext(next2);
        next1.setNext(next3);
        next3.setNext(next1);

        Node loop = ll.detectLoop(head);
        Assert.assertEquals(next1,loop);

    }

    @Test
    public void detectLoopTestNoLoop(){
        Node<String> head = new Node<>("a");
        Node<String> next = new Node<>("b");
        Node<String> next1 = new Node<>("c");
        Node<String> next2 = new Node<>("d");
        Node<String> next3 = new Node<>("e");

        head.setNext(next);
        next.setNext(next1);
        next1.setNext(next2);
        next1.setNext(next3);

        Node loop = ll.detectLoop(head);
        Assert.assertEquals(null,loop);

    }


    @Test
    public void checkIntersection(){
        Node<Integer> head1 = new Node<>(3);
        Node<Integer> next = new Node<>(1);
        Node<Integer> next1 = new Node<>(5);
        Node<Integer> next2 = new Node<>(6);
        Node<Integer> next3 = new Node<>(7);

        head1.setNext(next);
        next.setNext(next1);
        next1.setNext(next2);
        next2.setNext(next3);

        Node<Integer> head2 = new Node<>(4);
        Node<Integer> next4 = new Node<>(6);
        Node<Integer> next5 =  next3;
        Node<Integer> next6 = new Node<>(2);
        Node<Integer> next7 = new Node<>(1);

        head2.setNext(next4);
        next4.setNext(next5);
        next5.setNext(next6);
        next6.setNext(next7);


        boolean hasIntersection = ll.hasIntersection(head1,head2);
        Assert.assertTrue(hasIntersection);
    }

    @Test
    public void checkIntersectionNoInter(){
        Node<Integer> head1 = new Node<>(3);
        Node<Integer> next = new Node<>(1);
        Node<Integer> next1 = new Node<>(5);
        Node<Integer> next2 = new Node<>(6);
        Node<Integer> next3 = new Node<>(7);

        head1.setNext(next);
        next.setNext(next1);
        next1.setNext(next2);
        next2.setNext(next3);

        Node<Integer> head2 = new Node<>(4);
        Node<Integer> next4 = new Node<>(6);
        Node<Integer> next5 =  new Node<>(7);
        Node<Integer> next6 = new Node<>(2);
        Node<Integer> next7 = new Node<>(1);

        head2.setNext(next4);
        next4.setNext(next5);
        next5.setNext(next6);
        next6.setNext(next7);


        boolean hasIntersection = ll.hasIntersection(head1,head2);
        Assert.assertFalse(hasIntersection);
    }

}
