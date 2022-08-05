package org.abondar.experimental.problems;

import org.abondar.experimental.problems.dynamic.Box;
import org.abondar.experimental.problems.dynamic.Color;
import org.abondar.experimental.problems.dynamic.Dynamic;
import org.abondar.experimental.problems.dynamic.Tower;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Test
    public void maxPermmutaionsNoDupsTestNonUnique() throws RuntimeException {
        assertThrows(RuntimeException.class,()-> dyn.maxPermutationsNoDups("aabc"));
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
        assertEquals(24L, res.size());
    }

    @Test
    public void maxPermsDups() {
        List<String> res = dyn.maxPermutationsDups("aabc");

        assertEquals(12L, res.size());
    }

    @Test
    public void parenthnessTest() {
        List<String> res = dyn.parentheses(2);

        assertEquals(2L, res.size());
        assertTrue(res.contains("(())"));
        assertTrue(res.contains("()()"));

        res = dyn.parentheses(3);

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

    @Test
    public void cutRodTest(){
        int[] data = {1,5,8,9,10,17,17,20};

        int res = dyn.cutRodMem(data,data.length);
        assertEquals(22L,res);

        res = dyn.cutRodBottomUp(data,data.length);
        assertEquals(22L,res);
    }

    @Test
    public void matrixChainMultOrderTest(){
        int [] chain = {40, 20, 30, 10, 30};
        int res = dyn.matrixChainMultOrder(chain);
        assertEquals(26000,res);

        chain = new int[]{10, 20, 30, 40, 30};
        res = dyn.matrixChainMultOrder(chain);
        assertEquals(30000,res);

        chain = new int[]{10, 20, 30};
        res = dyn.matrixChainMultOrder(chain);
        assertEquals(6000,res);
    }

    @Test
    public void longestCommonSubsequenceLenTest(){
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        int res = dyn.longestCommonSubsequenceLen(s1,s2);

        assertEquals(4,res);
    }
}
