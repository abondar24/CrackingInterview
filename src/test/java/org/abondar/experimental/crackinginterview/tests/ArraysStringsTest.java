package org.abondar.experimental.crackinginterview.tests;

import org.abondar.experimental.crackinginterview.ArraysStrings;
import org.junit.Assert;
import org.junit.Test;

public class ArraysStringsTest {

    private ArraysStrings as = new ArraysStrings();

    @Test
    public void inUniqueTest(){

        boolean res1 = as.isUniqque("hello world");
        Assert.assertFalse(res1);

        boolean res2 = as.isUniqque("formula");
        Assert.assertTrue(res2);

    }


    @Test
    public void checkPermutation(){
        boolean res1 = as.checkPermutation("debug","buged");
        Assert.assertTrue(res1);

        boolean res2 = as.checkPermutation("debug","cat");
        Assert.assertFalse(res2);

        boolean res3 = as.checkPermutation("debug","bug");
        Assert.assertFalse(res3);



    }
}
