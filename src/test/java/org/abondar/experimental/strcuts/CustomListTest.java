package org.abondar.experimental.strcuts;

import org.abondar.experimental.structs.list.CustomList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CustomListTest {

    private final CustomList<Integer> customList = new CustomList<>();

    @Test
    public void initListTest(){
        customList.initList(1);
        assertEquals(customList.getRoot().getVal(),1);
    }

    @Test
    public void findNodeTest(){
        customList.initList(1);
        CustomList.ListNode<Integer> resNode = customList.findNode(1);
        assertEquals(resNode.getVal(),1);
    }


    @Test
    public void addToEndTest(){
        customList.initList(1);
        customList.addToEnd(2);
        CustomList.ListNode<Integer> resNode = customList.findNode(2);
        assertEquals(resNode.getVal(),2);
    }

    @Test
    public void addToMiddleTest(){
        customList.initList(1);
        customList.addToEnd(2);
        customList.addToMiddle(1,3);

        CustomList.ListNode<Integer> lastNode = customList.findNode(2);
        assertEquals(lastNode.getVal(),2);
        assertNull(lastNode.getNext());

    }

//    @Test
//    public void removeDupsTest() {
//        ListNode<Integer> head = new ListNode<>(1);
//
//        ListNode<Integer> next1 = new ListNode<>(1);
//        head.setNext(next1);
//
//        ListNode<Integer> next2 = new ListNode<>(2);
//        next1.setNext(next2);
//
//        ListNode<Integer> next3 = new ListNode<>(3);
//        next2.setNext(next3);
//
//
//        ListNode expectedHead = new ListNode<>(1);
//        expectedHead.setNext(next2);
//
//        ListNode actualHead = ll.removeDups(head);
//        assertEquals(expectedHead.getNext(), actualHead.getNext());
//
//
//    }

//    @Test
//    public void removeDupsMiddleTest() {
//        ListNode<Integer> head = new ListNode<>(1);
//
//        ListNode<Integer> next1 = new ListNode<>(2);
//        head.setNext(next1);
//
//        ListNode<Integer> next2 = new ListNode<>(1);
//        next1.setNext(next2);
//
//        ListNode<Integer> next3 = new ListNode<>(3);
//        next2.setNext(next3);
//
//        ListNode<Integer> actualNext2 = ll.removeDups(head).getNext().getNext();
//        assertEquals(next3, actualNext2);
//    }
//
//
//    @Test
//    public void kToLastTest() {
//        ListNode<Integer> head = new ListNode<>(1);
//
//        ListNode<Integer> next = new ListNode<>(2);
//        head.setNext(next);
//
//        ListNode<Integer> next1 = new ListNode<>(3);
//        next.setNext(next1);
//
//        ListNode<Integer> next2 = new ListNode<>(4);
//        next1.setNext(next2);
//
//        ListNode<Integer> next3 = new ListNode<>(5);
//        next2.setNext(next3);
//
//        ListNode res = ll.kToLast(head, 2);
//
//        assertEquals(next2, res);
//
//    }
//
//
//    @Test
//    public void kToLastTestRetLast() {
//        ListNode<Integer> head = new ListNode<>(1);
//
//        ListNode<Integer> next = new ListNode<>(2);
//        head.setNext(next);
//
//        ListNode<Integer> next1 = new ListNode<>(3);
//        next.setNext(next1);
//
//        ListNode<Integer> next2 = new ListNode<>(4);
//        next1.setNext(next2);
//
//        ListNode<Integer> next3 = new ListNode<>(5);
//        next2.setNext(next3);
//
//        ListNode res = ll.kToLast(head, 1);
//
//        assertEquals(next3, res);
//    }
//
//    @Test
//    public void kToLastTestRetNull() {
//        ListNode<Integer> head = new ListNode<>(1);
//
//        ListNode<Integer> next = new ListNode<>(2);
//        head.setNext(next);
//
//        ListNode<Integer> next1 = new ListNode<>(3);
//        next.setNext(next1);
//
//        ListNode<Integer> next2 = new ListNode<>(4);
//        next1.setNext(next2);
//
//        ListNode<Integer> next3 = new ListNode<>(5);
//        next2.setNext(next3);
//
//        ListNode res = ll.kToLast(head, 7);
//
//        assertEquals(null, res);
//    }
//
//
//    @Test
//    public void deleteMiddleNodeTest() {
//
//        ListNode<String> head = new ListNode<>("a");
//
//        ListNode<String> b = new ListNode<>("b");
//        head.setNext(b);
//
//        ListNode<String> c = new ListNode<>("c");
//        b.setNext(c);
//
//        ListNode<String> d = new ListNode<>("d");
//        c.setNext(d);
//
//        ListNode<String> e = new ListNode<>("e");
//        d.setNext(e);
//
//        ListNode<String> f = new ListNode<>("f");
//        e.setNext(f);
//
//        ListNode res = ll.deleteMiddleNode(d);
//        assertEquals(e, res);
//
//
//        res = ll.deleteMiddleNode(f);
//        assertEquals(res, f);
//
//    }
//
//    @Test
//    public void sumListsReverseTest() {
//        //it represents 617
//        ListNode<Integer> n1 = new ListNode<>(7);
//        ListNode<Integer> n1Next = new ListNode<>(1);
//        ListNode<Integer> n1Next1 = new ListNode<>(6);
//        n1.setNext(n1Next);
//        n1Next.setNext(n1Next1);
//
//        //it represents 295
//        ListNode<Integer> n2 = new ListNode<>(5);
//        ListNode<Integer> n2Next = new ListNode<>(9);
//        ListNode<Integer> n2Next1 = new ListNode<>(2);
//        n2.setNext(n2Next);
//        n2Next.setNext(n2Next1);
//
//        //ExpectedSum
//        ListNode<Integer> sum = new ListNode<>(2);
//        ListNode<Integer> sumNext = new ListNode<>(1);
//        ListNode<Integer> sumNext1 = new ListNode<>(9);
//        sum.setNext(sumNext);
//        sumNext.setNext(sumNext1);
//
//
//        ListNode actualSum = ll.sumListsReverse(n1, n2);
//        assertEquals(sum.toString(), actualSum.toString());
//    }
//
//    @Test
//    public void sumListsStraightTest() {
//        //it represents 617
//        ListNode<Integer> n1 = new ListNode<>(6);
//        ListNode<Integer> n1Next = new ListNode<>(1);
//        ListNode<Integer> n1Next1 = new ListNode<>(7);
//        n1.setNext(n1Next);
//        n1Next.setNext(n1Next1);
//
//        //it represents 295
//        ListNode<Integer> n2 = new ListNode<>(2);
//        ListNode<Integer> n2Next = new ListNode<>(9);
//        ListNode<Integer> n2Next1 = new ListNode<>(5);
//        n2.setNext(n2Next);
//        n2Next.setNext(n2Next1);
//
//        //ExpectedSum
//        ListNode<Integer> sum = new ListNode<>(9);
//        ListNode<Integer> sumNext = new ListNode<>(1);
//        ListNode<Integer> sumNext1 = new ListNode<>(2);
//        sum.setNext(sumNext);
//        sumNext.setNext(sumNext1);
//
//
//        ListNode actualSum = ll.sumListsStraight(n1, n2);
//        assertEquals(sum.toString(), actualSum.toString());
//    }
//
//
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
//    public void deleteDuplicatesTest() {
//        ListNode<Integer> head = new ListNode<>(1);
//        ListNode<Integer> next = new ListNode<>(1);
//        ListNode<Integer> next1 = new ListNode<>(2);
//
//        head.setNext(next);
//        next.setNext(next1);
//
//
//        ListNode<Integer> res = ll.deleteDuplicates(head);
//
//        assertEquals((Integer) 1, res.getVal());
//        assertEquals(2, res.getNext().getVal());
//
//        ListNode<Integer> next2 = new ListNode<>(3);
//        ListNode<Integer> next3 = new ListNode<>(3);
//
//        next1.setNext(next2);
//        next2.setNext(next3);
//
//
//        res = ll.deleteDuplicates(head);
//
//        assertEquals((Integer) 1, res.getVal());
//        assertEquals(2, res.getNext().getVal());
//        assertEquals(3, res.getNext().getNext().getVal());
//
//    }
//
//    @Test
//    public void deleteValTest() {
//        ListNode<Integer> head = new ListNode<>(1);
//        ListNode<Integer> next = new ListNode<>(2);
//        ListNode<Integer> next1 = new ListNode<>(6);
//        ListNode<Integer> next2 = new ListNode<>(3);
//        ListNode<Integer> next3 = new ListNode<>(4);
//        ListNode<Integer> next4 = new ListNode<>(5);
//        ListNode<Integer> next5 = new ListNode<>(6);
//
//        head.setNext(next);
//        next.setNext(next1);
//        next1.setNext(next2);
//        next2.setNext(next3);
//        next3.setNext(next4);
//        next4.setNext(next5);
//
//        ListNode<Integer> res = ll.deleteVal(head, 6);
//
//        assertEquals((Integer) 1, res.getVal());
//        assertEquals(2, res.getNext().getVal());
//        assertEquals(3, res.getNext().getNext().getVal());
//        assertEquals(4, res.getNext().getNext().getNext().getVal());
//        assertEquals(5, res.getNext().getNext().getNext().getNext().getVal());
//
//        ListNode<Integer> head1 = new ListNode<>(1);
//        res = ll.deleteVal(head1, 1);
//        assertNull(res);
//
//        ListNode<Integer> head2 = new ListNode<>(1);
//        ListNode<Integer> next6 = new ListNode<>(1);
//        head2.setNext(next6);
//
//        res = ll.deleteVal(head2, 1);
//        assertNull(res);
//
//        ListNode<Integer> head3 = new ListNode<>(1);
//        ListNode<Integer> next7 = new ListNode<>(2);
//        head3.setNext(next7);
//        res = ll.deleteVal(head3, 1);
//        assertEquals((Integer) 2, res.getVal());
//
//    }
//
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
//    @Test
//    public void appendToTailTest() {
//        ListNode<Integer> head = new ListNode<>(1);
//        head = ll.appendToTail(head,2);
//        assertNotNull(head.getNext());
//        assertEquals(2,head.getNext().getVal());
//
//        ListNode<Integer> next = head.getNext();
//        ListNode<Integer> next1 = new ListNode<>(3);
//        ListNode<Integer> next2 = new ListNode<>(4);
//        ListNode<Integer> next3 = new ListNode<>(5);
//
//        next.setNext(next1);
//        next1.setNext(next2);
//        next2.setNext(next3);
//
//        ListNode<Integer> res = ll.appendToTail(head,6);
//        assertNotNull(next3.getNext());
//        assertEquals(res.getNext().getNext().getNext().getNext().getNext().getVal(), next3.getNext().getVal());
//    }
//
//    @Test
//    public void findNodeTest() {
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
//
//        ListNode<Integer> res = ll.findNode(head,5);
//        assertEquals(res.getVal(),next3.getVal());
//
//        res = ll.findNode(head,6);
//        assertNull(res);
//
//    }
}
