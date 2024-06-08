package org.abondar.experimental.algorithms;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchTest {

    private final SearchAlgs su = new SearchAlgs();

    static Stream<Arguments> binParams() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 5, 7, 12, 34}, 5, 2),
                Arguments.of(new int[]{5}, 5, 0)
        );
    }

    @Test
    public void seqSearchTest() {
        int[] data = new int[]{5, 7, 12, 34, 5, 2, 1};

        assertTrue(su.sequentialSearch(data, 5));
        assertFalse(su.sequentialSearch(data, 41));
    }

    @Test
    public void binSearchTest() {
        int[] data = new int[]{1, 2, 5, 7, 12, 34};

        assertTrue(su.binarySearch(data, 12));
        assertFalse(su.sequentialSearch(data, 6));
    }

    @ParameterizedTest
    @MethodSource("binParams")
    public void binSearchIndexTest(int[] data, int elem, int pos) {
        assertEquals(pos, su.binarySearchIndex(data, elem));
    }

    @Test
    public void hashSearchTest() {
        int[] data = new int[]{5, 7, 12, 34, 5, 2, 1};

        assertTrue(su.hashSearch(data, 5));
        assertFalse(su.hashSearch(data, 41));
    }

}
