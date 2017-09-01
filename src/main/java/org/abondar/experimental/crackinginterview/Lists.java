package org.abondar.experimental.crackinginterview;

public class Lists {

    /**
     * Remove duplicates from list without using any tmp buffer
     * */
    public Node removeDups(Node head){

        Node cur = head;
        while (cur!=null){
            Node runner = cur;
            while (runner.getNext()!=null){
                if (runner.getNext().getData()==cur.getData()){
                    runner.setNext(runner.getNext().getNext());
                } else {
                    runner = runner.getNext();
                }
            }

            cur = cur.getNext();
        }


        return head;
    }
}
