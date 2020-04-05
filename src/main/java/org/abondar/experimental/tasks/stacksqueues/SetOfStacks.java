package org.abondar.experimental.tasks.stacksqueues;


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Creates a set of stacks.
 * Each stack has a max capacity and when we run over it we add a new stack.
 * Methods push,pop and peek work as in simple stack
 * */
public class SetOfStacks {

    private Integer maxCapacityPerStack;
    private Map<CustomStack, Integer> stackSet = new HashMap<>();
    private CustomStack<Integer> lastStack = new CustomStack<>();

    public SetOfStacks(Integer maxCapacityPerStack) {
        this.maxCapacityPerStack = maxCapacityPerStack;
    }

    public void push(Integer val) {
        if (stackSet.isEmpty()) {
            addNewStackToSet(val);
        } else {
            Integer capacity = stackSet.get(lastStack);

            if (Objects.equals(capacity, maxCapacityPerStack)) {
                addNewStackToSet(val);
            } else {
                lastStack.push(val);
                stackSet.put(lastStack, capacity + 1);
            }

        }
    }

    public Integer pop() {
        Integer val = lastStack.pop();
        Integer capacity = stackSet.get(lastStack);
        capacity = capacity -1;
        if (capacity>0) {
            stackSet.put(lastStack, capacity - 1);
        } else {
            stackSet.put(lastStack, 0);
        }
        return val;
    }

    public Integer peek() {
        return lastStack.peek();
    }

    public Map<CustomStack, Integer> getStackSet() {
        return stackSet;
    }

    private void addNewStackToSet(Integer val) {
        CustomStack<Integer> stack = new CustomStack<>();
        stack.push(val);
        stackSet.put(stack, 1);
        lastStack = stack;
    }


}
