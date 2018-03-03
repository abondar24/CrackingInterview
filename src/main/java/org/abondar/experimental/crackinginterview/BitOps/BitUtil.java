package org.abondar.experimental.crackinginterview.BitOps;

public class BitUtil {

    public static boolean getBit(int number, int i) {
        return ((number & (1 << i)) != 0);
    }

    public static int setBit(int number, int i) {
        return number | (1<<i);
    }

    public static int clearBit(int number, int i){
        int mask = ~(1<<i);
        return number & mask;
    }

    public static int clearMostSignificantBit(int number, int i){
        int mask = (1<<i)-1;
        return number & mask;
    }

    public static int clearBitThrough0(int number, int i){
        int mask = (-1 <<(i+1));
        return number & mask;
    }

    public static int updateBit(int number,int i,boolean bitIs1){
        int value = bitIs1 ? 1:0;
        return clearBit(number,i) | (value<<i);
    }



}
