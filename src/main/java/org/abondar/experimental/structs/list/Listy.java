package org.abondar.experimental.structs.list;

public class Listy {

    private final int[] arr;

    public Listy(int[] arr) {
        this.arr = arr.clone();
    }

    public int elementAt(int index) {
        if (index >= arr.length) {
            return -1;
        }
        return arr[index];
    }
}
