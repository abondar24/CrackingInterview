package org.abondar.experimental.tasks.dynamic;

import java.util.Stack;

public class Tower {

    private final Stack<Integer> disks;
    private final int index;

    public Tower(int i) {
        disks = new Stack<>();
        index = i;
    }

    public int index() {
        return index;
    }

    public void add(int d) {
        if (!disks.isEmpty() && disks.peek() <= d) {
            System.err.println("Error placing disk " + d);
        } else {
            disks.push(d);
        }

    }

    public void moveDisks(int n, Tower destination, Tower buffer) {
        if (n > 0) {
            moveDisks(n - 1, buffer, destination);
            moveTopTo(destination);
            buffer.moveDisks(n - 1, destination, this);
        }
    }

    private void moveTopTo(Tower t) {
        int top = disks.pop();
        t.add(top);
    }

    public Stack<Integer> getDisks() {
        return disks;
    }

    @Override
    public String toString() {
        return "Tower{" +
                "disks=" + disks +
                ", index=" + index +
                '}';
    }
}
