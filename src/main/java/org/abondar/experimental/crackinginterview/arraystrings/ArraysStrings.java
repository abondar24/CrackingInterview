package org.abondar.experimental.crackinginterview.arraystrings;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class ArraysStrings {

    public boolean isUnique(String str) {
        boolean isUnique = false;

        char[] strc = str.toCharArray();
        Arrays.sort(strc);

        for (int i = 0; i < strc.length - 1; i++) {
            if (strc[i] != strc[i + 1]) {
                isUnique = true;
            } else {
                isUnique = false;
                break;
            }
        }

        return isUnique;
    }


    public boolean checkPermutation(String str1, String str2) {
        char[] strc1 = str1.toCharArray();
        char[] strc2 = str2.toCharArray();

        Arrays.sort(strc1);
        Arrays.sort(strc2);

        return Arrays.equals(strc1, strc2);
    }


    /*
     *
     * pureLen -  str at the end has spaces, pureLen size of str without them
     */
    public String urlify(String str, int pureLen) {

        char[] strc = str.toCharArray();
        char[] urlc = new char[strc.length];
        char[] symbols = {'%', '2', '0'};

        int nextChar = 0;
        for (int i = 0; i < pureLen; i++) {
            if (strc[i] == ' ') {
                for (int k = 0; k < symbols.length; k++) {
                    urlc[nextChar] = symbols[k];
                    nextChar++;
                }

            } else {
                urlc[nextChar] = strc[i];
                nextChar++;
            }
        }


        return String.valueOf(urlc);
    }


    public boolean palindromePermutation(String str) {
        boolean isPalindromePermutation;

        str = str.toLowerCase();

        char[] strc = str.toCharArray();

        int numberOfPairs = 0;
        if (str.length() % 2 == 0) {
            for (char c : strc) {
                if (str.indexOf(c) != str.lastIndexOf(c)) {
                    numberOfPairs++;
                }
            }
            isPalindromePermutation = numberOfPairs % 2 == 0;

        } else {
            for (char c : strc) {
                if (str.indexOf(c) == str.lastIndexOf(c)) {
                    numberOfPairs++;
                }
            }
            isPalindromePermutation = numberOfPairs == 1;

        }

        return isPalindromePermutation;
    }



    public boolean oneAway(String str1, String str2) {
        boolean oneEdit;

        char[] str1c = str1.toCharArray();
        char[] str2c = str2.toCharArray();

        Arrays.sort(str1c);
        Arrays.sort(str2c);


        if (Math.abs(str1c.length - str2c.length) > 1) {
            oneEdit = false;
        } else {
            if (str1c.length != str2c.length) {
                int minLen = Math.min(str1c.length, str1c.length);
                if (str1c.length == minLen) {
                    oneEdit = iterateOverMinStr(str1c, str2);
                } else {
                    oneEdit = iterateOverMinStr(str2c, str1);
                }

            } else {
                oneEdit = iterateOverMinStr(str1c, str2);
            }
        }


        return oneEdit;
    }

    private boolean iterateOverMinStr(char[] shortStr, String longStr) {


        int numberOfDiffs = 0;
        for (int i = 0; i < shortStr.length; i++) {
            if (longStr.indexOf(shortStr[i]) == -1) {
                numberOfDiffs++;
            }

        }

        return numberOfDiffs <= 1;
    }


    public String stringCompressor(String str) {
        StringBuilder compression = new StringBuilder();
        char[] strc = str.toCharArray();

        int numRepeats = 0;
        for (int i = 0; i < strc.length; i++) {
            numRepeats++;

            if (i + 1 >= strc.length || strc[i] != strc[i + 1]) {
                compression.append(strc[i]);
                compression.append(numRepeats);

                numRepeats = 0;
            }

        }

        return compression.toString();
    }


    public String reverseString(String str){

        char[] strArr = str.toCharArray();

        int half = strArr.length/2;

        int swpId;
        char buf;
        for (int i=0;i<half;i++){
            swpId = strArr.length - i - 1;
            buf = strArr[i];
            strArr[i] = strArr[swpId];
            strArr[swpId] = buf;

        }

        return new String(strArr);
    }

    public boolean isStringPalindrome(String str){
        String reverse = reverseString(str);

        return reverse.equals(str);
    }

    public int[] twoSum(int[] nums, int target){
        Map<Integer,Integer> valsMap = new HashMap<>();

        for (int i=0;i<nums.length;i++){
            valsMap.put(nums[i],i);
        }

        for (int i=0;i<nums.length;i++){
            int minusVal = target - nums[i];
            if (valsMap.containsKey(minusVal)){
                if(valsMap.get(minusVal) != i){
                    return new int[]{i, valsMap.get(minusVal)};
                }


            }

        }
        return new int[]{0,0};
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

        System.out.println(" ");
        printMatrix(matrix);
        return matrix;
    }


    public int[][] zeroMatrix(int[][] matrix) {
        printMatrix(matrix);

        HashMap<Integer,Integer> zeroPos = new HashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == 0) {
                    zeroPos.put(i,j);
                }
            }
        }

        for (int row:zeroPos.keySet()){
            matrix = fillZero(matrix,row,zeroPos.get(row));
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
}
