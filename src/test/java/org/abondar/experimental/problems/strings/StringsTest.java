package org.abondar.experimental.problems.strings;


import org.abondar.experimental.TestUtil;
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
                Arguments.of("OneTwo", 0),
                Arguments.of("1 Two+three,", 0),
                Arguments.of("saveChangesInTheEditor", 5)
        );
    }

    private static Stream<Arguments> pwdLenParams() {
        return Stream.of(
                Arguments.of("2bbbb", 2),
                Arguments.of("2bb#A", 1),
                Arguments.of("Ab1", 3),
                Arguments.of("#HackerRank", 1)
        );
    }

    private static Stream<Arguments> cypherParams() {
        return Stream.of(
                Arguments.of("There's-a-starman-waiting-in-the-sky", 3, "Wkhuh'v-d-vwdupdq-zdlwlqj-lq-wkh-vnb"),
                Arguments.of("middle-Outz", 2, "okffng-Qwvb"),
                Arguments.of("www.abc.xy", 87, "fff.jkl.gh"),
                Arguments.of("159357lcfd", 98, "159357fwzx"),
                Arguments.of("!m-rB`-oN!.W`cLAcVbN/CqSoolII!SImji.!w/`Xu`uZa1TWPRq`uRBtok`xPT`lL-zPTc.BSRIhu..-!.!tcl!-U", 62,
                        "!w-bL`-yX!.G`mVKmFlX/MaCyyvSS!CSwts.!g/`He`eJk1DGZBa`eBLdyu`hZD`vV-jZDm.LCBSre..-!.!dmv!-E"),
                Arguments.of("Hello_World!", 4, "Lipps_Asvph!"),
                Arguments.of("DNFjxo?b5h*5<LWbgs6?V5{3M].1hG)pv1VWq4(!][DZ3G)riSJ.CmUj9]7Gzl?VyeJ2dIPEW4GYW*scT8(vhu9wCr]q!7eyaoy.", 45,
                       "WGYcqh?u5a*5<EPuzl6?O5{3F].1aZ)io1OPj4(!][WS3Z)kbLC.VfNc9]7Zse?OrxC2wBIXP4ZRP*lvM8(oan9pVk]j!7xrthr."),
                Arguments.of("6DWV95HzxTCHP85dvv3NY2crzt1aO8j6g2zSDvFUiJj6XWDlZvNNr", 87, "6MFE95QigCLQY85mee3WH2laic1jX8s6p2iBMeODrSs6GFMuIeWWa")

        );
    }

    private static Stream<Arguments> marsParams() {
        return Stream.of(
                Arguments.of("SOSSPSSQSSOR", 3),
                Arguments.of("SOSSOT", 1),
                Arguments.of("SOSSOSSOS", 0),
                Arguments.of("SOSTOT", 2),
                Arguments.of("SOSTO", 0)
                );
    }

    private static Stream<Arguments> hackParams() {
        return Stream.of(
                Arguments.of("haacckkerrannkk", true),
                Arguments.of("haacckkerannkk", false),
                Arguments.of("hccaakkerrannkk", false),
                Arguments.of("hereiamstackerrank",true),
                Arguments.of("hackerworld", false),
                Arguments.of("hhaacckkekraraannk", true),
                Arguments.of("rhbaasdndfsdskgbfefdbrsdfhuyatrjtcrtyytktjjt",false)
        );
    }

    private static Stream<Arguments> pangParams() {
        return Stream.of(
                Arguments.of("test",false),
                Arguments.of("The quick brown fox jumps over the lazy dog", true),
                Arguments.of("We promptly judged antique ivory buckles for the next prize", true),
                Arguments.of("We promptly judged antique ivory buckles for the prize", false)
        );
    }

    private static Stream<Arguments> reducedParams() {
        return Stream.of(
                Arguments.of("aab","b"),
                Arguments.of("abba", ""),
                Arguments.of("aaabccddd", "abd"),
                Arguments.of("aa", ""),
                Arguments.of("aaaa",""),
                Arguments.of("baab", ""),
                Arguments.of("aabcccccaaa","bca")
        );
    }

    private static Stream<Arguments> alternatingParams() {
        return Stream.of(
                Arguments.of("AAAA",3),
                Arguments.of("BBBBB", 4),
                Arguments.of("ABABABAB", 0),
                Arguments.of("BABABA", 0),
                Arguments.of("AAABBB", 4),
                Arguments.of("AAABBBAABB",6),
                Arguments.of("AABBAABB",4),
                Arguments.of("ABABABAA",1),
                Arguments.of("ABBABBAA",3)
        );
    }

    private static Stream<Arguments> twoStringsParams() {
        return Stream.of(
                Arguments.of("and","art",true),
                Arguments.of("be", "cat",false),
                Arguments.of("hello","world", true),
                Arguments.of("hi", "world",false),
                Arguments.of("wouldyoulikefries","abcabcabcabcabcabc", false),
                Arguments.of("hackerrankcommunity","cdecdecdecde",true),
                Arguments.of("jackandjill", "wentupthehill",true),
                Arguments.of("writetoyourparents","fghmqzldbc",false),
                Arguments.of("aardvark","apple",true),
                Arguments.of("beetroot","sandals",false)
        );
    }

    private static Stream<Arguments> binaryParams() {
        return Stream.of(
                Arguments.of("0",0),
                Arguments.of("111",0),
                Arguments.of("010",1),
                Arguments.of("0101010", 2),
                Arguments.of("01100", 0),
                Arguments.of("0100101010", 3)

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
    public void camelCaseTest(String line, int count) {
        var res = strings.countWordsCamelCase(line);
        assertEquals(count, res);
    }

    @ParameterizedTest
    @MethodSource("pwdLenParams")
    public void minNumber(String pwd, int count) {
        var res = strings.minNumber(pwd);
        assertEquals(count, res);
    }

    @ParameterizedTest
    @MethodSource("cypherParams")
    public void caesarsCypherTest(String str, int rotation, String cypher) {
        var res = strings.caesarCypher(str, rotation);
        assertEquals(cypher, res);
    }

    @ParameterizedTest
    @MethodSource("marsParams")
    public void marsExplorationTest(String msg, int diff) {
        var res = strings.marsExploration(msg);
        assertEquals(diff, res);
    }


    @ParameterizedTest
    @MethodSource("hackParams")
    public void isHackerRankTest(String str, boolean isHack) {
        var res = strings.isHackerRank(str);
        TestUtil.verifyBooleanResult(isHack,res);
    }

    @ParameterizedTest
    @MethodSource("pangParams")
    public void isPangramTest(String str, boolean isPangram) {
        var res = strings.isPangram(str);
        TestUtil.verifyBooleanResult(isPangram,res);
    }

    @ParameterizedTest
    @MethodSource("reducedParams")
    public void superReducedStringTest(String input, String expected) {
      var res = strings.superReducedString(input);
      assertEquals(expected, res);
    }

    @ParameterizedTest
    @MethodSource("alternatingParams")
    public void alternatingCharsTest(String input, int expected) {
        var res = strings.alternatingChars(input);
        assertEquals(expected, res);
    }

    @ParameterizedTest
    @MethodSource("twoStringsParams")
    public void twoStringsTest(String str1, String str2, boolean expected) {
        var res = strings.twoStrings(str1, str2);
        assertEquals(expected, res);
    }

    @ParameterizedTest
    @MethodSource("binaryParams")
    public void beautifulBinaryString(String input, int expected) {
        var res = strings.beautifulBinaryString(input);
        assertEquals(expected, res);
    }

}
