package org.abondar.experimental.crackinginterview.bitops;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public int conversionBs(int num1,int num2){
        int count =0;

        for (int xr=num1^num2;xr!=0;xr =xr >>>1){
            count+= xr&1;
        }

        return count;
    }


    public int pairwiseSwap(int x){
        return (((x & 0xaaaaaaaa) >>> 1) | ((x & 0x55555555) << 1));
    }

    public int flipBit(int num){
        if (~num ==0 ) return Integer.BYTES * 8;

        int curLen =0;
        int prevLen =0;

        int maxLen =1;

        while (num!=0){
            if ((num & 1)==1){
                curLen++;
            } else if ((num & 1)==0){
                //if next bit 0 upd to zero else  to 1
                prevLen = (num & 2) == 0? 0: curLen;
                curLen =0;
            }
            maxLen = Math.max(prevLen+curLen+1,maxLen);
            num >>>=1;
        }
        return maxLen;
    }


    public List<Integer> nextNumber(int num){
        List<Integer> res = new ArrayList<>();

        res.add(getPrev(num));
        res.add(getNext(num));

        return res;
    }


    private int getNext(int n){
        int tmp = n;
        int c0 = 0;
        int c1 =0;

        while (((tmp & 1)==0) && (tmp!=0)){
            c0++;
            tmp >>=1;
        }

        while ((tmp & 1)==1){
            c1++;
            tmp >>=1;
        }


        if (c0+c1 == 31 || c0+c1==0){
            return -1;
        }

        //pos of rightmost non-trailing zero
        int p = c0 + c1;

        // flip right bits
        n |= (1<<p);

        // clear bits right to p
        n &= ~((1<<p)-1);

        // insert c1-1 ones to the right
        n |= (1<<(c1-1))-1;

        return n;

    }

    public byte[] drawLine(byte[] screen, int width, int x1,int x2, int y){

        int startOffset = x1 % 8;
        int firstFullByte = x1 / 8;

        if (startOffset !=0){
            firstFullByte++;
        }

        int endOffset = x2 % 8;
        int lastFullByte = x2 / 8;
        if (endOffset !=7){
            lastFullByte--;
        }

        //set full bytes
        for (int b = firstFullByte;b<lastFullByte;b++){
            screen[(width / 8) * y + b] = (byte) 0xff;
        }

        // masks for start and end of line
        byte startMask = (byte) (0xff >> startOffset);
        byte endMask = (byte) ~(0xff >> (endOffset+1));

        // set start and end of the line
        // x1 and x2 are in the same byte
        if ((x1 / 8) == (x2 / 8)){
            byte mask = (byte) (startMask & endMask);
            screen[(width / 8) * y + (x1 / 8)] |=mask;
        } else {
            if (startOffset !=0){
                int byteNum = (width / 8) * y + firstFullByte - 1;
                screen[byteNum] |= startMask;
            }

            if (endOffset !=7){
                int byteNum = (width / 8) * y + lastFullByte + 1;
                screen[byteNum] |= endMask;
            }
        }

        return screen;
    }

    private int getPrev(int n){
        int tmp =n;

        int c0 = 0;
        int c1 =0;

        while ((tmp & 1) ==1 ){
            c1++;
            tmp >>=1;
        }

        if (tmp ==0) return -1;

        while (((tmp & 1)==0) && (tmp!=0)){
            c0++;
            tmp >>=1;
        }



        //pos of rightmost non-trailing one
        int p = c0 + c1;

        // clear bits from p onwards
        n &= ((~0)<<(p+1));

        // sequence of c1+1 ones
        int mask = (1 << (c1+1))-1;
        n |= mask <<(c0 -1);
        return n;
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
