package org.abondar.experimental.tasks.bitops;

public class BitUtil {

    public static boolean getBit(int number, int i) {
        return ((number & (1 << i)) != 0);
    }

    public static int setBit(int number, int i) {
        return number | (1 << i);
    }

    public static int clearBit(int number, int i) {
        int mask = ~(1 << i);
        return number & mask;
    }

    public static int clearMostSignificantBit(int number, int i) {
        int mask = (1 << i) - 1;
        return number & mask;
    }

    public static int clearBitThrough0(int number, int i) {
        int mask = (-1 << (i + 1));
        return number & mask;
    }

    public static int updateBit(int number, int i, boolean bitIs1) {
        int value = bitIs1 ? 1 : 0;
        return clearBit(number, i) | (value << i);
    }


    public static int repeatedArithmeticShift(int x, int count) {
        for (int i = 0; i < count; i++) {
            x >>= 1;
        }

        return x;
    }

    public static int repaeatedLogicalShift(int x, int count) {
        for (int i = 0; i < count; i++) {
            x >>>= 1;
        }

        return x;
    }

    public static boolean[] convertToBoolArray(char[] bits) {
        boolean[] res = new boolean[bits.length];
        for (int i = 0; i < bits.length; i++) {
            res[i] = bits[i] != '0';
        }

        return res;
    }
}
