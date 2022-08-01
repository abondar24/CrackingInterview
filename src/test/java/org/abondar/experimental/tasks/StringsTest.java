package org.abondar.experimental.tasks;

import org.abondar.experimental.tasks.strings.Strings;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringsTest {

    private final Strings strs = new Strings();

    @Test
    public void inUniqueTest() {

        boolean res = strs.isUnique("hello world");
        assertFalse(res);

        res = strs.isUnique("formula");
        assertTrue(res);

    }


    @Test
    public void checkPermutation() {
        boolean res = strs.checkPermutation("debug", "buged");
        assertTrue(res);

        res = strs.checkPermutation("debug", "cat");
        assertFalse(res);

        res = strs.checkPermutation("debug", "bug");
        assertFalse(res);
    }

    @Test
    public void urllifyTest() {
        String url = strs.urlify("Mr John Smith    ", 13);
        String expectedRes = "Mr%20John%20Smith";
        assertEquals(expectedRes, url);
    }


    @Test
    public void palindromePermutationTest() {
        boolean res = strs.palindromePermutation("Tact Coa");
        assertTrue(res);

        res = strs.palindromePermutation("Tact Coat");
        assertFalse(res);

        res = strs.palindromePermutation("aabcb");
        assertTrue(res);

        res = strs.palindromePermutation("civil");
        assertFalse(res);
    }


    @Test
    public void oneAwayTest() {
        boolean res = strs.oneAway("pale", "ple");
        assertTrue(res);

        res = strs.oneAway("pales", "pale");
        assertTrue(res);

        res = strs.oneAway("pale", "bale");
        assertTrue(res);

        res = strs.oneAway("pale", "bake");
        assertFalse(res);

        res = strs.oneAway("pale", "pale");
        assertTrue(res);

        res = strs.oneAway("paalee", "pale");
        assertFalse(res);

        res = strs.oneAway("pale", "pkb");
        assertFalse(res);
    }


    @Test
    public void stringCompressionTest() {
        String actual = strs.stringCompressor("aabcccccaaa");
        String expected = "a2b1c5a3";
        assertEquals(expected, actual);

        actual = strs.stringCompressor("abfcccgh");
        expected = "a1b1f1c3g1h1";
        assertEquals(expected, actual);

    }

    @Test
    public void reverseStringTest() {
        String str = "abcde";
        String expected = "edcba";
        String actual = strs.reverseString(str);

        assertEquals(expected, actual);
    }


    @Test
    public void isStringPalindromeTest() {
        String str = "aabbaa";
        boolean res = strs.isStringPalindrome(str);
        assertTrue(res);

        str = "aacbaa";
        res = strs.isStringPalindrome(str);
        assertFalse(res);

        str = "A man, a plan, a canal: Panama";
        res = strs.isStringPalindrome(str);
        assertTrue(res);

        str = "race a car";
        res = strs.isStringPalindrome(str);
        assertFalse(res);
    }


    @Test
    public void longestCommonPrefixTest() {
        String[] arr = new String[]{"flower", "flow", "flight"};

        String res = strs.longestCommonPrefix(arr);
        assertEquals("fl", res);

        arr = new String[]{"dog", "racecar", "car"};
        res = strs.longestCommonPrefix(arr);

        assertEquals("", res);
    }

    @Test
    public void validParentheses() {
        String str = "()";
        boolean res = strs.validParentheses(str);
        assertTrue(res);

        str = "{[]}";
        res = strs.validParentheses(str);
        assertTrue(res);

        str = "(((((())))))";
        res = strs.validParentheses(str);
        assertTrue(res);

        str = "()()()()";
        res = strs.validParentheses(str);
        assertTrue(res);

        str = "()[]{}";
        res = strs.validParentheses(str);
        assertTrue(res);

        str = "((()(())))";
        res = strs.validParentheses(str);
        assertTrue(res);

        str = "{[]}";
        res = strs.validParentheses(str);
        assertTrue(res);

        str = "(((((((()";
        res = strs.validParentheses(str);
        assertFalse(res);

        str = "(]";
        res = strs.validParentheses(str);
        assertFalse(res);

        str = "([)]";
        res = strs.validParentheses(str);
        assertFalse(res);
    }

    @Test
    public void strStrTest() {
        assertEquals(2, strs.strStr("hello", "ll"));
        assertEquals(-1, strs.strStr("aaaaa", "bba"));
    }

    @Test
    public void strLenTest() {
        int res = strs.stringLen("10[]");
        assertEquals(0, res);

        res = strs.stringLen("a5[ab]bc");
        assertEquals(13, res);

        res = strs.stringLen("2[a]b3[c]");
        assertEquals(6, res);

        res = strs.stringLen("3[2[a]b3[c]]");
        assertEquals(18, res);
    }

    @Test
    public void strLen1Test() {
        int res = strs.stringLen1("10[]");
        assertEquals(0, res);

        res = strs.stringLen1("a5[ab]bc");
        assertEquals(13, res);

        res = strs.stringLen1("2[a]b3[c]");
        assertEquals(6, res);

        res = strs.stringLen1("3[2[a]b3[c]]");
        assertEquals(18, res);

    }

    @Test
    public void filterStringsTest() {
        List<String> incoming = List.of("abc", "", "a", " fdf ", "aaaa", "bb", "aaaa", "a");
        var res = strs.filterStrings(incoming);


        assertEquals(5, res.size());
        assertEquals("A", res.get(0));
        assertEquals("FDF", res.get(3));
    }


    @Test
    public void cardWarTest() {
        String a = "A586QK";
        String b = "JJ653K";

        int res = strs.cardWar(a, b);
        assertEquals(4, res);

        a = "23A84Q";
        b = "K2Q25J";

        res = strs.cardWar(a, b);
        assertEquals(4, res);
    }

    @Test
    public void stringChainTest() {
        List<String> strList = Arrays.asList("a", "b", "ba", "bca", "bda", "bdca");

        int res = strs.stringChains(strList);
        assertEquals(4, res);

    }

    @Test
    public void lengthOfLastWordTest() {
        String str = "Hello World";

        int res = strs.lengthOfLastWord(str);
        assertEquals(5, res);

        str = "Today was a nice day";
        res = strs.lengthOfLastWord(str);
        assertEquals(3, res);
    }

    @Test
    public void validPasswordTest() {
        String pwd = "passWord123!!!";
        boolean res = strs.validPassword(pwd);
        assertFalse(res);

        pwd = "admin123!!!";
        res = strs.validPassword(pwd);
        assertFalse(res);

        pwd = "Admin123";
        res = strs.validPassword(pwd);
        assertFalse(res);

        pwd = "Admin!!!";
        res = strs.validPassword(pwd);
        assertFalse(res);

        pwd = "Ad";
        res = strs.validPassword(pwd);
        assertFalse(res);

        pwd = "Admin123!!!dfsjfkdsflkdsflkdsfdsfdsfdsfdsfdsfdsf";
        res = strs.validPassword(pwd);
        assertFalse(res);

        pwd = "passworD3E+";
        res = strs.validPassword(pwd);
        assertFalse(res);

        pwd = "Admin123!!!";
        res = strs.validPassword(pwd);
        assertTrue(res);

        pwd = "Admin123!!!+";
        res = strs.validPassword(pwd);
        assertTrue(res);
    }

    @Test
    public void validUsernameTest(){
        String username = "Julia";
        boolean res = strs.validUsername(username);
        assertFalse(res);

        username = "Samantha";
        res = strs.validUsername(username);
        assertTrue(res);

        username = "Samantha_21";
        res = strs.validUsername(username);
        assertTrue(res);

        username = "1Samantha";
        res = strs.validUsername(username);
        assertFalse(res);

        username = "Samantha?10_2A";
        res = strs.validUsername(username);
        assertFalse(res);

        username = "JuliaZ007";
        res = strs.validUsername(username);
        assertTrue(res);

        username = "Julia@007";
        res = strs.validUsername(username);
        assertFalse(res);

        username = "_Julia007";
        res = strs.validUsername(username);
        assertFalse(res);
    }

    @Test
    public void isAnagramTest(){
        String a = "anagram";
        String b = "margana";
        boolean res = strs.isAnagram(a,b);
        assertTrue(res);

        a = "Hello";
        b = "hello";
        res = strs.isAnagram(a,b);
        assertTrue(res);

        a = "anagram";
        b = "marganaa";
        res = strs.isAnagram(a,b);
        assertFalse(res);
    }

    @Test
    public void printTokensTest(){
        String str = "He is a very very good boy, isn't he?";

        List<String> res= strs.printTokens(str);
        assertEquals(10,res.size());

    }
}
