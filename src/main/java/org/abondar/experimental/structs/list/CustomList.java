package org.abondar.experimental.structs.list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomList<T> {

    private ListNode<T> root;

    public CustomList(T rootVal) {
        initList(rootVal);
    }

    public CustomList() {
    }

    public void initList(T rootVal) {
        root = new ListNode<>(rootVal);
    }

    public void addToEnd(T addVal) {
        ListNode<T> cur = root;
        while (cur != null) {
            if (cur.next == null) {
                cur.next = new ListNode<>(addVal);
                break;
            }

            cur = cur.next;
        }
    }

    public void addToEnd(ListNode<T> addNode) {
        ListNode<T> cur = root;
        while (cur != null) {
            if (cur.next == null) {
                cur.next = addNode;
                break;
            }

            cur = cur.next;
        }
    }

    public void addToMiddle(T midVal, T addVal) {
        ListNode<T> cur = root;
        while (cur != null) {
            if (cur.val.equals(midVal)) {
                ListNode<T> add = new ListNode<>(addVal);
                add.next = cur.next;
                cur.next = add;
            }

            cur = cur.next;
        }
    }

    public void addToMiddle(T midVal, ListNode<T> addNode) {
        ListNode<T> cur = root;
        while (cur != null) {
            if (cur.val.equals(midVal)) {
                addNode.next = cur.next;
                cur.next = addNode;
            }

            cur = cur.next;
        }
    }

    public ListNode<T> findNode(T val) {
        ListNode<T> cur = root;
        while (cur != null) {
            if (cur.val.equals(val)) {
                return cur;
            }

            cur = cur.next;
        }

        return null;
    }

    public void deleteNode(T delVal) {
        ListNode<T> cur = root;
        while (cur.next != null) {
            if (cur.next.val.equals(delVal)) {
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
                    runner.next = runner.next.next;
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
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
    }


    public ListNode<T> kToLast(int k) {
        ListNode<T> kToLast = null;

        ListNode<T> cur = root;
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

    public CustomList<Integer> sumLists(CustomList<T> listToSum, boolean isReverse) {
        StringBuilder num1Str = new StringBuilder();
        StringBuilder num2Str = new StringBuilder();

        ListNode<T> cur = root;
        while (cur != null) {
            num1Str.append(cur.val);
            cur = cur.next;
        }

        cur = listToSum.root;
        while (cur != null) {
            num2Str.append(cur.val);
            cur = cur.next;
        }

        if (isReverse) {
            num1Str.reverse();
            num2Str.reverse();
        }

        int n1 = Integer.parseInt(num1Str.toString());
        int n2 = Integer.parseInt(num2Str.toString());

        int sum = n1 + n2;

        String strSum = Integer.toString(sum);
        if (isReverse) {
            strSum = new StringBuilder(strSum).reverse().toString();
        }

        int[] sumListValues = new int[strSum.length()];
        for (int i = 0; i < strSum.length(); i++) {
            sumListValues[i] = Integer.parseInt(strSum.substring(i, i + 1));
        }

        CustomList<Integer> res = new CustomList<>(sumListValues[0]);
        for (int i = 1; i < sumListValues.length; i++) {
            res.addToEnd(sumListValues[i]);
        }

        return res;
    }


    public boolean isPalindrome() {

        ListNode<T> reverseRoot = null;

        ListNode<T> cur = root;
        while (cur != null) {

            ListNode n = new ListNode<>(cur.val);
            n.next = reverseRoot;
            reverseRoot = n;
            cur = cur.next;
        }
        return isEqual(root, reverseRoot);
    }

    private boolean isEqual(ListNode<T> root1, ListNode<T> root2) {

        while (root1 != null && root2 != null) {

            if (!root1.val.equals(root2.val)) {
                return false;
            }

            root1 = root1.next;
            root2 = root2.next;
        }


        return root1 == null && root2 == null;
    }


    public boolean hasIntersection(CustomList<T> interList) {
        HashMap<ListNode<T>, Boolean> checkedNodes = new HashMap<>();

        ListNode<T> cur = root;
        while (cur != null) {
            checkedNodes.put(cur, false);
            cur = cur.next;
        }

        cur = interList.root;
        while (cur != null) {
            if (checkedNodes.containsKey(cur)) {
                checkedNodes.put(cur, true);
                break;
            }
            cur = cur.next;
        }

        return checkedNodes.containsValue(true);
    }


    public ListNode<T> detectLoop() {

        ListNode<T> loopNode = null;

        HashMap<ListNode<T>, Boolean> checkedNodes = new HashMap<>();
        ListNode<T> cur = root;
        while (cur != null) {

            if (!checkedNodes.containsKey(cur)) {
                checkedNodes.put(cur, false);
            } else {
                checkedNodes.put(cur, true);
                break;
            }

            cur = cur.next;
        }

        for (Map.Entry<ListNode<T>, Boolean> ent : checkedNodes.entrySet()) {
            if (ent.getValue()) {
                loopNode = ent.getKey();
            }
        }

        return loopNode;
    }

    public CustomList<Integer> mergeLists(CustomList<Integer> mergeList) {
        CustomList<Integer> res = new CustomList<>();

        if (!(root.getVal() instanceof Integer)){
            throw new RuntimeException("Incomatible types");
        }

        while (root != null && mergeList.root != null) {
            if ((Integer)root.val <= mergeList.root.val) {
                if (res.root == null) {
                    res.initList((Integer) root.val);
                } else {
                    res.addToEnd((Integer) root.val);
                }
                root = root.next;
            } else {
                if (res.root == null) {
                    res.initList(mergeList.root.val);
                } else {
                    res.addToEnd(mergeList.root.val);
                }
                mergeList.root = mergeList.root.next;
            }

        }

        if (root!=null){
            res.addToEnd((Integer) root.val);
        } else {
            res.addToEnd(mergeList.root);
        }

        return res;
    }


    public CustomList<T> reverseList() {
        List<ListNode<T>> listNodes = new ArrayList<>();

        while (root != null) {
            listNodes.add(root);

            root = root.next;
        }


        for (int i = listNodes.size() - 1; i > 0; i--) {
            listNodes.get(i).next = listNodes.get(i - 1);

        }

        ListNode<T> reverseRoot = null;
        if (!listNodes.isEmpty()) {
            listNodes.get(0).next = null;
            reverseRoot = listNodes.get(listNodes.size() - 1);

        } else {
            reverseRoot = root;
        }

        CustomList<T> res = new CustomList<>();
        while (reverseRoot!=null){
            if (res.root==null){
                res.initList(reverseRoot.val);
            } else {
                res.addToEnd(reverseRoot.val);
            }

            reverseRoot = reverseRoot.next;
        }
        return res;
    }


    public ListNode<T> getRoot() {
        return root;
    }

    public static class ListNode<T>{

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
