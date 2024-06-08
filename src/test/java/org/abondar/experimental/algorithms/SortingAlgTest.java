package org.abondar.experimental.algorithms;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SortingAlgTest {

    private static final int[] data = new int[]{5, 7, 12, 34, 5, 2, 1};
    private static final int[] expected = new int[]{1, 2, 5, 5, 7, 12, 34};

    private final SortingAlgs su = new SortingAlgs();


    static Stream<Arguments> sortParams() {
        return Stream.of(
                Arguments.of(data, expected),
                Arguments.of(new int[]{121, 432, 564, 23, 1, 45, 788}, new int[]{1, 23, 45, 121, 432, 564, 788})
        );
    }

    @Test
    public void insertSortTest() {
        int[] actualRes = su.insertionSort(data);

        assertArrayEquals(expected, actualRes);
    }

    @Test
    public void heapSortTest() {
        int[] actualRes = su.heapSort(data);

        assertArrayEquals(expected, actualRes);
    }


    @Test
    public void quickSortTest() {
        int[] actualRes = su.quickSort(data);

        assertArrayEquals(expected, actualRes);
    }

    @Test
    public void mergeSortTest() {
        int[] actualRes = su.mergeSort(data);

        assertArrayEquals(expected, actualRes);
    }

    @Test
    public void selectionSortTest() {
        int[] actualRes = su.selectionSort(data);

        assertArrayEquals(expected, actualRes);
    }

    @Test
    public void countingSortTest() {
        int[] actualRes = su.countingSort(data);

        assertArrayEquals(expected, actualRes);
    }


    @ParameterizedTest
    @MethodSource("sortParams")
    public void radixSortTest(int[] data, int[] expected) {
        int[] actualRes = su.radixSort(data);

        assertArrayEquals(expected, actualRes);
    }

    @ParameterizedTest
    @MethodSource("sortParams")
    public void bucketSortTest(int[] data, int[] expected) {
        int[] actualRes = su.bucketSort(data);

        assertArrayEquals(expected, actualRes);
    }

    @Test
    public void bucketFloatSortTest() {
        double[] data = {0.42, 0.32, 0.33, 0.52, 0.37, 0.47, 0.51};
        double[] expected = {0.32, 0.33, 0.37, 0.42, 0.47, 0.51, 0.52};
        double[] actualRes = su.bucketSort(data);

        assertArrayEquals(expected, actualRes);
    }

    @Test
    public void bubbleSortTest() {
        int[] actualRes = su.bubbleSort(data);

        assertArrayEquals(expected, actualRes);
    }
}
