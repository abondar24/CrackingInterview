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




}
