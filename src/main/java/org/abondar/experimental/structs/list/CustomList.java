package org.abondar.experimental.structs.list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomList<T> {


    private ListNode<T> root;

    public void initList(T rootVal){
        root = new ListNode<>(rootVal);
    }

    public void addToEnd(T addVal){
        ListNode<T> cur = root;
        while (cur !=null){
            if (cur.next==null){
                cur.next= new ListNode<>(addVal);
                break;
            }
            
            cur = cur.next;
        }
    }

    public void addToMiddle(T midVal,T addVal){
        ListNode<T> cur = root;
        while (cur !=null){
            if (cur.val.equals(midVal)){
                ListNode<T> add = new ListNode<>(addVal);
                add.next= cur.next;
                cur.next=add;
            }

            cur = cur.next;
        }
    }

    public ListNode<T> findNode(T val){
        ListNode<T> cur = root;
        while (cur!= null) {
            if (cur.val.equals(val)){
                return cur;
            }

            cur = cur.next;
        }

        return null;
    }

    public void deleteNode(T delVal) {
        ListNode<T> cur = root;
        while (cur.next !=null){
            if (cur.next.val.equals(delVal)){
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }

        }

    }


    public void removeDuplicates() {

        ListNode<T> cur = root;
        while (cur != null) {
            ListNode<T> runner = cur;
            while (runner.next != null) {
                if (runner.next.val == cur.val) {
                    runner.next=runner.next.next;
                } else {
                    runner = runner.next;
                }
            }

            cur = cur.next;
        }

    }

    //repeats removeDUps but more efficient
    public void deleteDuplicates() {
        ListNode<T> cur = root;

        while (cur != null && cur.next != null) {
            if ((cur.val == cur.next.val)) {
                cur.next= cur.next.next;
            } else {
                cur = cur.next;
            }


        }

    }


    public ListNode kToLast( int k) {
        ListNode kToLast = null;

        ListNode cur = root;
        int size = 0;

        while (cur != null) {
            cur = cur.next;
            size++;
        }

        // if we count from 1 posToRet = size -k +1; curPos =1
        int posToRet = size - k;
        int curPos = 0;

        cur = root;
        while (cur != null) {

            if (curPos == posToRet) {
                kToLast = cur;
            }
            cur = cur.next;
            curPos++;
        }

        return kToLast;
    }



    public ListNode<T> sumListsReverse(ListNode num1, ListNode num2) {
        StringBuilder num1Str = new StringBuilder();
        StringBuilder num2Str = new StringBuilder();

        ListNode cur = num1;
        while (cur != null) {
            num1Str.append(cur.val);
            cur = cur.next;
        }

        cur = num2;
        while (cur != null) {
            num2Str.append(cur.val);
            cur = cur.next;
        }

        Integer n1 = Integer.valueOf(num1Str.reverse().toString());
        Integer n2 = Integer.valueOf(num2Str.reverse().toString());

        Integer sum = n1 + n2;

        String reverseSum = new StringBuilder(Integer.toString(sum)).reverse().toString();

        ListNode[] sumListNodes = new ListNode[reverseSum.length()];
        for (int i = 0; i < reverseSum.length(); i++) {
            sumListNodes[i] = new ListNode<>(Integer.valueOf(reverseSum.substring(i, i + 1)));
        }

        for (int i = 0; i < sumListNodes.length - 1; i++) {
            sumListNodes[i].next=sumListNodes[i + 1];
        }

        return sumListNodes[0];
    }


    public ListNode sumListsStraight(ListNode num1, ListNode num2) {
        StringBuilder num1Str = new StringBuilder();
        StringBuilder num2Str = new StringBuilder();

        ListNode cur = num1;
        while (cur != null) {
            num1Str.append(cur.val);
            cur = cur.next;
        }

        cur = num2;
        while (cur != null) {
            num2Str.append(cur.val);
            cur = cur.next;
        }

        Integer n1 = Integer.valueOf(num1Str.toString());
        Integer n2 = Integer.valueOf(num2Str.toString());

        Integer sum = n1 + n2;

        String strSum = Integer.toString(sum);

        ListNode[] sumListNodes = new ListNode[strSum.length()];
        for (int i = 0; i < strSum.length(); i++) {
            sumListNodes[i] = new ListNode<>(Integer.valueOf(strSum.substring(i, i + 1)));
        }

        for (int i = 0; i < sumListNodes.length - 1; i++) {
            sumListNodes[i].next=sumListNodes[i + 1];
        }

        return sumListNodes[0];
    }


    public boolean checkPalindrome(ListNode head) {

        ListNode reverseHead = null;

        ListNode cur = head;
        while (cur != null) {

            ListNode n = new ListNode<>(cur.val);
            n.next=reverseHead;
            reverseHead = n;
            cur = cur.next;
        }
        return isEqual(head, reverseHead);
    }

    private boolean isEqual(ListNode h1, ListNode h2) {

        while (h1 != null && h2 != null) {

            if (!h1.val.equals(h2.val)) {
                return false;
            }

            h1 = h1.next;
            h2 = h2.next;
        }


        return h1 == null && h2 == null;
    }


    public boolean hasIntersection(ListNode h1, ListNode h2) {
        HashMap<ListNode, Boolean> checkedNodes = new HashMap<>();

        while (h1 != null) {

            checkedNodes.put(h1, false);
            h1 = h1.next;
        }

        while (h2 != null) {
            if (checkedNodes.containsKey(h2)) {
                checkedNodes.put(h2, true);
                break;
            }
            h2 = h2.next;
        }

        return checkedNodes.containsValue(true);
    }


    public ListNode detectLoop(ListNode head) {

        ListNode loop = null;

        HashMap<ListNode, Boolean> checkedNodes = new HashMap<>();
        while (head != null) {

            if (!checkedNodes.containsKey(head)) {
                checkedNodes.put(head, false);
            } else {
                checkedNodes.put(head, true);
                break;
            }

            head = head.next;
        }

        for (Map.Entry<ListNode, Boolean> ent : checkedNodes.entrySet()) {
            if (ent.getValue()) {
                loop = ent.getKey();
            }
        }

        return loop;
    }

    public ListNode<Integer> mergeLists(ListNode<Integer> l1, ListNode<Integer> l2) {
        ListNode<Integer> merge = new ListNode<>(-1);
        ListNode<Integer> head = merge;

        while (l1 != null && l2 != null) {

            if (l1.val <= l2.val) {
                merge.next=l1;
                l1 = l1.next;
            } else {
                merge.next=l2;
                l2 = l2.next;
            }
            merge = merge.next;
        }

        if (l1 != null) {
            merge.next=l1;
        } else {
            merge.next=l2;
        }


        return head.next;
    }



    //TODO: make generic
    public ListNode<Integer> reverseList(ListNode<Integer> head) {
        List<ListNode<Integer>> listNodes = new ArrayList<>();

        while (head != null) {
            listNodes.add(head);

            head = head.next;
        }


        for (int i = listNodes.size() - 1; i > 0; i--) {
            listNodes.get(i).next=listNodes.get(i - 1);

        }

        if (!listNodes.isEmpty()) {
            listNodes.get(0).next=null;
            return listNodes.get(listNodes.size() - 1);

        } else {
            return head;
        }


    }


    public ListNode<T> getRoot() {
        return root;
    }

    public static class ListNode<T> {

        private ListNode<T> next = null;
        private T val;

        public T getVal() {
            return val;
        }

        public ListNode<T> getNext() {
            return next;
        }

        public ListNode(T data) {
            this.val = data;
        }

    }
}
