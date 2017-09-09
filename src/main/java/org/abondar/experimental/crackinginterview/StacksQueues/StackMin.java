package org.abondar.experimental.crackinginterview.StacksQueues;

import java.util.Objects;

/**
 * Stack which also counts min elem
 */
public class StackMin extends CustomStack<Integer> {

    private CustomStack<Integer> stack;

    public StackMin() {
        stack = new CustomStack<>();
    }


    @Override
    public void push(Integer item) {
        if (item < min()) {
            stack.push(item);

        }

        super.push(item);
    }

    @Override
    public Integer pop() {
        Integer item = super.pop();
        if (Objects.equals(item, min())) {
            stack.pop();
        }
        return item;
    }

    public Integer min() {
        if (stack.isEmpty()) {
            return Integer.MAX_VALUE;
        } else {
            return stack.peek();
        }
    }
}