package org.abondar.experimental.crackinginterview;

import java.util.Arrays;


public class ArraysStrings {

    /**
     * Determines if all the characters in string are unique
     */
    public boolean isUniqque(String str) {
        boolean isUnique = false;

        char [] strc = str.toCharArray();
        Arrays.sort(strc);

        for (int i = 0; i < strc.length-1; i++) {
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
    public boolean checkPermutation(String str1, String str2){
        char[] strc1 = str1.toCharArray();
        char[] strc2 = str2.toCharArray();

        Arrays.sort(strc1);
        Arrays.sort(strc2);

        return Arrays.equals(strc1,strc2);
    }



}
