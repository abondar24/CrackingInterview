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

        System.out.println(isUnique);

        return isUnique;
    }

    ;
}
