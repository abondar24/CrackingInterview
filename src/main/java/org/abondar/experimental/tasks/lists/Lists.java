package org.abondar.experimental.tasks.lists;

import org.abondar.experimental.structs.list.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lists {

    public Node removeDups(Node head) {

        Node cur = head;
        while (cur != null) {
            Node runner = cur;
            while (runner.getNext() != null) {
                if (runner.getNext().getData() == cur.getData()) {
                    runner.setNext(runner.getNext().getNext());
                } else {
                    runner = runner.getNext();
                }
            }

            cur = cur.getNext();
        }

        return head;
    }

    public Node kToLast(Node head, int k) {
        Node kToLast = null;

        Node cur = head;
        int size = 0;

        while (cur != null) {
            cur = cur.getNext();
            size++;
        }

        // if we count from 1 posToRet = size -k +1; curPos =1
        int posToRet = size - k;
        int curPos = 0;

        cur = head;
        while (cur != null) {

            if (curPos == posToRet) {
                kToLast = cur;
            }
            cur = cur.getNext();
            curPos++;
        }

        return kToLast;
    }


    public Node deleteMiddleNode(Node nodeToDel) {

        if (nodeToDel.getNext() != null) {

            Node next = nodeToDel.getNext();
            next.setData(nodeToDel.getData());
            next.setNext(nodeToDel.getNext());

            nodeToDel = next;
        }

        return nodeToDel;
    }


    public Node sumListsReverse(Node num1, Node num2) {
        StringBuilder num1Str = new StringBuilder();
        StringBuilder num2Str = new StringBuilder();

        Node cur = num1;
        while (cur != null) {
            num1Str.append(cur.getData());
            cur = cur.getNext();
        }

        cur = num2;
        while (cur != null) {
            num2Str.append(cur.getData());
            cur = cur.getNext();
        }

        Integer n1 = Integer.valueOf(num1Str.reverse().toString());
        Integer n2 = Integer.valueOf(num2Str.reverse().toString());

        Integer sum = n1 + n2;

        String reverseSum = new StringBuilder(Integer.toString(sum)).reverse().toString();

        Node[] sumNodes = new Node[reverseSum.length()];
        for (int i = 0; i < reverseSum.length(); i++) {
            sumNodes[i] = new Node<>(Integer.valueOf(reverseSum.substring(i, i + 1)));
        }

        for (int i = 0; i < sumNodes.length - 1; i++) {
            sumNodes[i].setNext(sumNodes[i + 1]);
        }

        return sumNodes[0];
    }


    public Node sumListsStraight(Node num1, Node num2) {
        StringBuilder num1Str = new StringBuilder();
        StringBuilder num2Str = new StringBuilder();

        Node cur = num1;
        while (cur != null) {
            num1Str.append(cur.getData());
            cur = cur.getNext();
        }

        cur = num2;
        while (cur != null) {
            num2Str.append(cur.getData());
            cur = cur.getNext();
        }

        Integer n1 = Integer.valueOf(num1Str.toString());
        Integer n2 = Integer.valueOf(num2Str.toString());

        Integer sum = n1 + n2;

        String strSum = Integer.toString(sum);

        Node[] sumNodes = new Node[strSum.length()];
        for (int i = 0; i < strSum.length(); i++) {
            sumNodes[i] = new Node<>(Integer.valueOf(strSum.substring(i, i + 1)));
        }

        for (int i = 0; i < sumNodes.length - 1; i++) {
            sumNodes[i].setNext(sumNodes[i + 1]);
        }

        return sumNodes[0];
    }


    public boolean checkPalindrome(Node head) {

        Node reverseHead = null;

        Node cur = head;
        while (cur != null) {

            Node n = new Node<>(cur.getData());
            n.setNext(reverseHead);
            reverseHead = n;
            cur = cur.getNext();
        }
        return isEqual(head, reverseHead);
    }

    private boolean isEqual(Node h1, Node h2) {

        while (h1 != null && h2 != null) {

            if (!h1.getData().equals(h2.getData())) {
                return false;
            }

            h1 = h1.getNext();
            h2 = h2.getNext();
        }


        return h1 == null && h2 == null;
    }


    public boolean hasIntersection(Node h1, Node h2) {
        HashMap<Node, Boolean> checkedNodes = new HashMap<>();

        while (h1 != null) {

            checkedNodes.put(h1, false);
            h1 = h1.getNext();
        }

        while (h2 != null) {
            if (checkedNodes.containsKey(h2)) {
                checkedNodes.put(h2, true);
                break;
            }
            h2 = h2.getNext();
        }

        return checkedNodes.containsValue(true);
    }


    public Node detectLoop(Node head) {

        Node loop = null;

        HashMap<Node, Boolean> checkedNodes = new HashMap<>();
        while (head != null) {

            if (!checkedNodes.containsKey(head)) {
                checkedNodes.put(head, false);
            } else {
                checkedNodes.put(head, true);
                break;
            }

            head = head.getNext();
        }

        for (Map.Entry<Node, Boolean> ent : checkedNodes.entrySet()) {
            if (ent.getValue()) {
                loop = ent.getKey();
            }
        }

        return loop;
    }

    public Node<Integer> mergeLists(Node<Integer> l1, Node<Integer> l2) {
        Node<Integer> merge = new Node<>(-1);
        Node<Integer> head = merge;

        while (l1 != null && l2 != null) {

            if (l1.getData() <= l2.getData()) {
                merge.setNext(l1);
                l1 = l1.getNext();
            } else {
                merge.setNext(l2);
                l2 = l2.getNext();
            }
            merge = merge.getNext();
        }

        if (l1 != null) {
            merge.setNext(l1);
        } else {
            merge.setNext(l2);
        }


        return head.getNext();
    }

    //repeats removeDUps but more efficient
    public Node<Integer> deleteDuplicates(Node<Integer> head) {
        Node<Integer> cur = head;

        while (cur != null && cur.getNext() != null) {
            if ((cur.getData() == cur.getNext().getData())) {
                cur.setNext(cur.getNext().getNext());
            } else {
                cur = cur.getNext();
            }


        }

        return head;
    }

    public Node<Integer> deleteVal(Node<Integer> head, int val) {


        Node<Integer> cur = new Node<>(-1);
        cur.setNext(head);
        head = cur;

        while (cur.getNext() != null) {
            if ((Integer) cur.getNext().getData() == val) {
                cur.setNext(cur.getNext().getNext());
            } else {
                cur = cur.getNext();
            }
        }


        return head.getNext();
    }

    public Node<Integer> reverseList(Node<Integer> head) {
        List<Node<Integer>> nodes = new ArrayList<>();

        while (head != null) {
            nodes.add(head);

            head = head.getNext();
        }


        for (int i = nodes.size() - 1; i > 0; i--) {
            nodes.get(i).setNext(nodes.get(i - 1));

        }

        if (!nodes.isEmpty()) {
            nodes.get(0).setNext(null);
            return nodes.get(nodes.size() - 1);

        } else {
            return head;
        }


    }


}
