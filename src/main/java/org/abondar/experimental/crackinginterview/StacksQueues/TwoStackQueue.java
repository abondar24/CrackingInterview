package org.abondar.experimental.crackinginterview.StacksQueues;

/**
 * Queue Based on two stacks
 * */
public class TwoStackQueue<T> {

    private CustomStack<T> newElems = new CustomStack<>();
    private CustomStack<T> addedBefore = new CustomStack<>();

    public void add(T item){
        newElems.push(item);
    }


    public T remove(){
        fillAdded();
        return addedBefore.pop();
    }

    public T peek(){
        fillAdded();
        return addedBefore.peek();
    }

    /**
     * Fills added before in a reverse order of new elems
     * */
    private void fillAdded() {
        if (addedBefore.isEmpty()) {
            while (!newElems.isEmpty()) {
                addedBefore.push(newElems.pop());
            }
        }
    }
}
