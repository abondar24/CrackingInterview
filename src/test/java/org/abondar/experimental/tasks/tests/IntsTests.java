package org.abondar.experimental.tasks.tests;

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
}
