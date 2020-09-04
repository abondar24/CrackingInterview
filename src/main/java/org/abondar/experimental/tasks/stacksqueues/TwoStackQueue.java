package org.abondar.experimental.tasks.stacksqueues;

/**
 * Queue Based on two stacks
 */
public class TwoStackQueue<T> {

    private final CustomStack<T> newElems = new CustomStack<>();
    private final CustomStack<T> addedBefore = new CustomStack<>();

    public void add(T item) {
        newElems.push(item);
    }


    public T remove() {
        fillAdded();
        return addedBefore.pop();
    }

    public T peek() {
        fillAdded();
        return addedBefore.peek();
    }

    /**
     * Fills added before in a reverse order of new elems
     */
    private void fillAdded() {
        if (addedBefore.isEmpty()) {
            while (!newElems.isEmpty()) {
                addedBefore.push(newElems.pop());
            }
        }
    }
}
