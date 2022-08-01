package org.abondar.experimental.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchTest {

    private final SearchAlgs su = new SearchAlgs();

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

    @Test
    public void binSearchIndexTest() {
        int[] data = new int[]{1, 2, 5, 7, 12, 34};
        assertEquals(2, su.binarySearchIndex(data, 5));

        data = new int[]{5};
        assertEquals(0, su.binarySearchIndex(data, 5));
    }

    @Test
    public void hashSearchTest() {
        int[] data = new int[]{5, 7, 12, 34, 5, 2, 1};

        assertTrue(su.hashSearch(data, 5));
        assertFalse(su.hashSearch(data, 41));
    }

}
