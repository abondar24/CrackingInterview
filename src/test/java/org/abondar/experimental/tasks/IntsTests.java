package org.abondar.experimental.tasks;

import org.abondar.experimental.tasks.ints.Ints;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class IntsTests {

    private Ints ints = new Ints();

    @Test
    public void reverseIntegerTest(){
        int num = 123;
        int expected = 321;
        int actual= ints.reverseInteger(num);

        assertEquals(expected,actual);
    }

    @Test
    public void isIntegerPalindromeTest(){
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
    public void romanToIntTest(){
        String roman = "III";
        int res =  ints.romanToInt(roman);
        assertEquals(3,res);

        roman = "IV";
        res =  ints.romanToInt(roman);
        assertEquals(4,res);

        roman = "IX";
        res =  ints.romanToInt(roman);
        assertEquals(9,res);

        roman = "LVIII";
        res =  ints.romanToInt(roman);
        assertEquals(58,res);

        roman = "MCMXCIV";
        res =  ints.romanToInt(roman);
        assertEquals(1994,res);

        roman = "MCMGCIV";
        res =  ints.romanToInt(roman);
        assertEquals(0,res);
    }
}
