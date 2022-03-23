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

    @Test
    public void radixSortTest(){
        int []actualRes = su.radixSort(data);

        assertEquals(1L,actualRes[0]);
        assertEquals(2L,actualRes[1]);
        assertEquals(5L,actualRes[2]);
        assertEquals(5L,actualRes[3]);
        assertEquals(7L,actualRes[4]);
        assertEquals(12L,actualRes[5]);
        assertEquals(34L,actualRes[6]);
    }

    @Test
    public void radixSortHundredTest(){
        int[] data = { 121, 432, 564, 23, 1, 45, 788 };
        int []actualRes = su.radixSort(data);

        assertEquals(1L,actualRes[0]);
        assertEquals(23L,actualRes[1]);
        assertEquals(45L,actualRes[2]);
        assertEquals(121L,actualRes[3]);
        assertEquals(432L,actualRes[4]);
        assertEquals(564L,actualRes[5]);
        assertEquals(788L,actualRes[6]);
    }


    @Test
    public void bucketSortTest(){
        int []actualRes = su.bucketSort(data);

        assertEquals(1L,actualRes[0]);
        assertEquals(2L,actualRes[1]);
        assertEquals(5L,actualRes[2]);
        assertEquals(5L,actualRes[3]);
        assertEquals(7L,actualRes[4]);
        assertEquals(12L,actualRes[5]);
        assertEquals(34L,actualRes[6]);

        int[] data = { 121, 432, 564, 23, 1, 45, 788 };
        actualRes = su.bucketSort(data);

        assertEquals(1L,actualRes[0]);
        assertEquals(23L,actualRes[1]);
        assertEquals(45L,actualRes[2]);
        assertEquals(121L,actualRes[3]);
        assertEquals(432L,actualRes[4]);
        assertEquals(564L,actualRes[5]);
        assertEquals(788L,actualRes[6]);
    }

    @Test
    public void bucketFloatSortTest(){
        double[] data = { 0.42, 0.32, 0.33, 0.52, 0.37, 0.47, 0.51 };
        double[] actualRes = su.bucketSort(data);

        assertEquals( 0.32,actualRes[0],0.01);
        assertEquals(0.33,actualRes[1],0.01);
        assertEquals(0.37,actualRes[2],0.01);
        assertEquals(0.42,actualRes[3],0.01);
        assertEquals(0.47,actualRes[4],0.01);
        assertEquals(0.51,actualRes[5],0.01);
        assertEquals(0.52,actualRes[6],0.01);
    }

    @Test
    public void bubbleSortTest(){
        int []actualRes = su.bubbleSort(data);

        assertEquals(1L,actualRes[0]);
        assertEquals(2L,actualRes[1]);
        assertEquals(5L,actualRes[2]);
        assertEquals(5L,actualRes[3]);
        assertEquals(7L,actualRes[4]);
        assertEquals(12L,actualRes[5]);
        assertEquals(34L,actualRes[6]);
    }
}
