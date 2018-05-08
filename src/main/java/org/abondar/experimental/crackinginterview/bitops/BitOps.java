package org.abondar.experimental.crackinginterview.bitops;

import java.util.Arrays;

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



    public String binToStr(double num){
        String error = "ERROR";

        if (num>1 || num<0){
            return error;
        }

        StringBuilder res = new StringBuilder();
        while(num>0){
            if (res.length()>32){
                return error;
            }

            double r = num *2;
            if (r>=1){
                res.append("1");
                num = r-1;
            } else {
                res.append("0");
                num -=r;
            }
        }

        return res.toString();
    }


    public int conversion(int num1, int num2){

        int count =0;

        char[] nBit1 = Integer.toBinaryString(num1).toCharArray();
        char[] nBit2 = Integer.toBinaryString(num2).toCharArray();

        boolean[] n1 = BitUtil.convertToBoolArray(nBit1);
        boolean[] n2 = BitUtil.convertToBoolArray(nBit2);

        if (n1.length<n2.length){
            n1=fillZero(n1,Math.abs(n1.length-n2.length));
        } else {
            n2=fillZero(n2,Math.abs(n1.length-n2.length));
        }


        for (int i=0;i<n1.length;i++){
            if (n1[i]^n2[i]){
                count++;
            }
        }

        return count;

    }

    private boolean[] fillZero(boolean[] num,int diff) {
        int size = num.length+diff;

        boolean[] newNum = new boolean[size];

        for (int i=0;i<diff;i++){
            newNum[i]=false;
        }

        System.arraycopy(num, 0, newNum, diff, num.length);

        return newNum;

    }


}
