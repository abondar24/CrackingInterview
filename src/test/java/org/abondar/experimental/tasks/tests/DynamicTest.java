package org.abondar.experimental.tasks.tests;

import org.abondar.experimental.tasks.dynamic.Box;
import org.abondar.experimental.tasks.dynamic.Color;
import org.abondar.experimental.tasks.dynamic.Dynamic;
import org.abondar.experimental.tasks.dynamic.Tower;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DynamicTest {

    private final Dynamic dyn = new Dynamic();

    @Test
    public void countWaysTest() {

        int res = dyn.countWays(-1);
        assertEquals(0, res);

        res = dyn.countWays(0);
        assertEquals(1, res);

        res = dyn.countWays(6);
        assertEquals(24, res);

    }

    @Test
    public void countWaysMemoTest() {

        int res = dyn.countWaysMemo(-1);
        assertEquals(0, res);

        res = dyn.countWaysMemo(0);
        assertEquals(1, res);

        res = dyn.countWaysMemo(6);
        assertEquals(24, res);

    }

    @Test
    public void magicIndexTest() {
        int[] a = {-10, -5, 2, 2, 2, 3, 4, 7, 9, 12, 13};

        int res = dyn.magicIndex(a);

        assertEquals(2, res);
    }

    @Test
    public void powerSetTest() {
        List<Integer> set = Arrays.asList(1, 2, 3);

        List<List<Integer>> res = dyn.powerSet(set);

        System.out.println(res);
        assertEquals(8, res.size());
        assertTrue(res.get(0).isEmpty());
        assertEquals(Arrays.asList(1, 3), res.get(5));
        assertEquals(set, res.get(7));

    }

    @Test
    public void recursiveMultTest() {
        int res = dyn.recursiveMult(7, 8);
        assertEquals(56, res);
    }

    @Test
    public void towerTest() {
        Tower[] res = dyn.hanoiTowers(7);
        assertEquals(0L, res[0].getDisks().size());
        assertEquals(0L, res[1].getDisks().size());


    }

    @Test
    public void paintFillTest() {
        Color[][] screen = new Color[4][5];

        Arrays.fill(screen[0], Color.Green);
        Arrays.fill(screen[1], Color.White);
        Arrays.fill(screen[2], Color.Yellow);
        Arrays.fill(screen[3], Color.Red);

        boolean res = dyn.paintFill(screen, 1, 2, Color.Black);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(screen[i][j] + " ");
            }
            System.out.println();
        }
        assertTrue(res);
        // assertEquals(Color.Black,screen[0][2]);
        assertEquals(Color.Black, screen[1][3]);
        assertEquals(Color.Black, screen[1][1]);
        // assertEquals(Color.Black,screen[2][2]);

    }


    @Test
    public void paintFillTestFalse() {
        Color[][] screen = new Color[4][5];

        Arrays.fill(screen[0], Color.Black);
        Arrays.fill(screen[1], Color.White);
        Arrays.fill(screen[2], Color.Yellow);
        Arrays.fill(screen[3], Color.Red);

        boolean res = dyn.paintFill(screen, 0, 0, Color.Black);
        assertFalse(res);

    }

    @Test(expected = RuntimeException.class)
    public void maxPermmutaionsNoDupsTestNonUnique() throws RuntimeException {
        dyn.maxPermutationsNoDups("aabc");
    }

    @Test
    public void maxPermmutaionsNoDupsTestEmpty() {
        List<String> res = dyn.maxPermutationsNoDups("");
        assertEquals(1L, res.size());
        assertEquals("", res.get(0));
    }

    @Test
    public void maxPermmutaionsNoDupsTest() {
        List<String> res = dyn.maxPermutationsNoDups("abcd");
        System.out.println(res);
        assertEquals(24L, res.size());
    }

    @Test
    public void maxPermsDups() {
        List<String> res = dyn.maxPermutationsDups("aabc");

        System.out.println(res);
        assertEquals(12L, res.size());
    }

    @Test
    public void parenthnessTest() {
        List<String> res = dyn.parentheses(2);

        System.out.println(res);
        assertEquals(2L, res.size());
        assertTrue(res.contains("(())"));
        assertTrue(res.contains("()()"));

        res = dyn.parentheses(3);

        System.out.println(res);
        assertEquals(5L, res.size());
        assertTrue(res.contains("(()())"));
        assertTrue(res.contains("((()))"));
        assertTrue(res.contains("()(())"));
        assertTrue(res.contains("(())()"));
        assertTrue(res.contains("()()()"));
    }

    @Test
    public void coinsTest() {
        int ways = dyn.coins(25);
        assertEquals(144L, ways);

        ways = dyn.coins(100);
        System.out.println(ways);

    }


    @Test
    public void boxesCompareTest() {
        Box b1 = new Box(1, 2, 3);
        Box b2 = new Box(2, 2, 2);

        assertTrue(b1.compareTo(b2) > 0);

        List<Box> boxList = Arrays.asList(b1, b2);
        Collections.sort(boxList);

        assertEquals(b2, boxList.get(0));
        assertEquals(b1, boxList.get(1));
    }

    @Test
    public void boxesStackTest() {
        Box b1 = new Box(5, 2, 3);
        Box b2 = new Box(2, 2, 2);
        Box b3 = new Box(7, 2, 3);
        Box b4 = new Box(3, 2, 2);

        List<Box> boxList = Arrays.asList(b1, b2, b3, b4);

        int res = dyn.boxesStack(boxList);

        assertEquals(17L, res);
    }

    @Test
    public void exprEval() {
        int res = dyn.countEval("1^0|0|1", false);
        assertEquals(2L, res);

        res = dyn.countEval("0&0&0&1^1|0", true);
        assertEquals(10L, res);
    }

    @Test
    public void countAndSayTest() {
        String res = dyn.countAndSay(-1);
        assertEquals("", res);

        res = dyn.countAndSay(31);
        assertEquals("", res);

        res = dyn.countAndSay(1);
        assertEquals("1", res);

        res = dyn.countAndSay(2);
        assertEquals("11", res);

        res = dyn.countAndSay(3);
        assertEquals("21", res);

        res = dyn.countAndSay(4);
        assertEquals("1211", res);

        res = dyn.countAndSay(5);
        assertEquals("111221", res);
    }
}
