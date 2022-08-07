package org.abondar.experimental.strcuts;

import org.abondar.experimental.structs.list.CustomList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    public void addToEndNodeTest() {
        CustomList<Integer> customList = new CustomList<>(1);
        CustomList.ListNode<Integer> listNode = new CustomList.ListNode<>(2);
        customList.addToEnd(listNode);

        CustomList.ListNode<Integer> resNode = customList.findNode(2);
        assertEquals(listNode, resNode);
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
    public void addToMiddleNodeTest() {
        CustomList<Integer> customList = new CustomList<>(1);
        customList.addToEnd(2);

        CustomList.ListNode<Integer> addNode = new CustomList.ListNode<>(3);
        customList.addToMiddle(1, addNode);

        CustomList.ListNode<Integer> lastNode = customList.findNode(2);
        assertEquals(addNode.getNext(), lastNode);
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


    @Test
    public void isPalindromeIntTest() {
        CustomList<Integer> list = new CustomList<>(0);
        list.addToEnd(1);
        list.addToEnd(2);
        list.addToEnd(1);
        list.addToEnd(0);


        boolean isPalindrome = list.isPalindrome();
        assertTrue(isPalindrome);
    }

    @Test
    public void isPalindromeStrTest() {
        CustomList<String> list  = new CustomList<>("a");
        list.addToEnd("b");
        list.addToEnd("b");
        list.addToEnd("a");

        boolean isPalindrome = list.isPalindrome();
        assertTrue(isPalindrome);
    }

    @Test
    public void isPalindromeFalseTest() {
        CustomList<Integer> list = new CustomList<>(0);
        list.addToEnd(1);
        list.addToEnd(2);
        list.addToEnd(1);
        list.addToEnd(2);

        boolean isPalindrome = list.isPalindrome();
        assertFalse(isPalindrome);
    }

    @Test
    public void checkIntersection() {
        CustomList<Integer> list = new CustomList<>(3);
        list.addToEnd(1);
        list.addToEnd(5);
        list.addToEnd(6);
        CustomList.ListNode<Integer> interNode = new CustomList.ListNode<>(7);
        list.addToEnd(interNode);

        CustomList<Integer> interList = new CustomList<>(4);
        interList.addToEnd(6);
        interList.addToEnd(interNode);
        interList.addToEnd(2);
        interList.addToEnd(1);

        boolean hasIntersection = list.hasIntersection(interList);
        assertTrue(hasIntersection);
    }

    @Test
    public void checkNoIntersectionTest() {
        CustomList<Integer> list = new CustomList<>(3);
        list.addToEnd(1);
        list.addToEnd(5);
        list.addToEnd(6);
        list.addToEnd(7);

        CustomList<Integer> interList = new CustomList<>(4);
        interList.addToEnd(6);
        interList.addToEnd(7);
        interList.addToEnd(2);
        interList.addToEnd(1);


        boolean hasIntersection = list.hasIntersection(interList);
        assertFalse(hasIntersection);
    }

    @Test
    public void detectLoopTest() {
        CustomList<String> customList = new CustomList<>("a");
        customList.addToEnd("b");

        CustomList.ListNode<String> loopNode = new CustomList.ListNode<>("c");
        customList.addToEnd(loopNode);

        customList.addToEnd("d");
        customList.addToEnd("e");
        customList.addToEnd(loopNode);

        CustomList.ListNode<String> loop = customList.detectLoop();
        assertEquals(loopNode, loop);

    }

    @Test
    public void detectLoopTestNoLoop() {
        CustomList<String> customList = new CustomList<>("a");
        customList.addToEnd("b");
        customList.addToEnd("c");
        customList.addToEnd("d");
        customList.addToEnd("e");
        customList.addToEnd("c");

        CustomList.ListNode<String> loop = customList.detectLoop();
        assertEquals(null, loop);

    }

    @Test
    public void mergeListsTest() {
        CustomList<Integer> customList = new CustomList<>(1);
        customList.addToEnd(2);
        customList.addToEnd(4);

        CustomList<Integer> mergeList = new CustomList<>(1);
        mergeList.addToEnd(3);
        mergeList.addToEnd(4);
        
        CustomList<Integer> merge = customList.mergeLists(mergeList);

        assertEquals(1, merge.getRoot().getVal());
        assertEquals(1, merge.getRoot().getNext().getVal());
        assertEquals(2, merge.getRoot().getNext().getNext().getVal());
        assertEquals(3, merge.getRoot().getNext().getNext().getNext().getVal());
        assertEquals(4, merge.getRoot().getNext().getNext().getNext().getNext().getVal());
        assertEquals(4, merge.getRoot().getNext().getNext().getNext().getNext().getNext().getVal());

    }


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
