package org.abondar.experimental.structs.stack;

import org.abondar.experimental.structs.stack.CustomStack;

public class StackUtil {

    /**
     * Sort stack using additional one but without any additional data structures
     * Biggest elem must be on top
     */
    public static CustomStack<Integer> sortStack(CustomStack<Integer> stack) {
        CustomStack<Integer> sorted = new CustomStack<>();
        while (!stack.isEmpty()) {
            Integer max = stack.pop();

            while (!sorted.isEmpty() && sorted.peek() > max) {
                stack.push(sorted.pop());
            }

            sorted.push(max);

        }
        return sorted;
    }


}
