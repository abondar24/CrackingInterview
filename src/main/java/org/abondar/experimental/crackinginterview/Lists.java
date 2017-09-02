package org.abondar.experimental.crackinginterview;

public class Lists {

    /**
     * Remove duplicates from list without using any tmp buffer
     */
    public IntNode removeDups(IntNode head) {

        IntNode cur = head;
        while (cur != null) {
            IntNode runner = cur;
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

    /**
     * Return  k elements from last element in list
     * I count positions from 0
     * if list is 1,2,3 and k=1 or 0 -> return 3; k=2 -> return 2,3
     */
    public IntNode kToLast(IntNode head, int k) {
        IntNode kToLast = null;

        IntNode cur = head;
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


    /**
     * Delete any node but not first or last
     * we don't have access to the first so we don't check for first
     */
    public StrNode deleteMiddleNode(StrNode nodeToDel) {

        if (nodeToDel.getNext() != null) {

            StrNode next = nodeToDel.getNext();
            next.setData(nodeToDel.getData());
            next.setNext(nodeToDel.getNext());

            nodeToDel = next;
        }

        return nodeToDel;
    }

}
