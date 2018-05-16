package org.abondar.experimental.crackinginterview.tests;

import org.abondar.experimental.crackinginterview.dynamic.DynaicUtil;
import org.junit.Test;

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
}
