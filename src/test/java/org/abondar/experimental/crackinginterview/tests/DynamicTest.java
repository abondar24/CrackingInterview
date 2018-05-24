package org.abondar.experimental.crackinginterview.tests;

import org.abondar.experimental.crackinginterview.dynamic.Color;
import org.abondar.experimental.crackinginterview.dynamic.DynaicUtil;
import org.abondar.experimental.crackinginterview.dynamic.Tower;
import org.junit.Test;


import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

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

    @Test
    public void towerTest(){
        Tower[] res = du.hanoiTowers(7);
        assertEquals(0L,res[0].getDisks().size());
        assertEquals(0L,res[1].getDisks().size());
        assertEquals((Object) 0,(Object)res[2].getDisks().peek());

    }

    @Test
    public void paintFillTest(){
        Color[][] screen = new Color[4][5];

        Arrays.fill(screen[0],Color.Green);
        Arrays.fill(screen[1],Color.White);
        Arrays.fill(screen[2],Color.Yellow);
        Arrays.fill(screen[3],Color.Red);

        boolean res = du.paintFill(screen,1,2,Color.Black);

        for (int i=0;i<4;i++){
            for (int j=0;j<5;j++){
                System.out.print(screen[i][j]+ " ");
            }
            System.out.println();
        }
        assertTrue(res);
       // assertEquals(Color.Black,screen[0][2]);
        assertEquals(Color.Black,screen[1][3]);
        assertEquals(Color.Black,screen[1][1]);
       // assertEquals(Color.Black,screen[2][2]);

    }


    @Test
    public void paintFillTestFalse(){
        Color[][] screen = new Color[4][5];

        Arrays.fill(screen[0],Color.Black);
        Arrays.fill(screen[1],Color.White);
        Arrays.fill(screen[2],Color.Yellow);
        Arrays.fill(screen[3],Color.Red);

        boolean res = du.paintFill(screen,0,0,Color.Black);
        assertFalse(res);

    }
}
