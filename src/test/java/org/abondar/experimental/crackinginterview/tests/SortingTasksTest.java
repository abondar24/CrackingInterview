package org.abondar.experimental.crackinginterview.tests;

import org.abondar.experimental.crackinginterview.sortingTasks.Listy;
import org.abondar.experimental.crackinginterview.sortingTasks.SortingTasks;
import org.junit.Test;

import java.util.ArrayList;
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

    @Test
    public void rotatedSearchIndex(){
        int[] arr = {15,16,19,20,25,1,3,4,5,7,10,14};

        int res = st.rotatedSearch(arr,5);
        assertEquals(8,res);
    }

    @Test
    public void sortedSearchIndex(){
        int[] arr = {1,3,4,5,7,10,14};

        Listy list = new Listy(arr);
        int res = st.sortedSearch(list,5);
        assertEquals(3,res);
    }

    @Test
    public void sparseSearchTest(){
        String[] arr = {"at","","","","ball","","","car","","","dad","",""};

        int res = st.sparseSearch(arr,"ball");
        assertEquals(4,res);
    }

    @Test
    public void checkDupsTest(){
        int[] arr = {1,2,3,4,5,6,83,4,7,132,256,10000,28400,14567,7,18,24,24,100,10,55,12};

        List<Integer> res= st.checkDups(arr);
        assertEquals(3,res.size());
    }
}
