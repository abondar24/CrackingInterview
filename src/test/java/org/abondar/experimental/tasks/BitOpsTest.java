package org.abondar.experimental.tasks;

import org.abondar.experimental.tasks.bitops.BitOps;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BitOpsTest {

    private final BitOps bitOps = new BitOps();

    @Test
    public void insertTest() {
        int n = Integer.parseInt("10000000000", 2);
        int m = Integer.parseInt("10011", 2);

        int res = Integer.parseInt("10001001100", 2);

        int actualRes = bitOps.insert(n, m, 2, 6);
        assertEquals(res, actualRes);


    }

    @Test
    public void binToStrTest() {

        double n = 0.72d;

        String nBin = "10";

        String res = bitOps.binToStr(n);
        assertEquals(nBin, res);


        n = 0.54d;

        nBin = "10";

        res = bitOps.binToStr(n);
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
        int res = bitOps.flipBit(n);
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

    @Test
    public void isPowerOfTwoTest() {
        boolean res = bitOps.isPowerOfTwo(1);
        assertTrue(res);

        res = bitOps.isPowerOfTwo(16);
        assertTrue(res);

        res = bitOps.isPowerOfTwo(218);
        assertFalse(res);

        res = bitOps.isPowerOfTwo(4096);
        assertTrue(res);
    }

    @Test
    public void hammingWeightTest() {
        int res = bitOps.hammingWeight(11);
        assertEquals(3, res);

        res = bitOps.hammingWeight(128);
        assertEquals(1, res);

        res = bitOps.hammingWeight(-3);
        assertEquals(31, res);
    }


    @Test
    public void addBinaryTest() {
        String a = "11";
        String b = "1";
        String res = bitOps.addBinary(a, b);
        assertEquals("100", res);

        a = "1010";
        b = "1011";
        res = bitOps.addBinary(a, b);
        assertEquals("10101", res);
    }

    @Test
    public void getSumTest() {
        int res = bitOps.getSum(1, 2);
        assertEquals(3, res);

        res = bitOps.getSum(-2, 3);
        assertEquals(1, res);
    }
}
