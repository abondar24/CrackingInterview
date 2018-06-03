package org.abondar.experimental.algorithms;

import java.util.Random;

public class SortingUtil {

    public int[] insertionSort(int[] data) {
        for (int i = 0; i < data.length; i++) {
            insert(data, i, data[i]);
        }

        return data;
    }

    private void insert(int[] data, int pos, int value) {
        int i = pos - 1;
        while (i >= 0 && data[i] > value) {
            data[i + 1] = data[i];
            i = i - 1;
        }
        data[i + 1] = value;
    }


    public int[] heapSort(int[] data) {

        buildHeap(data);
        for (int i = data.length - 1; i >= 1; i--) {
            int buf = data[0];
            data[0] = data[i];
            data[i] = buf;
            heapify(data, 0, i);
        }

        return data;
    }

    private void buildHeap(int[] data) {
        for (int i = data.length / 2 - 1; i >= 0; i--) {
            heapify(data, i, data.length);
        }
    }

    private void heapify(int[] data, int i, int max) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < max && data[left] > data[i]) {
            largest = left;
        }

        if (right < max && data[right] > data[largest]) {
            largest = right;
        }
        if (largest != i) {
            int buf = data[i];
            data[i] = data[largest];
            data[largest] = buf;
            heapify(data, largest, max);
        }
    }

    public int[] quickSort(int[] data) {
        doQuick(data, 0, data.length - 1);
        return data;
    }

    private void doQuick(int[] data, int left, int right) {
        if (left < right) {
            Random generator = new Random();
            int pivotIndex = left + generator.nextInt(right - left);
            pivotIndex = partition(data, left, right, pivotIndex);

            doQuick(data, left, pivotIndex - 1);
            doQuick(data, pivotIndex + 1, right);
        }
    }

    private int partition(int[] data, int left, int right, int pivotIndex) {

        int pivot = data[pivotIndex];

        int tmp = data[right];
        data[right] = data[pivotIndex];
        data[pivotIndex] = tmp;

        int store = left;
        for (int i = left; i < right; i++) {
            if (data[i] <= pivot) {
                tmp = data[i];
                data[i] = data[store];
                data[store] = tmp;
                store++;
            }
        }


        tmp = data[right];
        data[right] = data[store];
        data[store] = tmp;
        return store;
    }


    public int[] mergeSort(int[] data) {

        int[] copy = new int[data.length];
        return doMerge(copy, data, 0, data.length);
    }

    private int[] doMerge(int[] copy, int[] data, int start, int end) {

        if (end - start < 2) {
            return data;
        }

        if (end - start == 2) {
            if (data[start] > data[start + 1]) {
                int tmp = data[start];
                data[start] = data[start + 1];
                data[start + 1] = tmp;
            }
            return data;
        }

        int mid = (end + start) / 2;
        doMerge(data, copy, start, mid);
        doMerge(data, copy, mid, end);


        int i = start;
        int j = mid;

        int idx = start;
        while (idx < end) {
            if ((j >= end) || (i < mid && copy[i] < copy[j])) {
                data[idx] = copy[i];
                i++;
            } else {
                data[idx] = copy[j];
                j++;
            }
            idx++;
        }

        return data;
    }
}
