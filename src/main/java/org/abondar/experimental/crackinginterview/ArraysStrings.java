package org.abondar.experimental.crackinginterview;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ArraysStrings {

    /**
     * Determines if all the characters in string are unique
     */
    public boolean isUniqque(String str) {
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


    /**
     * Check if str2 is permutation of str1
     */
    public boolean checkPermutation(String str1, String str2) {
        char[] strc1 = str1.toCharArray();
        char[] strc2 = str2.toCharArray();

        Arrays.sort(strc1);
        Arrays.sort(strc2);

        return Arrays.equals(strc1, strc2);
    }


    /**
     * Replace spaces with %20 except spaces at the end
     * replace within char array
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


    /**
     * Checks if any of words permutations can be a palindrome
     */
    public boolean palindromePermutation(String str) {
        boolean isPalindromePermutation;

        str = str.toLowerCase();

        char[] strc = str.toCharArray();

        if (str.length() % 2 == 0) {
            int numberOfPairs = 0;
            for (char c : strc) {
                if (str.indexOf(c) != str.lastIndexOf(c)) {
                    numberOfPairs++;
                }
            }
            isPalindromePermutation = numberOfPairs % 2 == 0;

        } else {
            int numberOfUnique = 0;
            for (char c : strc) {
                if (str.indexOf(c) == str.lastIndexOf(c)) {
                    numberOfUnique++;
                }
            }
            isPalindromePermutation = numberOfUnique == 1;

        }

        return isPalindromePermutation;
    }


    /**
     * Check of oneString can be got from another by just one edit
     */
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
                oneEdit = iterateOverMinStr(str1c,str2);
            }
        }


        return oneEdit;
    }

    private boolean iterateOverMinStr(char[] shortStr, String longStr) {


        int numberOfDiffs =0;
        for (int i=0;i<shortStr.length;i++){
            if (longStr.indexOf(shortStr[i])==-1){
                numberOfDiffs++;
            }

        }

        return numberOfDiffs <= 1;
    }
}
