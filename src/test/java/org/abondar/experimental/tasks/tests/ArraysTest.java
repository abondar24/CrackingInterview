package org.abondar.experimental.tasks.tests;

import org.abondar.experimental.tasks.arrays.Arrays;
import org.junit.Assert;
import org.junit.Test;

public class ArraysTest {

    private Arrays arrays = new Arrays();

    @Test
    public void twoSumTest() {
        int[] arr = {2, 7, 11, 15};
        int target = 9;
        int[] expected = {0, 1};

        int[] actual = arrays.twoSum(arr, target);
        Assert.assertArrayEquals(expected, actual);
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

        int[][] actualMatrix = arrays.rotateMatrix(matrix);
        Assert.assertArrayEquals(expectedMatrix, actualMatrix);

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

        int[][] actualMatrix = arrays.rotateMatrix(matrix);
        Assert.assertArrayEquals(expectedMatrix, actualMatrix);

    }


    @Test
    public void zeroMatrixTest() {
        int[][] matrix = new int[3][3];
        matrix[0][0] = 1;
        matrix[0][1] = 2;
        matrix[0][2] = 3;
        matrix[1][0] = 0;
        matrix[1][1] = 5;
        matrix[1][2] = 6;
        matrix[2][0] = 7;
        matrix[2][1] = 8;
        matrix[2][2] = 9;

        int[][] expectedMatrix = new int[3][3];
        expectedMatrix[0][0] = 0;
        expectedMatrix[0][1] = 2;
        expectedMatrix[0][2] = 3;
        expectedMatrix[1][0] = 0;
        expectedMatrix[1][1] = 0;
        expectedMatrix[1][2] = 0;
        expectedMatrix[2][0] = 0;
        expectedMatrix[2][1] = 8;
        expectedMatrix[2][2] = 9;

        int[][] actualMatrix = arrays.zeroMatrix(matrix);
        Assert.assertArrayEquals(expectedMatrix, actualMatrix);

    }


    @Test
    public void zeroMatrixTestDoubleZero() {
        int[][] matrix = new int[3][3];
        matrix[0][0] = 1;
        matrix[0][1] = 2;
        matrix[0][2] = 3;
        matrix[1][0] = 0;
        matrix[1][1] = 5;
        matrix[1][2] = 6;
        matrix[2][0] = 7;
        matrix[2][1] = 0;
        matrix[2][2] = 9;

        int[][] expectedMatrix = new int[3][3];
        expectedMatrix[0][0] = 0;
        expectedMatrix[0][1] = 0;
        expectedMatrix[0][2] = 3;
        expectedMatrix[1][0] = 0;
        expectedMatrix[1][1] = 0;
        expectedMatrix[1][2] = 0;
        expectedMatrix[2][0] = 0;
        expectedMatrix[2][1] = 0;
        expectedMatrix[2][2] = 0;

        int[][] actualMatrix = arrays.zeroMatrix(matrix);
        Assert.assertArrayEquals(expectedMatrix, actualMatrix);

    }

    @Test
    public void removeDuplicatesTest(){
        int[] nums = new int[]{1,1,2};
        int res = arrays.removeDuplicates(nums);

        Assert.assertEquals(2,res);
        Assert.assertEquals(1,nums[0]);
        Assert.assertEquals(2,nums[1]);

        nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        res = arrays.removeDuplicates(nums);
        Assert.assertEquals(0,nums[0]);
        Assert.assertEquals(1,nums[1]);
        Assert.assertEquals(2,nums[2]);
        Assert.assertEquals(3,nums[3]);
        Assert.assertEquals(4,nums[4]);

        Assert.assertEquals(5,res);

    }
}
