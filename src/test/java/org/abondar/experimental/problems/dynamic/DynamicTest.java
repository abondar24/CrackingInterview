package org.abondar.experimental.problems.dynamic;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class DynamicTest {

    private final Dynamic dyn = new Dynamic();

    private static Stream<Arguments> countParams() {
        return Stream.of(
                Arguments.of(-1, 0),
                Arguments.of(0, 1),
                Arguments.of(6, 24)
        );
    }

    private static Stream<Arguments> parParams() {
        return Stream.of(
                Arguments.of(2, List.of("(())", "()()")),
                Arguments.of(3, List.of("(()())", "((()))", "()(())", "(())()", "()()()"))
        );
    }

    private static Stream<Arguments> evalParams() {
        return Stream.of(
                Arguments.of("1^0|0|1", false, 2),
                Arguments.of("0&0&0&1^1|0", true, 10)
        );
    }


    private static Stream<Arguments> sayParams() {
        return Stream.of(
                Arguments.of(-1, ""),
                Arguments.of(31, ""),
                Arguments.of(1, "1"),
                Arguments.of(2, "11"),
                Arguments.of(3, "21"),
                Arguments.of(4, "1211"),
                Arguments.of(5, "111221")
                );
    }

    private static Stream<Arguments> matrixChainParams() {
        return Stream.of(
                Arguments.of(new int[] {40, 20, 30, 10, 30}, 26000),
                Arguments.of(new int[]{10, 20, 30, 40, 30}, 30000),
                Arguments.of(new int[]{10, 20, 30}, 6000)
        );
    }

    @ParameterizedTest
    @MethodSource("countParams")
    public void countWaysTest(int count, int expected) {
        int res = dyn.countWays(count);
        assertEquals(expected, res);
    }

    @ParameterizedTest
    @MethodSource("countParams")
    public void countWaysMemoTest(int count, int expected) {
        int res = dyn.countWaysMemo(count);
        assertEquals(expected, res);
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
        assertEquals(Color.Black, screen[1][3]);
        assertEquals(Color.Black, screen[1][1]);
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
        assertThrows(RuntimeException.class, () -> dyn.maxPermutationsNoDups("aabc"));
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

    @ParameterizedTest
    @MethodSource("parParams")
    public void parenthnessTest(int pairs, List<String> expectedRes) {
        List<String> res = dyn.parentheses(pairs);

        assertEquals(expectedRes.size(), res.size());
        expectedRes.forEach(er -> assertTrue(res.contains(er)));
    }

    @Test
    public void coinsTest() {
        int ways = dyn.coins(25);
        assertEquals(144L, ways);
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

    @ParameterizedTest
    @MethodSource("evalParams")
    public void exprEval(String expr, boolean res, int expected) {
        int actual = dyn.countEval(expr, res);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("sayParams")
    public void countAndSayTest(int count, String expected) {
        String res = dyn.countAndSay(count);
        assertEquals(expected, res);
    }

    @Test
    public void cutRodTest() {
        int[] data = {1, 5, 8, 9, 10, 17, 17, 20};

        int res = dyn.cutRodMem(data, data.length);
        assertEquals(22L, res);

        res = dyn.cutRodBottomUp(data, data.length);
        assertEquals(22L, res);
    }

    @ParameterizedTest
    @MethodSource("matrixChainParams")
    public void matrixChainMultOrderTest(int[] chain, int expected) {
        int res = dyn.matrixChainMultOrder(chain);
        assertEquals(expected, res);
    }

    @Test
    public void longestCommonSubsequenceLenTest() {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        int res = dyn.longestCommonSubsequenceLen(s1, s2);

        assertEquals(4, res);
    }
}
