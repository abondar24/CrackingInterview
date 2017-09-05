package org.abondar.experimental.crackinginterview;

public class Lists {

    /**
     * Remove duplicates from list without using any tmp buffer
     */
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

    /**
     * Return  k elements from last element in list
     * I count positions from 0
     * if list is 1,2,3 and k=1 or 0 -> return 3; k=2 -> return 2,3
     */
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


    /**
     * Delete any node but not first or last
     * we don't have access to the first so we don't check for first
     */
    public Node deleteMiddleNode(Node nodeToDel) {

        if (nodeToDel.getNext() != null) {

            Node next = nodeToDel.getNext();
            next.setData(nodeToDel.getData());
            next.setNext(nodeToDel.getNext());

            nodeToDel = next;
        }

        return nodeToDel;
    }


    /**
     * Each param is a number in reverse : list 7-1-6 is number 617
     * We need to return a list which represents sum of values
     */
    public Node sumListsReverse(Node num1, Node num2){
       StringBuilder num1Str = new StringBuilder();
       StringBuilder num2Str = new StringBuilder();

       Node cur = num1;
       while (cur!=null){
           num1Str.append(cur.getData());
           cur = cur.getNext();
       }

       cur = num2;
        while (cur!=null){
            num2Str.append(cur.getData());
            cur = cur.getNext();
        }

        Integer n1 = Integer.valueOf(num1Str.reverse().toString());
        Integer n2 = Integer.valueOf(num2Str.reverse().toString());

        Integer sum = n1+n2;

        String reverseSum = new StringBuilder(Integer.toString(sum)).reverse().toString();

        Node[] sumNodes = new Node[reverseSum.length()];
        for (int i=0;i<reverseSum.length();i++){
            sumNodes[i] = new Node<>(Integer.valueOf(reverseSum.substring(i,i+1)));
        }

        for (int i=0;i<sumNodes.length-1;i++){
            sumNodes[i].setNext(sumNodes[i+1]);
        }

        return sumNodes[0];
    }


    /**
     * Each param is a number  : list 7-1-6 is number 716
     * We need to return a list which represents sum of values
     */
    public Node sumListsStaight(Node num1, Node num2){
        StringBuilder num1Str = new StringBuilder();
        StringBuilder num2Str = new StringBuilder();

        Node cur = num1;
        while (cur!=null){
            num1Str.append(cur.getData());
            cur = cur.getNext();
        }

        cur = num2;
        while (cur!=null){
            num2Str.append(cur.getData());
            cur = cur.getNext();
        }

        Integer n1 = Integer.valueOf(num1Str.toString());
        Integer n2 = Integer.valueOf(num2Str.toString());

        Integer sum = n1+n2;

        String strSum = Integer.toString(sum);

        Node[] sumNodes = new Node[strSum.length()];
        for (int i=0;i<strSum.length();i++){
            sumNodes[i] = new Node<>(Integer.valueOf(strSum.substring(i,i+1)));
        }

        for (int i=0;i<sumNodes.length-1;i++){
            sumNodes[i].setNext(sumNodes[i+1]);
        }

        return sumNodes[0];
    }

    /**
     * Check if list is a palindrome
     * */
    public boolean checkPalindrome(Node head){

      Node reverseHead = null;

      Node cur = head;
      while (cur!=null){

          Node n = new Node<>(cur.getData());
          n.setNext(reverseHead);
          reverseHead = n;
          cur = cur.getNext();
      }
      return isEqual(head,reverseHead);
    }

    private boolean isEqual(Node h1, Node h2){

        while (h1!=null&& h2!=null){

            if (!h1.getData().equals(h2.getData())){
                return false;
            }

            h1 = h1.getNext();
            h2 = h2.getNext();
        }


        return h1 == null && h2 == null;
    }
}
