package org.abondar.experimental.problems.ints;

import org.abondar.experimental.problems.ints.Ints;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IntsTests {

    private final Ints ints = new Ints();

    @Test
    public void reverseIntegerTest() {
        int num = 123;
        int expected = 321;
        int actual = ints.reverseInteger(num);

        assertEquals(expected, actual);
    }

    @Test
    public void isIntegerPalindromeTest() {
        int num = 121;
        boolean res = ints.isIntegerPalindrome(num);
        assertTrue(res);

        num = -121;
        res = ints.isIntegerPalindrome(num);
        assertFalse(res);

        num = 10;
        res = ints.isIntegerPalindrome(num);
        assertFalse(res);

    }

    @Test
    public void romanToIntTest() {
        String roman = "III";
        int res = ints.romanToInt(roman);
        assertEquals(3, res);

        roman = "IV";
        res = ints.romanToInt(roman);
        assertEquals(4, res);

        roman = "IX";
        res = ints.romanToInt(roman);
        assertEquals(9, res);

        roman = "LVIII";
        res = ints.romanToInt(roman);
        assertEquals(58, res);

        roman = "MCMXCIV";
        res = ints.romanToInt(roman);
        assertEquals(1994, res);

        roman = "MCMGCIV";
        res = ints.romanToInt(roman);
        assertEquals(0, res);
    }

    @Test
    public void diskSegmentTest() {
        int seg = 2;
        List<Integer> space = Arrays.asList(3, 1, 1, 1);
        int res = ints.diskSegment(seg, space);
        assertEquals(3, res);

        seg = 2;
        space = Arrays.asList(8, 2, 4);
        res = ints.diskSegment(seg, space);
        assertEquals(8, res);

        seg = 1;
        space = Arrays.asList(5, 1, 2, 3, 1, 2);
        res = ints.diskSegment(seg, space);
        assertEquals(5, res);

        seg = 1;
        space = Arrays.asList(1, 1000000000);
        res = ints.diskSegment(seg, space);
        assertEquals(1000000000, res);

        seg = 3;
        space = Arrays.asList(5, 2, 5, 4, 6, 8);
        res = ints.diskSegment(seg, space);
        assertEquals(4, res);

    }

    @Test
    public void multPersistenceTest() {
        int num = 7;
        int res = ints.multPersistence(num);
        assertEquals(1, res);

        num = 2761;
        res = ints.multPersistence(num);
        assertEquals(3, res);

        num = 99999999;
        res = ints.multPersistence(num);
        assertEquals(2, res);
    }

    @Test
    public void sumOfDivisorsTest(){
        int res = ints.sumOfDivisors(1);
        assertEquals(1,res);

        res = ints.sumOfDivisors(6);
        assertEquals(12,res);

        res = ints.sumOfDivisors(12);
        assertEquals(28,res);

        res = ints.sumOfDivisors(20);
        assertEquals(42,res);
    }
}
