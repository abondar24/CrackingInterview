package org.abondar.experimental.problems.strings;


import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.abondar.experimental.TestUtil.verifyBooleanResult;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringsTest {

    private final Strings strings = new Strings();

    private static Stream<Arguments> uniqueParams() {
        return Stream.of(
                Arguments.of("hello world", false),
                Arguments.of("formula", true)
        );
    }

    private static Stream<Arguments> permutationParams() {
        return Stream.of(
                Arguments.of("debug", "buged", true),
                Arguments.of("debug", "car", false),
                Arguments.of("debug", "bug", false)
        );
    }

    private static Stream<Arguments> palindromePermParams() {
        return Stream.of(
                Arguments.of("Tact Coa", true),
                Arguments.of("Tact Coat", false),
                Arguments.of("aabcb", true),
                Arguments.of("civil", false)
        );
    }

    private static Stream<Arguments> oneAwayParams() {
        return Stream.of(
                Arguments.of("pale", "ple", true),
                Arguments.of("pales", "pale", true),
                Arguments.of("pale", "bale", true),
                Arguments.of("pale", "bake", false),
                Arguments.of("pale", "pale", true),
                Arguments.of("paalee", "pale", false),
                Arguments.of("pale", "pkb", false)
        );
    }

    private static Stream<Arguments> comparisonParams() {
        return Stream.of(
                Arguments.of("aabcccccaaa", "a2b1c5a3"),
                Arguments.of("abfcccgh", "a1b1f1c3g1h1")
        );
    }

    private static Stream<Arguments> palindromeParams() {
        return Stream.of(
                Arguments.of("aabbaa", true),
                Arguments.of("aacbaa", false),
                Arguments.of("A man, a plan, a canal: Panama", true),
                Arguments.of("race a car", false)
        );
    }

    private static Stream<Arguments> prefParams() {
        return Stream.of(
                Arguments.of(new String[]{"flower", "flow", "flight"}, "fl"),
                Arguments.of(new String[]{"dog", "racecar", "car"}, "")
        );
    }

    private static Stream<Arguments> parenthParams() {
        return Stream.of(
                Arguments.of("()", true),
                Arguments.of("{[]}", true),
                Arguments.of("(((((())))))", true),
                Arguments.of("()()()()", true),
                Arguments.of("()[]{}", true),
                Arguments.of("((()(())))", true),
                Arguments.of("(((((((()", false),
                Arguments.of("(]", false),
                Arguments.of("([)]", false)
        );
    }

    private static Stream<Arguments> strStrParams() {
        return Stream.of(
                Arguments.of("hello", "ll", 2),
                Arguments.of("aaaaa", "bba", -1)
        );
    }

    private static Stream<Arguments> strLenParams() {
        return Stream.of(
                Arguments.of("10[]", 0),
                Arguments.of("a5[ab]bc", 13),
                Arguments.of("2[a]b3[c]", 6),
                Arguments.of("3[2[a]b3[c]]", 18)
        );
    }

    private static Stream<Arguments> cardWarParams() {
        return Stream.of(
                Arguments.of("A586QK", "JJ653K", 4),
                Arguments.of("23A84Q", "K2Q25J", 4)
        );
    }

    private static Stream<Arguments> lenParams() {
        return Stream.of(
                Arguments.of("Hello World", 5),
                Arguments.of("Today was a nice day", 3)
        );
    }

    private static Stream<Arguments> pwdParams() {
        return Stream.of(
                Arguments.of("passWord123!!!", false),
                Arguments.of("admin123!!!", false),
                Arguments.of("Admin123", false),
                Arguments.of("Admin!!!", false),
                Arguments.of("Ad", false),
                Arguments.of("Admin123!!!dfsjfkdsflkdsflkdsfdsfdsfdsfdsfdsfdsf", false),
                Arguments.of("passworD3E+", false),
                Arguments.of("Admin123!!!", true),
                Arguments.of("Admin123!!!+", true)
        );
    }

    private static Stream<Arguments> usrParams() {
        return Stream.of(
                Arguments.of("Julia", false),
                Arguments.of("Samantha", true),
                Arguments.of("Samantha_21", true),
                Arguments.of("1Samantha", false),
                Arguments.of("Samantha?10_2A", false),
                Arguments.of("JuliaZ007", true),
                Arguments.of("Julia@007", false),
                Arguments.of("_Julia007", false)
        );
    }

    private static Stream<Arguments> anagramParams() {
        return Stream.of(
                Arguments.of("anagram", "margana", true),
                Arguments.of("Hello", "hello", true),
                Arguments.of("anagram", "marganaa", false)
        );
    }

    private static Stream<Arguments> timeParams() {
        return Stream.of(
                Arguments.of("07:05:45PM", "19:05:45"),
                Arguments.of("05:05:45PM", "17:05:45")
        );
    }

    private static Stream<Arguments> camelParams() {
        return Stream.of(
                Arguments.of("oneTwoThree", 3),
                Arguments.of("oneTwoThreeFour", 4),
                Arguments.of("OneTwo",0),
                Arguments.of("1 Two+three,",0),
                Arguments.of("saveChangesInTheEditor", 5)
        );
    }

    @ParameterizedTest
    @MethodSource("uniqueParams")
    public void isUniqueTest(String input, boolean expected) {
        boolean actual = strings.isUnique(input);
        verifyBooleanResult(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("permutationParams")
    public void checkPermutation(String input1, String input2, boolean expected) {
        boolean actual = strings.checkPermutation(input1, input2);
        verifyBooleanResult(expected, actual);
    }

    @Test
    public void urllifyTest() {
        String url = strings.urlify("Mr John Smith    ", 13);
        String expectedactual = "Mr%20John%20Smith";
        assertEquals(expectedactual, url);
    }

    @ParameterizedTest
    @MethodSource("palindromePermParams")
    public void palindromePermutationTest(String input, boolean expected) {
        boolean actual = strings.palindromePermutation(input);
        verifyBooleanResult(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("oneAwayParams")
    public void oneAwayTest(String input1, String input2, boolean expected) {
        boolean actual = strings.oneAway(input1, input2);
        verifyBooleanResult(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("comparisonParams")
    public void stringCompactualsionTest(String input, String expected) {
        String actual = strings.stringCompressor(input);
        assertEquals(expected, actual);
    }

    @Test
    public void reverseStringTest() {
        String str = "abcde";
        String expected = "edcba";
        String actual = strings.reverseString(str);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("palindromeParams")
    public void isStringPalindromeTest(String input, boolean expected) {
        boolean actual = strings.isStringPalindrome(input);
        verifyBooleanResult(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("prefParams")
    public void longestCommonPrefixTest(String[] input, String expected) {
        String actual = strings.longestCommonPrefix(input);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("parenthParams")
    public void validParentheses(String input, boolean expected) {
        boolean actual = strings.validParentheses(input);
        verifyBooleanResult(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("strStrParams")
    public void strStrTest(String input1, String input2, int expected) {
        var actual = strings.strStr(input1, input2);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("strLenParams")
    public void strLenTest(String input, int expected) {
        int actual = strings.stringLen(input);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("strLenParams")
    public void strLen1Test(String input, int expected) {
        int actual = strings.stringLen1(input);
        assertEquals(expected, actual);
    }

    @Test
    public void filterStringsTest() {
        List<String> incoming = List.of("abc", "", "a", " fdf ", "aaaa", "bb", "aaaa", "a");
        var actual = strings.filterStrings(incoming);

        assertEquals(5, actual.size());
        assertEquals("A", actual.get(0));
        assertEquals("FDF", actual.get(3));
    }

    @ParameterizedTest
    @MethodSource("cardWarParams")
    public void cardWarTest(String input1, String input2, int expected) {
        int actual = strings.cardWar(input1, input2);
        assertEquals(expected, actual);
    }

    @Test
    public void stringChainTest() {
        List<String> strList = Arrays.asList("a", "b", "ba", "bca", "bda", "bdca");

        int actual = strings.stringChains(strList);
        assertEquals(4, actual);
    }

    @ParameterizedTest
    @MethodSource("lenParams")
    public void lengthOfLastWordTest(String input, int expected) {
        int actual = strings.lengthOfLastWord(input);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("pwdParams")
    public void validPasswordTest(String input, boolean expected) {
        boolean actual = strings.validPassword(input);
        verifyBooleanResult(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("usrParams")
    public void validUsernameTest(String input, boolean expected) {
        boolean actual = strings.validUsername(input);
        verifyBooleanResult(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("anagramParams")
    public void isAnagramTest(String input1, String input2, boolean expected) {
        boolean actual = strings.isAnagram(input1, input2);
        verifyBooleanResult(expected, actual);
    }

    @Test
    public void printTokensTest() {
        String str = "He is a very very good boy, isn't he?";

        List<String> actual = strings.printTokens(str);
        assertEquals(10, actual.size());
    }

    @Test
    public void staircaseTest() {
        var actual = strings.staircase(4);
        System.out.println(actual);

        assertEquals(' ', actual.charAt(0));
        assertEquals(' ', actual.charAt(1));
        assertEquals(' ', actual.charAt(2));
        assertEquals('#', actual.charAt(3));
        assertEquals('\n', actual.charAt(4));

        assertEquals(' ', actual.charAt(5));
        assertEquals(' ', actual.charAt(6));
        assertEquals('#', actual.charAt(7));
        assertEquals('#', actual.charAt(8));
        assertEquals('\n', actual.charAt(9));

        assertEquals(' ', actual.charAt(10));
        assertEquals('#', actual.charAt(11));
        assertEquals('#', actual.charAt(12));
        assertEquals('#', actual.charAt(13));
        assertEquals('\n', actual.charAt(14));

        assertEquals('#', actual.charAt(15));
        assertEquals('#', actual.charAt(16));
        assertEquals('#', actual.charAt(17));
        assertEquals('#', actual.charAt(18));
        assertEquals('\n', actual.charAt(19));
    }


    @ParameterizedTest
    @MethodSource("timeParams")
    public void timeConversionTest(String time, String expected) {
        assertEquals(expected, strings.timeConversion(time));
    }

    @ParameterizedTest
    @MethodSource("camelParams")
    public void camelCaseTest(String line, int count){
       var res = strings.countWordsCamelCase(line);
       assertEquals(count, res);
    }


}
