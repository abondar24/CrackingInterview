package org.abondar.experimental.algorithms;

import org.junit.Test;


import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class SortingTest {

    private int[] data = new int[]{5,7,12,34,5,2,1};
    private SortingUtil su = new SortingUtil();

    @Test
    public void insertSortTest(){
        int []actualRes = su.insertionSort(data);

        for (int aData : data) {
            System.out.println(aData);
        }

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

        for (int aData : data) {
            System.out.println(aData);
        }

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

        for (int aData : data) {
            System.out.println(aData);
        }

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

        for (int aData : data) {
            System.out.println(aData);
        }

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

        for (int aData : data) {
            System.out.println(aData);
        }

        System.out.println(Arrays.toString(actualRes));
        assertEquals(1L,actualRes[0]);
        assertEquals(2L,actualRes[1]);
        assertEquals(5L,actualRes[2]);
        assertEquals(5L,actualRes[3]);
        assertEquals(7L,actualRes[4]);
        assertEquals(12L,actualRes[5]);
        assertEquals(34L,actualRes[6]);
    }

}
