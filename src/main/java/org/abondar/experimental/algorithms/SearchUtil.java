package org.abondar.experimental.algorithms;


import java.util.LinkedList;

public class SearchUtil {
    private int tableSize = 65136;

    public boolean sequentialSearch(int[] data, int elem) {
        for (int i : data) {
            if (i == elem) {
                return true;
            }
        }
        return false;
    }

    public int sequentialSearchIndex(int[] data, int elem) {
        for (int i=0;i<data.length;i++) {
            if (data[i] == elem) {
                return i;
            }
        }
        return -1;
    }

    public boolean binarySearch(int[] data, int elem) {
        int low = 0;
        int high = data.length - 1;

        while (low < high) {
            int mid = (low + high) / 2;
            if (elem < data[mid]) {
                high = mid - 1;
            } else if (elem > data[mid]) {
                low = mid + 1;
            } else {
                return true;
            }
        }

        return false;
    }


    public int binarySearchIndex(int[] data, int elem) {
        int low = 0;
        int high = data.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (elem < data[mid]) {
                high = mid - 1;
            } else if (elem > data[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }


    public boolean hashSearch(int[] data, int elem) {
        int h = hash(elem);

        LinkedList[] table = loadHashTable(data);
        LinkedList<Integer> list = (LinkedList<Integer>) table[h];
        return list != null && list.contains(elem);

    }


    private LinkedList<Integer>[] loadHashTable(int[] data) {
        LinkedList<Integer>[] table = (LinkedList<Integer>[]) new LinkedList[tableSize];

        for (int i : data) {

            int h = hash(i);
            if (table[h] == null) {
                table[h] = new LinkedList<>();
            }
            table[h].add(i);
        }
        return table;
    }

    private int hash(int i) {
        int h = Integer.valueOf(i).hashCode();
        if (h < 0) {
            h = 0 - h;
        }

        return h % tableSize;
    }

}
