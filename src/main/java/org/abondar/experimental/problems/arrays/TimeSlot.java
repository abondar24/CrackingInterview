package org.abondar.experimental.problems.arrays;

public class TimeSlot implements Comparable<TimeSlot> {

    private final int start;
    private final int end;

    public TimeSlot(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    @Override
    public int compareTo(TimeSlot o) {
        return this.start > o.start ? 0 : -1;
    }

    @Override
    public String toString() {
        return "TimeSlot{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
