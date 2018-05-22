package org.abondar.experimental.crackinginterview.tests;

import org.abondar.experimental.crackinginterview.dynamic.DynaicUtil;
import org.junit.Test;


import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;

public class DynamicTest {

    private DynaicUtil du = new DynaicUtil();

    @Test
    public void countWaysTest(){

        int res = du.countWays(-1);
        assertEquals(0,res);

        res = du.countWays(0);
        assertEquals(1,res);

        res = du.countWays(6);
        assertEquals(24,res);

    }

    @Test
    public void countWaysMemoTest(){

        int res = du.countWaysMemo(-1);
        assertEquals(0,res);

        res = du.countWaysMemo(0);
        assertEquals(1,res);

        res = du.countWaysMemo(6);
        assertEquals(24,res);

    }

    @Test
    public void magicIndexTest(){
        int[] a = {-10,-5,2,2,2,3,4,7,9,12,13};

        int res = du.magicIndex(a);

        assertEquals(2,res);
    }

    @Test
    public void powerSetTest(){
        List<Integer> set = Arrays.asList(1,2,3);

        List<List<Integer>> res = du.powerSet(set);

        System.out.println(res);
        assertEquals(8,res.size());
        assertTrue(res.get(0).isEmpty());
        assertEquals(Arrays.asList(1,3),res.get(5));
        assertEquals(set,res.get(7));

    }

    @Test
    public void recursiveMultTest(){
        int res = du.recursiveMult(7,8);
        assertEquals(56,res);
    }
}
