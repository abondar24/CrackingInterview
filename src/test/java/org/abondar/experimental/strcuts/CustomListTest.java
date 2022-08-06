package org.abondar.experimental.strcuts;

import org.abondar.experimental.structs.list.CustomList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CustomListTest {


    @Test
    public void initListTest() {
        CustomList<Integer> customList = new CustomList<>(1);
        assertEquals(1, customList.getRoot().getVal());
    }

    @Test
    public void findNodeTest() {
        CustomList<Integer> customList = new CustomList<>(1);
        CustomList.ListNode<Integer> resNode = customList.findNode(1);
        assertEquals(1, resNode.getVal());
    }


    @Test
    public void addToEndTest() {
        CustomList<Integer> customList = new CustomList<>(1);
        customList.addToEnd(2);
        CustomList.ListNode<Integer> resNode = customList.findNode(2);
        assertEquals(2, resNode.getVal());
    }

    @Test
    public void addToMiddleTest() {
        CustomList<Integer> customList = new CustomList<>(1);
        customList.addToEnd(2);
        customList.addToMiddle(1, 3);

        CustomList.ListNode<Integer> lastNode = customList.findNode(2);
        assertEquals(2, lastNode.getVal());
        assertNull(lastNode.getNext());

    }

    @Test
    public void deleteNodeTest() {
        CustomList<String> stringCustomList = new CustomList<>("a");
        stringCustomList.addToEnd("b");
        stringCustomList.addToEnd("c");
        stringCustomList.addToEnd("d");

        stringCustomList.deleteNode("c");

        CustomList.ListNode<String> resNode = stringCustomList.findNode("b");
        assertEquals("d", resNode.getNext().getVal());

    }

    @Test
    public void removeDuplicatesTest() {
        CustomList<Integer> customList = new CustomList<>(1);
        customList.addToEnd(1);
        customList.addToEnd(2);
        customList.addToEnd(3);

        customList.removeDuplicates();

        assertEquals(2, customList.getRoot().getNext().getVal());

    }

    @Test
    public void removeDuplicatesMiddleTest() {
        CustomList<Integer> customList = new CustomList<>(1);
        customList.addToEnd(2);
        customList.addToEnd(1);
        customList.addToEnd(3);

        customList.removeDuplicates();

        CustomList.ListNode<Integer> resNode = customList.findNode(2);

        assertEquals(3, resNode.getNext().getVal());
    }

    @Test
    public void deleteDuplicatesTest() {
        CustomList<Integer> customList = new CustomList<>(1);
        customList.addToEnd(1);
        customList.addToEnd(2);
        customList.addToEnd(3);

        customList.deleteDuplicates();

        assertEquals(2, customList.getRoot().getNext().getVal());
    }


    @Test
    public void kToLastTest() {
        CustomList<Integer> customList = new CustomList<>(1);
        customList.addToEnd(2);
        customList.addToEnd(3);
        customList.addToEnd(4);
        customList.addToEnd(5);

        CustomList.ListNode<Integer> res = customList.kToLast(2);
        assertEquals(4, res.getVal());
        assertEquals(5,res.getNext().getVal());

    }


    @Test
    public void kToLastTestRetLast() {
        CustomList<Integer> customList = new CustomList<>(1);
        customList.addToEnd(2);
        customList.addToEnd(3);
        customList.addToEnd(4);
        customList.addToEnd(5);

        CustomList.ListNode<Integer> res = customList.kToLast(1);

        assertEquals(5, res.getVal());
    }

    @Test
    public void kToLastTestRetNull() {
        CustomList<Integer> customList = new CustomList<>(1);
        customList.addToEnd(2);
        customList.addToEnd(3);
        customList.addToEnd(4);
        customList.addToEnd(5);

        CustomList.ListNode<Integer> res = customList.kToLast(7);

        assertNull(res);
    }



    @Test
    public void sumListsReverseTest() {
        //it represents 617
        CustomList<Integer> n1 = new CustomList<>(7);
        n1.addToEnd(1);
        n1.addToEnd(6);

        //it represents 295
        CustomList<Integer> n2 = new CustomList<>(5);
        n2.addToEnd(9);
        n2.addToEnd(2);

        //ExpectedSum
        CustomList<Integer> sum = new CustomList<>(2);
        sum.addToEnd(1);
        sum.addToEnd(9);

    //    CustomList<Integer> res = n1.sumListsReverse(n2);
        CustomList<Integer> res = n1.sumLists(n2,true);

        assertEquals(sum.getRoot().getVal(),res.getRoot().getVal());
        assertEquals(sum.getRoot().getNext().getVal(),res.getRoot().getNext().getVal());
        assertEquals(sum.getRoot().getNext().getNext().getVal(),res.getRoot().getNext().getNext().getVal());

    }

    @Test
    public void sumListsStraightTest() {
        //it represents 617
        CustomList<Integer> n1 = new CustomList<>(6);
        n1.addToEnd(1);
        n1.addToEnd(7);

        //it represents 295
        CustomList<Integer> n2 = new CustomList<>(2);
        n2.addToEnd(9);
        n2.addToEnd(5);

        //ExpectedSum
        CustomList<Integer> sum = new CustomList<>(9);
        sum.addToEnd(1);
        sum.addToEnd(2);


        CustomList<Integer> res = n1.sumLists(n2,false);

        assertEquals(sum.getRoot().getVal(),res.getRoot().getVal());
        assertEquals(sum.getRoot().getNext().getVal(),res.getRoot().getNext().getVal());
        assertEquals(sum.getRoot().getNext().getNext().getVal(),res.getRoot().getNext().getNext().getVal());
    }


//    @Test
//    public void checkPalindromeTestInt() {
//        ListNode<Integer> head = new ListNode<>(0);
//        ListNode<Integer> next = new ListNode<>(1);
//        ListNode<Integer> next1 = new ListNode<>(2);
//        ListNode<Integer> next2 = new ListNode<>(1);
//        ListNode<Integer> next3 = new ListNode<>(0);
//
//        head.setNext(next);
//        next.setNext(next1);
//        next1.setNext(next2);
//        next2.setNext(next3);
//
//        boolean isPalindrome = ll.checkPalindrome(head);
//        assertTrue(isPalindrome);
//    }
//
//    @Test
//    public void checkPalindromeTestStr() {
//        ListNode<String> head = new ListNode<>("a");
//        ListNode<String> next = new ListNode<>("b");
//        ListNode<String> next1 = new ListNode<>("b");
//        ListNode<String> next2 = new ListNode<>("a");
//
//        head.setNext(next);
//        next.setNext(next1);
//        next1.setNext(next2);
//
//        boolean isPalindrome = ll.checkPalindrome(head);
//        assertTrue(isPalindrome);
//    }
//
//    @Test
//    public void checkPalindromeTestNotPalindrome() {
//        ListNode<Integer> head = new ListNode<>(0);
//        ListNode<Integer> next = new ListNode<>(1);
//        ListNode<Integer> next1 = new ListNode<>(2);
//        ListNode<Integer> next2 = new ListNode<>(1);
//        ListNode<Integer> next3 = new ListNode<>(2);
//
//        head.setNext(next);
//        next.setNext(next1);
//        next1.setNext(next2);
//        next2.setNext(next3);
//
//        boolean isPalindrome = ll.checkPalindrome(head);
//        assertFalse(isPalindrome);
//    }
//
//
//    @Test
//    public void detectLoopTest() {
//        ListNode<String> head = new ListNode<>("a");
//        ListNode<String> next = new ListNode<>("b");
//        ListNode<String> next1 = new ListNode<>("c");
//        ListNode<String> next2 = new ListNode<>("d");
//        ListNode<String> next3 = new ListNode<>("e");
//
//        head.setNext(next);
//        next.setNext(next1);
//        next1.setNext(next2);
//        next1.setNext(next3);
//        next3.setNext(next1);
//
//        ListNode loop = ll.detectLoop(head);
//        assertEquals(next1, loop);
//
//    }
//
//    @Test
//    public void detectLoopTestNoLoop() {
//        ListNode<String> head = new ListNode<>("a");
//        ListNode<String> next = new ListNode<>("b");
//        ListNode<String> next1 = new ListNode<>("c");
//        ListNode<String> next2 = new ListNode<>("d");
//        ListNode<String> next3 = new ListNode<>("e");
//
//        head.setNext(next);
//        next.setNext(next1);
//        next1.setNext(next2);
//        next1.setNext(next3);
//
//        ListNode loop = ll.detectLoop(head);
//        assertEquals(null, loop);
//
//    }
//
//
//    @Test
//    public void checkIntersection() {
//        ListNode<Integer> head1 = new ListNode<>(3);
//        ListNode<Integer> next = new ListNode<>(1);
//        ListNode<Integer> next1 = new ListNode<>(5);
//        ListNode<Integer> next2 = new ListNode<>(6);
//        ListNode<Integer> next3 = new ListNode<>(7);
//
//        head1.setNext(next);
//        next.setNext(next1);
//        next1.setNext(next2);
//        next2.setNext(next3);
//
//        ListNode<Integer> head2 = new ListNode<>(4);
//        ListNode<Integer> next4 = new ListNode<>(6);
//        ListNode<Integer> next5 = next3;
//        ListNode<Integer> next6 = new ListNode<>(2);
//        ListNode<Integer> next7 = new ListNode<>(1);
//
//        head2.setNext(next4);
//        next4.setNext(next5);
//        next5.setNext(next6);
//        next6.setNext(next7);
//
//
//        boolean hasIntersection = ll.hasIntersection(head1, head2);
//        assertTrue(hasIntersection);
//    }
//
//    @Test
//    public void checkIntersectionNoInter() {
//        ListNode<Integer> head1 = new ListNode<>(3);
//        ListNode<Integer> next = new ListNode<>(1);
//        ListNode<Integer> next1 = new ListNode<>(5);
//        ListNode<Integer> next2 = new ListNode<>(6);
//        ListNode<Integer> next3 = new ListNode<>(7);
//
//        head1.setNext(next);
//        next.setNext(next1);
//        next1.setNext(next2);
//        next2.setNext(next3);
//
//        ListNode<Integer> head2 = new ListNode<>(4);
//        ListNode<Integer> next4 = new ListNode<>(6);
//        ListNode<Integer> next5 = new ListNode<>(7);
//        ListNode<Integer> next6 = new ListNode<>(2);
//        ListNode<Integer> next7 = new ListNode<>(1);
//
//        head2.setNext(next4);
//        next4.setNext(next5);
//        next5.setNext(next6);
//        next6.setNext(next7);
//
//
//        boolean hasIntersection = ll.hasIntersection(head1, head2);
//        assertFalse(hasIntersection);
//    }
//
//    @Test
//    public void mergeListsTest() {
//        ListNode<Integer> head1 = new ListNode<>(1);
//        ListNode<Integer> next = new ListNode<>(2);
//        ListNode<Integer> next1 = new ListNode<>(4);
//
//        head1.setNext(next);
//        next.setNext(next1);
//
//        ListNode<Integer> head2 = new ListNode<>(1);
//        ListNode<Integer> next4 = new ListNode<>(3);
//        ListNode<Integer> next5 = new ListNode<>(4);
//
//        head2.setNext(next4);
//        next4.setNext(next5);
//
//        ListNode<Integer> merge = ll.mergeLists(head1, head2);
//
//        assertEquals((Integer) 1, merge.getVal());
//        assertEquals(1, merge.getNext().getVal());
//        assertEquals(2, merge.getNext().getNext().getVal());
//        assertEquals(3, merge.getNext().getNext().getNext().getVal());
//        assertEquals(4, merge.getNext().getNext().getNext().getNext().getVal());
//        assertEquals(4, merge.getNext().getNext().getNext().getNext().getNext().getVal());
//
//    }
//

//    @Test
//    public void reverseListTest() {
//        ListNode<Integer> head = new ListNode<>(1);
//        ListNode<Integer> next = new ListNode<>(2);
//        ListNode<Integer> next1 = new ListNode<>(3);
//        ListNode<Integer> next2 = new ListNode<>(4);
//        ListNode<Integer> next3 = new ListNode<>(5);
//
//        head.setNext(next);
//        next.setNext(next1);
//        next1.setNext(next2);
//        next2.setNext(next3);
//
//        ListNode<Integer> res = ll.reverseList(head);
//
//        assertEquals((Integer) 5, res.getVal());
//        assertEquals(4, res.getNext().getVal());
//        assertEquals(3, res.getNext().getNext().getVal());
//        assertEquals(2, res.getNext().getNext().getNext().getVal());
//        assertEquals(1, res.getNext().getNext().getNext().getNext().getVal());
//
//        head = new ListNode<>(null);
//        res = ll.reverseList(head);
//        assertNull(res.getVal());
//    }
//

}
