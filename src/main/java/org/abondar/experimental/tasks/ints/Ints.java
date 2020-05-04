package org.abondar.experimental.tasks.ints;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Ints {

    public int reverseInteger(int x) {
        long res=0;
        long xl = x;

        while (xl!=0){
            res = xl%10 + res*10;
            xl = xl/10;
        }

        return (res == (int)res) ? (int)res : 0;

    }

    public boolean isIntegerPalindrome(int x){
        if (x<0){
            return false;
        }

        int reverseX = reverseInteger(x);

        return reverseX==x;
    }

    public int romanToInt(String roman){
        Map<Character,Integer> romanToInt = new HashMap<>();
        romanToInt.put('I',1);
        romanToInt.put('V',5);
        romanToInt.put('X',10);
        romanToInt.put('L',50);
        romanToInt.put('C',100);
        romanToInt.put('D',500);
        romanToInt.put('M',1000);


        roman = roman.toUpperCase();

        char[] romanArr = roman.toCharArray();
        for (char c : romanArr) {
            if (!romanToInt.containsKey(c)) {
                return 0;
            }
        }

        int res=0;
        for (int i=0;i<romanArr.length;i++){
            int iVal = romanToInt.get(romanArr[i]);

            int i1Val=0;
            if (i!=romanArr.length-1){
                i1Val = romanToInt.get(romanArr[i+1]);
            }

            if (iVal>=i1Val){
                res += iVal;
            } else {
                res += (i1Val - iVal);
                i++;
            }
        }

        return res;
    }


}
