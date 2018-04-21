package org.abondar.experimental.crackinginterview.tests;

import org.abondar.experimental.crackinginterview.bitops.BitOps;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BitOpsTest {

    private BitOps bitOps = new BitOps();

    @Test
    @Ignore
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
}
