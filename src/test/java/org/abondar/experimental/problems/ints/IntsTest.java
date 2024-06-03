package org.abondar.experimental.problems.ints;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.abondar.experimental.TestUtil.verifyBooleanResult;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IntsTest {

    private final Ints ints = new Ints();

    @Test
    public void reverseIntegerTest() {
        int num = 123;
        int expected = 321;
        int actual = ints.reverseInteger(num);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("palindromeParams")
    public void isIntegerPalindromeTest(int input, boolean expected) {
        boolean actual = ints.isIntegerPalindrome(input);
        verifyBooleanResult(expected, actual);
    }

    private static Stream<Arguments> palindromeParams() {
        return Stream.of(
                Arguments.of(121,true),
                Arguments.of(-121,false),
                Arguments.of(10,false)
        );
    }

    @ParameterizedTest
    @MethodSource("romanToIntParams")
    public void romanToIntTest(String input, int expected) {
        int actual = ints.romanToInt(input);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> romanToIntParams() {
        return Stream.of(
                Arguments.of("III",3),
                Arguments.of("IV",4),
                Arguments.of("IX",9),
                Arguments.of("LVIII",58),
                Arguments.of("MCMXCIV",1994),
                Arguments.of("MCMGCIV",0)
        );
    }

    @ParameterizedTest
    @MethodSource("segmentParams")
    public void diskSegmentTest(int input,List<Integer> input1, int expected) {
        int res = ints.diskSegment(input,input1);
        assertEquals(expected, res);
    }

    private static Stream<Arguments> segmentParams() {
        return Stream.of(
                Arguments.of(2,List.of(3, 1, 1, 1),3),
                Arguments.of(2,List.of(8, 2, 4),8),
                Arguments.of(1,List.of(5, 1, 2, 3, 1, 2),5),
                Arguments.of(1,List.of(1, 1000000000),1000000000),
                Arguments.of(3,List.of(5, 2, 5, 4, 6, 8),4)
        );
    }

    @ParameterizedTest
    @MethodSource("multParams")
    public void multPersistenceTest(int input,int expected) {
        int actual = ints.multPersistence(input);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> multParams() {
        return Stream.of(
                Arguments.of(7,1),
                Arguments.of(2761,3),
                Arguments.of(99999999,2)
        );
    }

    @ParameterizedTest
    @MethodSource("sumParams")
    public void sumOfDivisorsTest(int input,int expected){
        int actual = ints.sumOfDivisors(input);
        assertEquals(expected,actual);
    }

    private static Stream<Arguments> sumParams() {
        return Stream.of(
                Arguments.of(1,1),
                Arguments.of(6,12),
                Arguments.of(12,28),
                Arguments.of(20,42)
        );
    }
}
