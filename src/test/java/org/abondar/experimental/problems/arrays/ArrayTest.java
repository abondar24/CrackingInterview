package org.abondar.experimental.problems.arrays;

import org.abondar.experimental.problems.arrays.Arrays;
import org.abondar.experimental.problems.arrays.TimeSlot;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayTest {

    private final Arrays arrayTasks = new Arrays();


    @Test
    public void sumTest(){
        int[] arr = {2, 7, 10, 11};
        int res = arrayTasks.sum(arr);
        int expected = 30;

       assertEquals(expected, res);
    }

    @Test
    public void twoSumTest() {
        int[] arr = {2, 7, 11, 15};
        int target = 9;
        int[] expected = {0, 1};

        int[] actual = arrayTasks.twoSum(arr, target);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void lenTest(){
        int[] arr = {2, 7, 10, 11};
        int res = arrayTasks.len(arr);

        assertEquals(arr.length, res);
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

        int[][] actualMatrix = arrayTasks.rotateMatrix(matrix);
        assertArrayEquals(expectedMatrix, actualMatrix);

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

        int[][] actualMatrix = arrayTasks.rotateMatrix(matrix);
        assertArrayEquals(expectedMatrix, actualMatrix);

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

        int[][] actualMatrix = arrayTasks.zeroMatrix(matrix);
        assertArrayEquals(expectedMatrix, actualMatrix);

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

        int[][] actualMatrix = arrayTasks.zeroMatrix(matrix);
        assertArrayEquals(expectedMatrix, actualMatrix);

    }

    @Test
    public void calcUniqueLenTest() {
        int[] nums = new int[]{1, 1, 2};
        int res = arrayTasks.calcUniqueLen(nums);

        assertEquals(2, res);
        assertEquals(1, nums[0]);
        assertEquals(2, nums[1]);

        nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        res = arrayTasks.calcUniqueLen(nums);
        assertEquals(0, nums[0]);
        assertEquals(1, nums[1]);
        assertEquals(2, nums[2]);
        assertEquals(3, nums[3]);
        assertEquals(4, nums[4]);

        assertEquals(5, res);

    }

    @Test
    public void cleanDuplicatesTest() {
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int[] res = arrayTasks.cleanDuplicates(nums);

        assertEquals(5, res.length);
        assertEquals(0, res[0]);
        assertEquals(1, res[1]);
        assertEquals(2, res[2]);
        assertEquals(3, res[3]);
        assertEquals(4, res[4]);

        nums = new int[]{5, 2, 5, 5, 6, 6, 10};
        res = arrayTasks.cleanDuplicates(nums);

        assertEquals(4, res.length);
        assertEquals(5, res[0]);
        assertEquals(2, res[1]);
        assertEquals(6, res[2]);
        assertEquals(10, res[3]);

    }

    @Test
    public void removeValueTest() {
        int[] nums = new int[]{3, 2, 2, 3};
        int res = arrayTasks.removeElement(nums, 3);

        assertEquals(2, res);
        assertEquals(2, nums[0]);
        assertEquals(2, nums[1]);

        nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        res = arrayTasks.removeElement(nums, 2);

        assertEquals(5, res);
        assertEquals(0, nums[0]);
        assertEquals(1, nums[1]);
        assertEquals(3, nums[2]);
        assertEquals(0, nums[3]);
        assertEquals(4, nums[4]);

    }

    @Test
    public void searchInsertTest() {
        int[] nums = new int[]{1, 3, 5, 6};
        int res = arrayTasks.searchInsert(nums, 5);
        assertEquals(2, res);

        res = arrayTasks.searchInsert(nums, 2);
        assertEquals(1, res);

        res = arrayTasks.searchInsert(nums, 7);
        assertEquals(4, res);

        res = arrayTasks.searchInsert(nums, 0);
        assertEquals(0, res);

        nums = new int[]{1, 3};
        res = arrayTasks.searchInsert(nums, 3);
        assertEquals(1, res);

        nums = new int[]{1, 3};
        res = arrayTasks.searchInsert(nums, 1);
        assertEquals(0, res);

        nums = new int[]{1, 2, 3, 4, 5, 10};
        res = arrayTasks.searchInsert(nums, 2);
        assertEquals(1, res);

        nums = new int[]{3, 4, 8, 9, 10};
        res = arrayTasks.searchInsert(nums, 8);
        assertEquals(2, res);
    }

    @Test
    public void fairIndexTest() {
        int[] a = new int[]{4, -1, 0, 3};
        int[] b = new int[]{-2, 5, 0, 3};
        int res = arrayTasks.fairIndex(a, b);
        assertEquals(2, res);

        a = new int[]{2, -2, -3, 3};
        b = new int[]{0, 0, 4, -4};
        res = arrayTasks.fairIndex(a, b);
        assertEquals(1, res);

        a = new int[]{4, -1, 0, 3};
        b = new int[]{-2, 6, 0, 4};
        res = arrayTasks.fairIndex(a, b);
        assertEquals(0, res);

        a = new int[]{3, 2, 6};
        b = new int[]{4, 1, 6};
        res = arrayTasks.fairIndex(a, b);
        assertEquals(0, res);

        a = new int[]{1, 4, 2, -2, 5};
        b = new int[]{7, -2, -2, 2, 5};
        res = arrayTasks.fairIndex(a, b);
        assertEquals(2, res);
    }

    @Test
    public void duplicatesStatTest() {
        int[] arr = new int[]{5, 2, 5, 6, 6, 10};
        int[] res = arrayTasks.duplicatesStat(arr);

        assertEquals(7, res.length);
        assertEquals(2, res[0]);
        assertEquals(5, res[1]);
        assertEquals(6, res[2]);
        assertEquals(5, res[3]);
        assertEquals(2, res[4]);
        assertEquals(6, res[5]);
        assertEquals(10, res[6]);


    }

    @Test
    public void plusOneTest() {
        int[] digits = new int[]{1, 2, 3};
        int[] res = arrayTasks.plusOne(digits);

        assertEquals(4, res[2]);


        digits = new int[]{1, 2, 9};
        res = arrayTasks.plusOne(digits);

        assertEquals(3, res[1]);
        assertEquals(0, res[2]);

        digits = new int[]{1, 9, 9};
        res = arrayTasks.plusOne(digits);

        assertEquals(2, res[0]);
        assertEquals(0, res[1]);
        assertEquals(0, res[2]);

        digits = new int[]{9, 9, 9};
        res = arrayTasks.plusOne(digits);

        assertEquals(4, res.length);
        assertEquals(1, res[0]);
        assertEquals(0, res[1]);
        assertEquals(0, res[2]);
        assertEquals(0, res[3]);
    }

    @Test
    public void singleNumberseTest() {
        int[] arr = new int[]{2, 2, 1};
        int res = arrayTasks.singleNumber(arr);

        assertEquals(1, res);

        arr = new int[]{4, 1, 2, 1, 2};
        res = arrayTasks.singleNumber(arr);

        assertEquals(4, res);
    }

    @Test
    public void tvTimeTest(){
        List<TimeSlot> data = new ArrayList<>();
        data.add(new TimeSlot(1,4));
        data.add(new TimeSlot(2,6));
        var res = arrayTasks.tvTime(data);
        assertEquals(5,res);


        data = new ArrayList<>();
        data.add(new TimeSlot(4,6));
        data.add(new TimeSlot(1,2));
        res = arrayTasks.tvTime(data);
        assertEquals(3,res);

        data = new ArrayList<>();
        data.add(new TimeSlot(4,6));
        data.add(new TimeSlot(1,2));
        data.add(new TimeSlot(1,2));
        res = arrayTasks.tvTime(data);
        assertEquals(3,res);

        data = new ArrayList<>();
        data.add(new TimeSlot(1,4));
        data.add(new TimeSlot(6,8));
        data.add(new TimeSlot(2,4));
        data.add(new TimeSlot(7,9));
        data.add(new TimeSlot(10,15));
        res = arrayTasks.tvTime(data);
        assertEquals(11,res);

        data = new ArrayList<>();
        data.add(new TimeSlot(1,4));
        data.add(new TimeSlot(6,8));
        data.add(new TimeSlot(2,4));
        data.add(new TimeSlot(7,12));
        data.add(new TimeSlot(10,15));
        res = arrayTasks.tvTime(data);
        assertEquals(12,res);
    }
}
