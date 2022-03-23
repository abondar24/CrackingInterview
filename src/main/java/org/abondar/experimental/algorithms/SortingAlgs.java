package org.abondar.experimental.algorithms;

import java.util.Random;

public class SortingAlgs {
    //todo add bubble sort
    public int[] countingSort(int[] data) {
        int[] res = new int[data.length];

        int max = getMax(data, data[0]);

        int[] count = new int[max + 1];

        //count of each elem
        for (int datum : data) {
            count[datum]++;
        }

        //calc cumulitive count - sum previous elem + current val
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        for (int i = data.length - 1; i >= 0; i--) {
            res[count[data[i]] - 1] = data[i];
            count[data[i]]--;
        }


        return res;
    }

    public int[] radixSort(int[] data) {
        int[] res;
        int max = getMax(data, data.length);

        for (int place = 1; max / place > 0; place *= 10) {
            res = countingSortRadix(data, place);
            System.arraycopy(res, 0, data, 0, data.length);
        }

        return data;
    }


    private int[] countingSortRadix(int[] data, int place) {
        int[] res = new int[data.length];

        int max = getMax(data, data[0]);

        int[] count = new int[max + 1];

        for (int datum : data) {
            count[(datum / place) % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = data.length - 1; i >= 0; i--) {
            res[count[(data[i] / place) % 10] - 1] = data[i];
            count[(data[i] / place) % 10]--;
        }

        // System.arraycopy(res, 0, data, 0, data.length);

        return res;
    }

    private int getMax(int[] data, int init) {
        int max = init;
        for (int datum : data) {
            if (datum > max) {
                max = datum;
            }
        }

        return max;
    }

    //todo bucket sort

    public int[] selectionSort(int[] data) {

        for (int i = 0; i < data.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[j] < data[minIndex]) {
                    minIndex = j;
                }
            }

            int min = data[minIndex];
            data[minIndex] = data[i];
            data[i] = min;
        }

        return data;
    }


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

    public int[] doMerge(int[] copy, int[] data, int start, int end) {

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
