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
}
