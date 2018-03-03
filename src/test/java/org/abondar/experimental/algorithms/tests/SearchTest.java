package org.abondar.experimental.algorithms.tests;

import org.abondar.experimental.algorithms.SearchUtil;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SearchTest {

    @Test
    public void seqSearchTest(){
        int[] data = new int[]{5,7,12,34,5,2,1};

        assertTrue(SearchUtil.sequentialSearch(data,5));
        assertFalse(SearchUtil.sequentialSearch(data,41));
    }

    @Test
    public void binSearchTest(){
        int[] data = new int[]{1,2,5,7,12,34};

        assertTrue(SearchUtil.binarySearch(data,12));
        assertFalse(SearchUtil.sequentialSearch(data,6));
    }
    @Test
    public void hashSearchTest(){
        int[] data = new int[]{5,7,12,34,5,2,1};

        assertTrue(SearchUtil.hashSearch(data,5));
        assertFalse(SearchUtil.hashSearch(data,41));
    }

}
