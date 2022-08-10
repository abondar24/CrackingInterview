package org.abondar.experimental.structs.stack;

import java.util.Objects;

/**
 * Stack which also counts min elem
 */
public class MinStack extends CustomStack<Integer> {

    private CustomStack<Integer> stack;

    public MinStack() {
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

    public void sort() {

        CustomStack<Integer> sorted = new CustomStack<>();
        while (!isEmpty()) {
            Integer max = (Integer) pop();

            while (!sorted.isEmpty() && sorted.peek() > max) {
                push(sorted.pop());
            }

            sorted.push(max);

        }

        stack = sorted;
    }

    public CustomStack<Integer> getStack() {
        return stack;
    }
}
