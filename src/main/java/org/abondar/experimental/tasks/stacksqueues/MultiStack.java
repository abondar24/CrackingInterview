package org.abondar.experimental.tasks.stacksqueues;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Splits an int array to defined number of stacks.
 */
public class MultiStack {

    private final int[] arrayToSplit;
    private final int numberOfStacks;
    private final int singleStackSize;

    public MultiStack(int[] arrayToSplit, int numberOfStacks) {
        this.arrayToSplit = arrayToSplit;
        this.numberOfStacks = numberOfStacks;
        Double ss = (double) arrayToSplit.length / (double) numberOfStacks;
        singleStackSize = ss.intValue();
    }

    public List<CustomStack> splitToStacks() {
        List<CustomStack> stackList = new ArrayList<>();

        for (int i = 0; i < numberOfStacks; i++) {
            CustomStack stack = new CustomStack();
            stackList.add(stack);
        }

        int counter = 0;
        System.out.println(singleStackSize);
        for (CustomStack s : stackList) {
            int endOfStack = counter + singleStackSize;
            if (counter != stackList.size()) {
                fillStack(s, counter, endOfStack);
            } else {
                fillStack(s, counter, arrayToSplit.length);
            }
            counter += singleStackSize;
        }
        return stackList;
    }


    private void fillStack(CustomStack stack, int startIndex, int endIndex) {

        int[] subArray = Arrays.copyOfRange(arrayToSplit, startIndex, endIndex);
        for (int aSubArray : subArray) {
            stack.push(aSubArray);
        }


    }
}
