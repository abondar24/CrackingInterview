package org.abondar.experimental.crackinginterview.sortingTasks;

import org.abondar.experimental.algorithms.SortingUtil;

import java.util.Arrays;
import java.util.List;

public class SortingTasks {

    private SortingUtil su = new SortingUtil();

    public int[] sortedMerge(int[] A, int[] B) {
        int[] res = new int[A.length + B.length];

        int lastIndexA = A.length - 1;
        int lastIndexB = B.length - 1;
        int lastIndexMerged = res.length - 1;

        while (lastIndexA >= 0) {
            // end of b > end of a
            if (lastIndexB >= 0 && B[lastIndexB] > A[lastIndexA]) {
                res[lastIndexMerged] = B[lastIndexB];
                lastIndexB--;
            } else {
                res[lastIndexMerged] = A[lastIndexA];
                lastIndexA--;
            }
            lastIndexMerged--;
        }

        return res;
    }

    public String[] groupAnagrams(String[] arr) {
        HashMapList<String, String> mapList = new HashMapList<>();

        //group words by anagram
        for (String s : arr) {
            String key = sortChars(s);
            mapList.put(key, s);
        }

        /*convert table to arr*/
        int index = 0;
        String[] res = new String[arr.length];

        for (String k : mapList.keySet()) {
            List<String> list = mapList.get(k);
            for (String t : list) {
                res[index] = t;
                index++;
            }
        }
        return res;
    }

    private String sortChars(String str) {
        char[] content = str.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }
}
