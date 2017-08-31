package org.abondar.experimental.crackinginterview.tests;

import org.abondar.experimental.crackinginterview.ArraysStrings;
import org.junit.Assert;
import org.junit.Test;

public class ArraysStringsTest {

    private ArraysStrings as = new ArraysStrings();

    @Test
    public void inUniqueTest(){

        boolean res = as.isUniqque("hello world");
        Assert.assertFalse(res);

        res = as.isUniqque("formula");
        Assert.assertTrue(res);

    }


    @Test
    public void checkPermutation(){
        boolean res = as.checkPermutation("debug","buged");
        Assert.assertTrue(res);

        res = as.checkPermutation("debug","cat");
        Assert.assertFalse(res);

        res = as.checkPermutation("debug","bug");
        Assert.assertFalse(res);
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

        res = as.palindromePermutation("Tact Coat");
        Assert.assertFalse(res);

        res = as.palindromePermutation("aabcb");
        Assert.assertTrue(res);

        res = as.palindromePermutation("civil");
        Assert.assertFalse(res);
    }


    @Test
    public void oneAwayTest(){
        boolean res = as.oneAway("pale","ple");
        Assert.assertTrue(res);

        res = as.oneAway("pales","pale");
        Assert.assertTrue(res);

        res = as.oneAway("pale","bale");
        Assert.assertTrue(res);

        res = as.oneAway("pale","bake");
        Assert.assertFalse(res);

        res = as.oneAway("pale","pale");
        Assert.assertTrue(res);

        res = as.oneAway("paalee","pale");
        Assert.assertFalse(res);

        res = as.oneAway("pale","pkb");
        Assert.assertFalse(res);
    }


    @Test
    public void  stringCompressionTest(){
        String actual = as.stringCompressor("aabcccccaaa");
        String expected = "a2b1c5a3";
        Assert.assertEquals(expected,actual);

        actual = as.stringCompressor("abfcccgh");
        expected = "a1b1f1c3g1h1";
        Assert.assertEquals(expected,actual);


    }
}
