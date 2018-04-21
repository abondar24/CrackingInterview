package org.abondar.experimental.crackinginterview.bitops;

public class BitOps {

    public int insert(int n,int m,int i,int j){

        char[] mBit =  Integer.toBinaryString(m).toCharArray();

        boolean[] mBool = BitUtil.convertToBoolArray(mBit);

        int pos =i;
        for (int k=mBool.length-1;k>-1;k--) {
            n = BitUtil.updateBit(n,pos,mBool[k]);
            pos++;
            if (pos > j) {
                break;
            }
        }
    return n;
    }





}
