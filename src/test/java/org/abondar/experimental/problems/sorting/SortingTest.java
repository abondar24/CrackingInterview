package org.abondar.experimental.problems.sorting;

import org.abondar.experimental.structs.list.Listy;
import org.abondar.experimental.problems.sorting.MatrixElement;
import org.abondar.experimental.problems.sorting.SortingTasks;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortingTest {
    private final SortingTasks st = new SortingTasks();


    static Stream<Arguments> rankParams() {
        return Stream.of(
                Arguments.of(1, 0),
                Arguments.of(3, 1),
                Arguments.of(4, 3)
                );
    }

    @Test
    public void sortedMergeTest() {

        int[] A = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] B = {2, 3, 5, 12};

        int[] res = st.sortedMerge(A, B);

        for (int re : res) {
            System.out.println(re);
        }


        assertEquals(A.length + B.length, res.length);
        assertEquals(1, res[0]);
        assertEquals(12, res[12]);
    }

    @Test
    public void groupAnagramsTest() {
        String[] arr = {"race", "baba", "care", "abba"};

        List<String> rs = Arrays.asList(st.groupAnagrams(arr));

        assertEquals(1, Math.abs(rs.indexOf("race") - rs.indexOf("care")));
        assertEquals(1, Math.abs(rs.indexOf("baba") - rs.indexOf("abba")));
    }

    @Test
    public void rotatedSearchIndex() {
        int[] arr = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};

        int res = st.rotatedSearch(arr, 5);
        assertEquals(8, res);
    }

    @Test
    public void sortedSearchIndex() {
        int[] arr = {1, 3, 4, 5, 7, 10, 14};

        Listy list = new Listy(arr);
        int res = st.sortedSearch(list, 5);
        assertEquals(3, res);
    }

    @Test
    public void sparseSearchTest() {
        String[] arr = {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};

        int res = st.sparseSearch(arr, "ball");
        assertEquals(4, res);
    }

    @Test
    public void checkDupsTest() {
        int[] arr = {1, 2, 3, 4, 5, 6, 83, 4, 7, 132, 256, 10000, 28400, 14567, 7, 18, 24, 24, 100, 10, 55, 12};

        List<Integer> res = st.checkDups(arr);
        assertEquals(3, res.size());
    }

    @Test
    public void sortedMatrixSearchTest() {
        int[][] matrix = new int[4][4];

        matrix[0][0] = 15;
        matrix[0][1] = 20;
        matrix[0][2] = 40;
        matrix[0][3] = 85;
        matrix[1][0] = 20;
        matrix[1][1] = 35;
        matrix[1][2] = 80;
        matrix[1][3] = 95;
        matrix[2][0] = 30;
        matrix[2][1] = 55;
        matrix[2][2] = 95;
        matrix[2][3] = 105;
        matrix[3][0] = 40;
        matrix[3][1] = 80;
        matrix[3][2] = 100;
        matrix[3][3] = 120;

        MatrixElement me = st.sortedMatrixSearch(matrix, 55);
        assertEquals(2, me.getRow());
        assertEquals(1, me.getColumn());

    }

    @ParameterizedTest
    @MethodSource("rankParams")
    public void getRankOfNumTest(int num, int rank) {
        int[] arr = {5, 1, 4, 4, 5, 9, 7, 13, 3};

        for (int i : arr) {
            st.trackNum(i);
        }

        int res = st.getRankOfNum(num);

        assertEquals(rank, res);
    }

    @Test
    public void peaksValleysSort() {
        int[] arr = {5, 3, 1, 2, 3};
        int[] expected = {5, 1, 3, 2, 3};

        st.valleyPeakSort(arr);

        assertArrayEquals(expected, arr);
    }
}
