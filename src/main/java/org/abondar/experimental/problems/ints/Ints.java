package org.abondar.experimental.problems.ints;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ints {

    public int reverseInteger(int x) {
        long res = 0;
        long xl = x;

        while (xl != 0) {
            res = xl % 10 + res * 10;
            xl = xl / 10;
        }

        return (res == (int) res) ? (int) res : 0;

    }

    public boolean isIntegerPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int reverseX = reverseInteger(x);

        return reverseX == x;
    }

    public int romanToInt(String roman) {
        Map<Character, Integer> romanToInt = new HashMap<>();
        romanToInt.put('I', 1);
        romanToInt.put('V', 5);
        romanToInt.put('X', 10);
        romanToInt.put('L', 50);
        romanToInt.put('C', 100);
        romanToInt.put('D', 500);
        romanToInt.put('M', 1000);


        roman = roman.toUpperCase();

        char[] romanArr = roman.toCharArray();
        for (char c : romanArr) {
            if (!romanToInt.containsKey(c)) {
                return 0;
            }
        }

        int res = 0;
        for (int i = 0; i < romanArr.length; i++) {
            int iVal = romanToInt.get(romanArr[i]);

            int i1Val = 0;
            if (i != romanArr.length - 1) {
                i1Val = romanToInt.get(romanArr[i + 1]);
            }

            if (iVal >= i1Val) {
                res += iVal;
            } else {
                res += (i1Val - iVal);
                i++;
            }
        }

        return res;
    }

    public int diskSegment(int segLen, List<Integer> space) {
        List<List<Integer>> segmentSpaces = new ArrayList<>();

        if (space.size() <= segLen) {
            segmentSpaces.add(space);
        } else {
            for (int i = 0; i < space.size() - segLen + 1; i++) {
                List<Integer> segment = space.subList(i, i + segLen - 1);

                if (segLen == 1) {
                    segment = space.subList(i, i + segLen);
                }
                segmentSpaces.add(segment);
            }
        }

        List<Integer> minSpaces = new ArrayList<>();


        segmentSpaces.forEach(ss -> {
            int minSpace = ss.stream()
                    .mapToInt(s -> s)
                    .min()
                    .getAsInt();
            minSpaces.add(minSpace);
        });


        return minSpaces.stream()
                .mapToInt(s -> s)
                .max()
                .getAsInt();
    }

    public int multPersistence(int num) {
        if (numLen(num) == 1) {
            return 1;
        }

        return multPeristence(num, 0);
    }

    private int multPeristence(int num, int calls) {
        int[] digits = toDigits(num);
        int mult = 1;
        calls++;

        for (int d : digits) {
            mult *= d;
            if (mult == 0) {
                return calls;
            }
        }

        if (numLen(mult) != 1) {
            return multPeristence(mult, calls);
        } else {
            return calls;
        }

    }

    private int numLen(int num) {
        return (int) (Math.log10(num) + 1);
    }

    private int[] toDigits(int num) {

        int len = numLen(num);
        int div = (int) Math.pow(10, len - 1);
        int[] res = new int[len];

        for (int i = 0; i < len; i++) {
            res[i] = num / div;
            num = num % div;
            div = div / 10;

        }

        return res;
    }

    public int sumOfDivisors(int n){
        int res = 0;

        for (int i=1;i<=n;i++){
            if (n % i ==0){
                res = res +i;
            }
        }

        return res;
    }
}
