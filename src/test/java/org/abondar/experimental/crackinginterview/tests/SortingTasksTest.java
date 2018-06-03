package org.abondar.experimental.crackinginterview.tests;

import org.abondar.experimental.crackinginterview.sortingTasks.SortingTasks;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SortingTasksTest {
    private SortingTasks st = new SortingTasks();

    @Test
    public void sortedMergeTest(){

        int[] A = {1,2,3,4,5,6,7,8,9};
        int[] B = {2,3,5,12};

        int[] res = st.sortedMerge(A,B);

        for (int re : res) {
            System.out.println(re);
        }


        assertEquals(A.length+B.length,res.length);
        assertEquals(1,res[0]);
        assertEquals(12,res[12]);
    }

    @Test
    public void groupAnagramsTest(){
        String[] arr = {"race","baba","care","abba"};

        List<String> rs = Arrays.asList(st.groupAnagrams(arr));

        assertEquals(1,Math.abs(rs.indexOf("race")-rs.indexOf("care")));
        assertEquals(1,Math.abs(rs.indexOf("baba")-rs.indexOf("abba")));

    }
}
