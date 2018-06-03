package org.abondar.experimental.algorithms.tests;

import org.abondar.experimental.algorithms.SearchUtil;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SearchTest {

    private SearchUtil su = new SearchUtil();

    @Test
    public void seqSearchTest(){
        int[] data = new int[]{5,7,12,34,5,2,1};

        assertTrue(su.sequentialSearch(data,5));
        assertFalse(su.sequentialSearch(data,41));
    }

    @Test
    public void binSearchTest(){
        int[] data = new int[]{1,2,5,7,12,34};

        assertTrue(su.binarySearch(data,12));
        assertFalse(su.sequentialSearch(data,6));
    }
    @Test
    public void hashSearchTest(){
        int[] data = new int[]{5,7,12,34,5,2,1};

        assertTrue(su.hashSearch(data,5));
        assertFalse(su.hashSearch(data,41));
    }

}
