package org.abondar.experimental.problems.arrays;

import org.abondar.experimental.algorithms.SearchAlgs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Arrays {

    private final SearchAlgs su = new SearchAlgs();

    public int sum(int[] data){
        if (data.length==0){
            return 0;
        }

        return data[0]+sum(java.util.Arrays.copyOfRange(data,1,data.length));
    }


    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> valsMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            valsMap.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int minusVal = target - nums[i];
            if (valsMap.containsKey(minusVal)) {
                if (valsMap.get(minusVal) != i) {
                    return new int[]{i, valsMap.get(minusVal)};
                }


            }

        }
        return new int[]{0, 0};
    }

    public int len(int[] data){
        if (data.length==0){
            return 0;
        }

        return 1+len(java.util.Arrays.copyOfRange(data,1,data.length));
    }

    public int[][] rotateMatrix(int[][] matrix) {
        printMatrix(matrix);
        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = i; j < matrix.length - i - 1; j++) {
                //top to tmp
                int tmp = matrix[i][j];

                //left to top
                matrix[i][j] = matrix[matrix.length - 1 - j][i];

                // bottom to left
                matrix[matrix.length - 1 - j][i] = matrix[matrix.length - 1 - i][matrix.length - 1 - j];

                //right to bottom
                matrix[matrix.length - 1 - i][matrix.length - 1 - j] = matrix[j][matrix.length - 1 - i];


                //temp to right
                matrix[j][matrix.length - 1 - i] = tmp;
            }
        }

        printMatrix(matrix);
        return matrix;
    }


    public int[][] zeroMatrix(int[][] matrix) {
        printMatrix(matrix);

        HashMap<Integer, Integer> zeroPos = new HashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == 0) {
                    zeroPos.put(i, j);
                }
            }
        }

        for (int row : zeroPos.keySet()) {
            matrix = fillZero(matrix, row, zeroPos.get(row));
        }
        printMatrix(matrix);
        return matrix;
    }

    private int[][] fillZero(int[][] matrix, int row, int col) {
        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix.length; j++) {

                matrix[row][j] = 0;
                matrix[i][col] = 0;
            }
        }

        return matrix;
    }


    private void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


    public int calcUniqueLen(int[] nums) {
        int len = 0;

        if (nums.length > 0) {
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] != nums[len]) {
                    len++;
                    nums[len] = nums[i];
                }
            }
        }

        return len + 1;
    }

    public int[] cleanDuplicates(int[] nums) {

        Set<Integer> unique = new LinkedHashSet<>();
        for (int num : nums) {
            unique.add(num);
        }


        return toIntArray(unique);
    }

    public int removeElement(int[] nums, int val) {
        int len = 0;

        if (nums.length > 0) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != val) {
                    nums[len] = nums[i];
                    len++;

                }
            }
        }

        return len;
    }

    public int searchInsert(int[] nums, int target) {
        int res = su.sequentialSearchIndex(nums, target);
        if (res == -1) {
            res = findPos(nums, target);
        }
        return res;
    }

    private int findPos(int[] nums, int target) {
        if (target < nums[0]) {
            return 0;
        }

        if (target > nums[nums.length - 1]) {
            return nums.length;
        }

        for (int i = 0; i < nums.length; i++) {
            if (target > nums[i] && target < nums[i + 1]) {
                return i + 1;
            }
        }

        return 0;
    }

    public int fairIndex(int[] A, int[] B) {

        if (A.length != B.length) {
            return 0;
        }

        int length = A.length;

        int[] incSumA = new int[length + 1];
        int[] incSumB = new int[length + 1];

        for (int index = 1; index <= length; index++) {
            incSumA[index] = incSumA[index - 1] + A[index - 1];
            incSumB[index] = incSumB[index - 1] + B[index - 1];
        }
        int res = 0;
        for (int index = 1; index < length; index++) {
            // all possible indexes check if sum is same for all four sub arrays
            if (incSumA[index] == incSumB[index] &&
                    incSumA[index] == incSumA[length] - incSumA[index] &&
                    incSumB[index] == incSumB[length] - incSumB[index])
                res++;
        }
        return res;
    }

    public int[] duplicatesStat(int[] arr) {
        int requiredLen = 3;
        int[] noDup = cleanDuplicates(arr);
        int[] res = new int[requiredLen + noDup.length];

        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i : arr) {
            if (!countMap.containsKey(i)) {
                countMap.put(i, 1);
            } else {
                countMap.put(i, countMap.get(i) + 1);
            }
        }

        List<Integer> nonUnique = new ArrayList<>();

        countMap.forEach((k, v) -> {
            if (v > 1) {
                nonUnique.add(k);
            }
        });

        res[0] = nonUnique.size();

        res[1] = nonUnique.stream()
                .mapToInt(k -> k)
                .min()
                .getAsInt();

        res[2] = nonUnique.stream()
                .mapToInt(k -> k)
                .max()
                .getAsInt();

        int j = 3;
        for (int nd : noDup) {
            res[j] = nd;
            j++;
        }


        return res;
    }

    private int[] toIntArray(Collection<Integer> list) {
        int[] ret = new int[list.size()];
        int i = 0;
        for (Integer e : list)
            ret[i++] = e;
        return ret;
    }


    public int[] plusOne(int[] digits) {
        int last = digits.length - 1;
        if (digits[last] != 9) {
            digits[last] += 1;
        } else {
            int i = last;
            while (i > -1) {
                if (digits[i] + 1 == 10) {
                    digits[i] = 0;
                    i--;
                } else {
                    digits[i] += 1;
                    break;
                }
            }

            if (i == -1) {
                int[] newDigits = new int[digits.length + 1];
                newDigits[0] = 1;
                return newDigits;
            }
        }

        return digits;
    }

    public int singleNumber(int[] arr) {
        int res = 0;

        for (int a : arr) {
            res ^= a;
        }

        return res;
    }


    public int tvTime(List<TimeSlot> slots) {
        if (slots.size() == 0) {
            return 0;
        }
        Collections.sort(slots);

        var res = slots.get(0).getEnd() - slots.get(0).getStart();

        for (int i = 0; i < slots.size(); i++) {
            var diff = 0;
            if (i != slots.size() - 1) {
                var ts = slots.get(i);
                var next = slots.get(i + 1);

                if (next.getStart() < ts.getEnd() && ts.getEnd() < next.getEnd()) {
                    diff = next.getEnd() - ts.getEnd();
                } else if (next.getEnd()==ts.getEnd()){
                  continue;
                } else {
                    diff = next.getEnd() - next.getStart();
                }

                res += diff;
            }
        }
        return res;
    }
}
