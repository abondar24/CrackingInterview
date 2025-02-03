package org.abondar.experimental.problems.bitops;

import org.abondar.experimental.TestUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BitOpsTest {

    private final BitOps bitOps = new BitOps();


    static Stream<Arguments> binToStrParams() {
        return Stream.of(
                Arguments.of(0.72d, "10"),
                Arguments.of(0.54d, "10")

        );
    }

    static Stream<Arguments> powerParams() {
        return Stream.of(
                Arguments.of(1, true),
                Arguments.of(16, true),
                Arguments.of(218, false),
                Arguments.of(4096, true)
        );
    }

    static Stream<Arguments> hamingParams() {
        return Stream.of(
                Arguments.of(11, 3),
                Arguments.of(128, 1),
                Arguments.of(-3, 31)
        );
    }

    static Stream<Arguments> addParams() {
        return Stream.of(
                Arguments.of("11", "1", "100"),
                Arguments.of("1010", "1011", "10101")
        );
    }

    static Stream<Arguments> sumParams() {
        return Stream.of(
                Arguments.of(1, 2, 3),
                Arguments.of(-2, 3, 1)
        );
    }

    static Stream<Arguments> uniqueParams() {
        return Stream.of(
                Arguments.of(List.of(3, 1, 2, 1, 2), 3),
                Arguments.of(List.of(1, 2, 3, 4, 3, 2, 1), 4),
                Arguments.of(List.of(1, 1, 2), 2),
                Arguments.of(List.of(0, 0, 1, 2, 1), 2));
    }

    static Stream<Arguments> maxXorParams() {
        return Stream.of(
                Arguments.of(11, 12, 7),
                Arguments.of(10, 15, 7),
                Arguments.of(11, 100, 127)
        );
    }

    static Stream<Arguments> flipParams() {
        return Stream.of(
                Arguments.of(9,4294967286L),
                Arguments.of( 2147483647L,2147483648L),
                Arguments.of(4,4294967291L),
                Arguments.of(1,4294967294L),
                Arguments.of(0,4294967295L),
                Arguments.of(123456,4294843839L),
                Arguments.of(802743475,3492223820L),
                Arguments.of(35601423,4259365872L)

                );
    }



    @Test
    public void insertTest() {
        int n = Integer.parseInt("10000000000", 2);
        int m = Integer.parseInt("10011", 2);

        int res = Integer.parseInt("10001001100", 2);

        int actualRes = bitOps.insert(n, m, 2, 6);
        assertEquals(res, actualRes);


    }

    @ParameterizedTest
    @MethodSource("binToStrParams")
    public void binToStrTest(double n, String nBin) {
        String res = bitOps.binToStr(n);

        assertEquals(nBin, res);
    }

    @Test
    public void conversionTest() {
        int n1 = 29;
        int n2 = 15;

        int res = bitOps.conversion(n1, n2);
        assertEquals(2, res);

        res = bitOps.conversionBs(n1, n2);
        assertEquals(2, res);

    }


    @Test
    public void pairwiseTest() {
        int n = 29;

        String swapped = "101110";
        int res = bitOps.pairwiseSwap(n);

        assertEquals(swapped, Integer.toBinaryString(res));


    }

    @Test
    public void flibBitTest() {
        int n = 1775;
        int res = bitOps.bitToWin(n);
        assertEquals(8, res);
    }

    @Test
    public void nextNumTest() {
        int n = 24;

        List<Integer> res = bitOps.nextNumber(n);

        assertEquals(20, (long) res.get(0));
        assertEquals(33, (long) res.get(1));
    }

    @Test
    public void drawLineTest() {

        int width = 64;
        int x1 = 4;
        int x2 = 15;
        int y = 6;

        byte[] screen = bitOps.drawLine(new byte[width], width, x1, x2, y);

        for (int i = 0; i < width; i++) {
            System.out.print(screen[i]);
        }

        System.out.println();
    }

    @ParameterizedTest
    @MethodSource("powerParams")
    public void isPowerOfTwoTest(int n, boolean expected) {
        boolean res = bitOps.isPowerOfTwo(n);

        TestUtil.verifyBooleanResult(expected, res);
    }

    @ParameterizedTest
    @MethodSource("hamingParams")
    public void hammingWeightTest(int n, int expected) {
        int res = bitOps.hammingWeight(n);
        assertEquals(expected, res);
    }


    @ParameterizedTest
    @MethodSource("addParams")
    public void addBinaryTest(String a, String b, String expected) {
        String res = bitOps.addBinary(a, b);
        assertEquals(expected, res);
    }

    @ParameterizedTest
    @MethodSource("sumParams")
    public void getSumTest(int a, int b, int expected) {
        int res = bitOps.getSum(a, b);
        assertEquals(expected, res);
    }

    @ParameterizedTest
    @MethodSource("uniqueParams")
    public void getUniqueIntegerTest(List<Integer> list, int expected) {
        int res = bitOps.getUniqueInteger(list);
        assertEquals(expected, res);
    }

    @ParameterizedTest
    @MethodSource("maxXorParams")
    public void maxXorTest(int low, int high, int expected) {
        int res = bitOps.maximizingXor(low, high);
        assertEquals(expected, res);
    }

    @ParameterizedTest
    @MethodSource("flipParams")
    public void flipBitTest(long num, long expected) {
        long res = bitOps.flipBits(num);
        assertEquals(expected, res);
    }

}
