package org.abondar.experimental.tasks;

import org.abondar.experimental.tasks.strings.Strings;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class StringsTest {

    private final Strings strs = new Strings();

    @Test
    public void inUniqueTest() {

        boolean res = strs.isUnique("hello world");
        Assert.assertFalse(res);

        res = strs.isUnique("formula");
        Assert.assertTrue(res);

    }


    @Test
    public void checkPermutation() {
        boolean res = strs.checkPermutation("debug", "buged");
        Assert.assertTrue(res);

        res = strs.checkPermutation("debug", "cat");
        Assert.assertFalse(res);

        res = strs.checkPermutation("debug", "bug");
        Assert.assertFalse(res);
    }

    @Test
    public void urllifyTest() {
        String url = strs.urlify("Mr John Smith    ", 13);
        String expectedRes = "Mr%20John%20Smith";
        Assert.assertEquals(expectedRes, url);
    }


    @Test
    public void palindromePermutationTest() {
        boolean res = strs.palindromePermutation("Tact Coa");
        Assert.assertTrue(res);

        res = strs.palindromePermutation("Tact Coat");
        Assert.assertFalse(res);

        res = strs.palindromePermutation("aabcb");
        Assert.assertTrue(res);

        res = strs.palindromePermutation("civil");
        Assert.assertFalse(res);
    }


    @Test
    public void oneAwayTest() {
        boolean res = strs.oneAway("pale", "ple");
        Assert.assertTrue(res);

        res = strs.oneAway("pales", "pale");
        Assert.assertTrue(res);

        res = strs.oneAway("pale", "bale");
        Assert.assertTrue(res);

        res = strs.oneAway("pale", "bake");
        Assert.assertFalse(res);

        res = strs.oneAway("pale", "pale");
        Assert.assertTrue(res);

        res = strs.oneAway("paalee", "pale");
        Assert.assertFalse(res);

        res = strs.oneAway("pale", "pkb");
        Assert.assertFalse(res);
    }


    @Test
    public void stringCompressionTest() {
        String actual = strs.stringCompressor("aabcccccaaa");
        String expected = "a2b1c5a3";
        Assert.assertEquals(expected, actual);

        actual = strs.stringCompressor("abfcccgh");
        expected = "a1b1f1c3g1h1";
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void reverseStringTest() {
        String str = "abcde";
        String expected = "edcba";
        String actual = strs.reverseString(str);

        Assert.assertEquals(expected, actual);
    }


    @Test
    public void isStringPalindromeTest() {
        String str = "aabbaa";
        boolean res = strs.isStringPalindrome(str);
        Assert.assertTrue(res);

        str = "aacbaa";
        res = strs.isStringPalindrome(str);
        Assert.assertFalse(res);

        str = "A man, a plan, a canal: Panama";
        res = strs.isStringPalindrome(str);
        Assert.assertTrue(res);

        str = "race a car";
        res = strs.isStringPalindrome(str);
        Assert.assertFalse(res);
    }


    @Test
    public void longestCommonPrefixTest() {
        String[] arr = new String[]{"flower", "flow", "flight"};

        String res = strs.longestCommonPrefix(arr);
        Assert.assertEquals("fl", res);

        arr = new String[]{"dog", "racecar", "car"};
        res = strs.longestCommonPrefix(arr);

        Assert.assertEquals("", res);
    }

    @Test
    public void validParentheses() {
        String str = "()";
        boolean res = strs.validParentheses(str);
        Assert.assertTrue(res);

        str = "{[]}";
        res = strs.validParentheses(str);
        Assert.assertTrue(res);

        str = "(((((())))))";
        res = strs.validParentheses(str);
        Assert.assertTrue(res);

        str = "()()()()";
        res = strs.validParentheses(str);
        Assert.assertTrue(res);

        str = "()[]{}";
        res = strs.validParentheses(str);
        Assert.assertTrue(res);

        str = "((()(())))";
        res = strs.validParentheses(str);
        Assert.assertTrue(res);

        str = "{[]}";
        res = strs.validParentheses(str);
        Assert.assertTrue(res);

        str = "(((((((()";
        res = strs.validParentheses(str);
        Assert.assertFalse(res);

        str = "(]";
        res = strs.validParentheses(str);
        Assert.assertFalse(res);

        str = "([)]";
        res = strs.validParentheses(str);
        Assert.assertFalse(res);
    }

    @Test
    public void strStrTest() {
        Assert.assertEquals(2, strs.strStr("hello", "ll"));
        Assert.assertEquals(-1, strs.strStr("aaaaa", "bba"));
    }

    @Test
    public void strLenTest() {
        int res = strs.stringLen("10[]");
        Assert.assertEquals(0, res);

        res = strs.stringLen("a5[ab]bc");
        Assert.assertEquals(13, res);

        res = strs.stringLen("2[a]b3[c]");
        Assert.assertEquals(6, res);

        res = strs.stringLen("3[2[a]b3[c]]");
        Assert.assertEquals(18, res);
    }

    @Test
    public void strLen1Test() {
        int res = strs.stringLen1("10[]");
        Assert.assertEquals(0, res);

        res = strs.stringLen1("a5[ab]bc");
        Assert.assertEquals(13, res);

        res = strs.stringLen1("2[a]b3[c]");
        Assert.assertEquals(6, res);

        res = strs.stringLen1("3[2[a]b3[c]]");
        Assert.assertEquals(18, res);

    }

    @Test
    public void filterStringsTest() {
        List<String> incoming = List.of("abc", "", "a", " fdf ", "aaaa", "bb", "aaaa", "a");
        var res = strs.filterStrings(incoming);


        Assert.assertEquals(5, res.size());
        Assert.assertEquals("A", res.get(0));
        Assert.assertEquals("FDF", res.get(3));
    }


    @Test
    public void cardWarTest() {
        String a = "A586QK";
        String b = "JJ653K";

        int res = strs.cardWar(a, b);
        Assert.assertEquals(4, res);

        a = "23A84Q";
        b = "K2Q25J";

        res = strs.cardWar(a, b);
        Assert.assertEquals(4, res);
    }

    @Test
    public void stringChainTest() {
        List<String> strList = Arrays.asList("a", "b", "ba", "bca", "bda", "bdca");

        int res = strs.stringChains(strList);
        Assert.assertEquals(4, res);

    }

    @Test
    public void lengthOfLastWordTest() {
        String str = "Hello World";

        int res = strs.lengthOfLastWord(str);
        Assert.assertEquals(5, res);

        str = "Today was a nice day";
        res = strs.lengthOfLastWord(str);
        Assert.assertEquals(3, res);
    }

    @Test
    public void validPasswordTest() {
        String pwd = "passWord123!!!";
        boolean res = strs.validPassword(pwd);
        Assert.assertFalse(res);

        pwd = "admin123!!!";
        res = strs.validPassword(pwd);
        Assert.assertFalse(res);

        pwd = "Admin123";
        res = strs.validPassword(pwd);
        Assert.assertFalse(res);

        pwd = "Admin!!!";
        res = strs.validPassword(pwd);
        Assert.assertFalse(res);

        pwd = "Ad";
        res = strs.validPassword(pwd);
        Assert.assertFalse(res);

        pwd = "Admin123!!!dfsjfkdsflkdsflkdsfdsfdsfdsfdsfdsfdsf";
        res = strs.validPassword(pwd);
        Assert.assertFalse(res);

        pwd = "passworD3E+";
        res = strs.validPassword(pwd);
        Assert.assertFalse(res);

        pwd = "Admin123!!!";
        res = strs.validPassword(pwd);
        Assert.assertTrue(res);

        pwd = "Admin123!!!+";
        res = strs.validPassword(pwd);
        Assert.assertTrue(res);
    }

    @Test
    public void isAnagramTest(){
        String a = "anagram";
        String b = "margana";
        boolean res = strs.isAnagram(a,b);
        Assert.assertTrue(res);

        a = "Hello";
        b = "hello";
        res = strs.isAnagram(a,b);
        Assert.assertTrue(res);

        a = "anagram";
        b = "marganaa";
        res = strs.isAnagram(a,b);
        Assert.assertFalse(res);
    }

    @Test
    public void printTokensTest(){
        String str = "He is a very very good boy, isn't he?";

        List<String> res= strs.printTokens(str);
        System.out.println(res);
        res.forEach(System.out::println);
        Assert.assertEquals(10,res.size());

    }
}
