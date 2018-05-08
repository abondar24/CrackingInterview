package org.abondar.experimental.crackinginterview.tests;

import org.abondar.experimental.crackinginterview.bitops.BitOps;
import org.abondar.experimental.crackinginterview.bitops.BitUtil;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BitOpsTest {

    private BitOps bitOps = new BitOps();

    @Test
    public void insertTest(){
        int n = Integer.parseInt("10000000000",2);
        int m = Integer.parseInt("10011",2);

        System.out.printf("N: %d\n",n);
        System.out.printf("M: %d\n",m);

        int res = Integer.parseInt("10001001100",2);
        System.out.printf("Expected res: %d\n",res);

        int actualRes = bitOps.insert(n,m,2,6);
        assertEquals(res,actualRes);


    }

    @Test
    public void binToStrTest(){

        double n = 0.72d;

        String nBin = "10";

        String res = bitOps.binToStr(n);
        assertEquals(nBin,res);


        n = 0.54d;

        nBin = "10";

        res = bitOps.binToStr(n);
        assertEquals(nBin,res);
    }

    @Test
    public void conversionTest(){
        int n1=29;
        int n2=15;

        int res = bitOps.conversion(n1,n2);

        assertEquals(2,res);
    }
}
