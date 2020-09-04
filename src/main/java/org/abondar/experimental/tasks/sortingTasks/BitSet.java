package org.abondar.experimental.tasks.sortingTasks;

public class BitSet {
    private final int[] bitset;

    public BitSet(int size) {
        // divide by 32
        bitset = new int[(size >> 5) + 1];
    }

    boolean get(int pos) {
        int wordNumber = (pos >> 5);
        //mod 32
        int bitNumber = (pos & 0x1F);
        return (bitset[wordNumber] & (1 << bitNumber)) != 0;
    }

    void set(int pos) {
        int wordNumber = (pos >> 5);
        int bitNumber = (pos & 0x1F);
        bitset[wordNumber] |= 1 << bitNumber;
    }

}
