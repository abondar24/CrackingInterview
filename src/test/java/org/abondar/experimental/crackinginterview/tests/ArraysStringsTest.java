package org.abondar.experimental.crackinginterview.tests;

import org.abondar.experimental.crackinginterview.ArraysStrings;
import org.junit.Assert;
import org.junit.Test;

public class ArraysStringsTest {

    private ArraysStrings as = new ArraysStrings();

    @Test
    public void inUniqueTest() {

        boolean res = as.isUniqque("hello world");
        Assert.assertFalse(res);

        res = as.isUniqque("formula");
        Assert.assertTrue(res);

    }


    @Test
    public void checkPermutation() {
        boolean res = as.checkPermutation("debug", "buged");
        Assert.assertTrue(res);

        res = as.checkPermutation("debug", "cat");
        Assert.assertFalse(res);

        res = as.checkPermutation("debug", "bug");
        Assert.assertFalse(res);
    }

    @Test
    public void urllifyTest() {
        String url = as.urlify("Mr John Smith    ", 13);
        String expectedRes = "Mr%20John%20Smith";
        Assert.assertEquals(expectedRes, url);
    }


    @Test
    public void palindromePermutationTest() {
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
    public void oneAwayTest() {
        boolean res = as.oneAway("pale", "ple");
        Assert.assertTrue(res);

        res = as.oneAway("pales", "pale");
        Assert.assertTrue(res);

        res = as.oneAway("pale", "bale");
        Assert.assertTrue(res);

        res = as.oneAway("pale", "bake");
        Assert.assertFalse(res);

        res = as.oneAway("pale", "pale");
        Assert.assertTrue(res);

        res = as.oneAway("paalee", "pale");
        Assert.assertFalse(res);

        res = as.oneAway("pale", "pkb");
        Assert.assertFalse(res);
    }


    @Test
    public void stringCompressionTest() {
        String actual = as.stringCompressor("aabcccccaaa");
        String expected = "a2b1c5a3";
        Assert.assertEquals(expected, actual);

        actual = as.stringCompressor("abfcccgh");
        expected = "a1b1f1c3g1h1";
        Assert.assertEquals(expected, actual);


    }


    @Test
    public void rotateMatrixTest() {
        int[][] matrix = new int[3][3];
        matrix[0][0] = 1;
        matrix[0][1] = 2;
        matrix[0][2] = 3;
        matrix[1][0] = 4;
        matrix[1][1] = 5;
        matrix[1][2] = 6;
        matrix[2][0] = 7;
        matrix[2][1] = 8;
        matrix[2][2] = 9;

        int[][] expectedMatrix = new int[3][3];
        expectedMatrix[0][0] = 7;
        expectedMatrix[0][1] = 4;
        expectedMatrix[0][2] = 1;
        expectedMatrix[1][0] = 8;
        expectedMatrix[1][1] = 5;
        expectedMatrix[1][2] = 2;
        expectedMatrix[2][0] = 9;
        expectedMatrix[2][1] = 6;
        expectedMatrix[2][2] = 3;

        int [][] actualMatrix = as.rotateMatrix(matrix);
        Assert.assertArrayEquals(expectedMatrix,actualMatrix);

    }




    @Test
    public void rotateMatrixTestFour() {
        int[][] matrix = new int[4][4];
        matrix[0][0] = 1;
        matrix[0][1] = 2;
        matrix[0][2] = 3;
        matrix[0][3] = 4;
        matrix[1][0] = 5;
        matrix[1][1] = 6;
        matrix[1][2] = 7;
        matrix[1][3] = 8;
        matrix[2][0] = 9;
        matrix[2][1] = 10;
        matrix[2][2] = 11;
        matrix[2][3] = 12;
        matrix[3][0] = 13;
        matrix[3][1] = 14;
        matrix[3][2] = 15;
        matrix[3][3] = 16;

        int[][] expectedMatrix = new int[4][4];
        expectedMatrix[0][0] = 13;
        expectedMatrix[0][1] = 9;
        expectedMatrix[0][2] = 5;
        expectedMatrix[0][3] = 1;
        expectedMatrix[1][0] = 14;
        expectedMatrix[1][1] = 10;
        expectedMatrix[1][2] = 6;
        expectedMatrix[1][3] = 2;
        expectedMatrix[2][0] = 15;
        expectedMatrix[2][1] = 11;
        expectedMatrix[2][2] = 7;
        expectedMatrix[2][3] = 3;
        expectedMatrix[3][0] = 16;
        expectedMatrix[3][1] = 12;
        expectedMatrix[3][2] = 8;
        expectedMatrix[3][3] = 4;

        int [][] actualMatrix = as.rotateMatrix(matrix);
        Assert.assertArrayEquals(expectedMatrix,actualMatrix);

    }
}
