package org.abondar.experimental.algorithms;

import org.junit.Test;


import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class SortingTest {

    private final int[] data = new int[]{5,7,12,34,5,2,1};
    private final SortingAlgs su = new SortingAlgs();

    @Test
    public void insertSortTest(){
        int []actualRes = su.insertionSort(data);

        assertEquals(1L,actualRes[0]);
        assertEquals(2L,actualRes[1]);
        assertEquals(5L,actualRes[2]);
        assertEquals(5L,actualRes[3]);
        assertEquals(7L,actualRes[4]);
        assertEquals(12L,actualRes[5]);
        assertEquals(34L,actualRes[6]);
    }

    @Test
    public void heapSortTest(){
        int []actualRes = su.heapSort(data);

        assertEquals(1L,actualRes[0]);
        assertEquals(2L,actualRes[1]);
        assertEquals(5L,actualRes[2]);
        assertEquals(5L,actualRes[3]);
        assertEquals(7L,actualRes[4]);
        assertEquals(12L,actualRes[5]);
        assertEquals(34L,actualRes[6]);
    }


    @Test
    public void quickSortTest(){
        int []actualRes = su.quickSort(data);

        assertEquals(1L,actualRes[0]);
        assertEquals(2L,actualRes[1]);
        assertEquals(5L,actualRes[2]);
        assertEquals(5L,actualRes[3]);
        assertEquals(7L,actualRes[4]);
        assertEquals(12L,actualRes[5]);
        assertEquals(34L,actualRes[6]);
    }

    @Test
    public void mergeSortTest(){
        int []actualRes = su.mergeSort(data);

        assertEquals(1L,actualRes[0]);
        assertEquals(2L,actualRes[1]);
        assertEquals(5L,actualRes[2]);
        assertEquals(5L,actualRes[3]);
        assertEquals(7L,actualRes[4]);
        assertEquals(12L,actualRes[5]);
        assertEquals(34L,actualRes[6]);
    }

    @Test
    public void selectionSortTest(){
        int []actualRes = su.selectionSort(data);

        System.out.println(Arrays.toString(actualRes));
        assertEquals(1L,actualRes[0]);
        assertEquals(2L,actualRes[1]);
        assertEquals(5L,actualRes[2]);
        assertEquals(5L,actualRes[3]);
        assertEquals(7L,actualRes[4]);
        assertEquals(12L,actualRes[5]);
        assertEquals(34L,actualRes[6]);
    }

    @Test
    public void countingSortTest(){
        int []actualRes = su.countingSort(data);

        assertEquals(1L,actualRes[0]);
        assertEquals(2L,actualRes[1]);
        assertEquals(5L,actualRes[2]);
        assertEquals(5L,actualRes[3]);
        assertEquals(7L,actualRes[4]);
        assertEquals(12L,actualRes[5]);
        assertEquals(34L,actualRes[6]);
    }
}
