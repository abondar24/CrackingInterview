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

    @Test
    public void urllifyTest(){
        String url = as.urlify("Mr John Smith    ",13);
        String expectedRes = "Mr%20John%20Smith";
        Assert.assertEquals(expectedRes,url);
    }


    @Test
    public void palindromePermutationTest(){
        boolean res = as.palindromePermutation("Tact Coa");
        Assert.assertTrue(res);

        boolean res1 = as.palindromePermutation("Tact Coat");
        Assert.assertFalse(res1);

        boolean res2 = as.palindromePermutation("aabcb");
        Assert.assertTrue(res2);

        boolean res3 = as.palindromePermutation("civil");
        Assert.assertFalse(res3);
    }


    @Test
    public void oneAwayTest(){
        boolean res1 = as.oneAway("pale","ple");
        Assert.assertTrue(res1);

        boolean res2 = as.oneAway("pales","pale");
        Assert.assertTrue(res2);

        boolean res3 = as.oneAway("pale","bale");
        Assert.assertTrue(res3);

        boolean res4 = as.oneAway("pale","bake");
        Assert.assertFalse(res4);

        boolean res5 = as.oneAway("pale","pale");
        Assert.assertTrue(res5);

        boolean res6 = as.oneAway("paalee","pale");
        Assert.assertFalse(res6);

        boolean res7 = as.oneAway("pale","pkb");
        Assert.assertFalse(res7);
    }
}
