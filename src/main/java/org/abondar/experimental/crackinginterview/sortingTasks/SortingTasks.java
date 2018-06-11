package org.abondar.experimental.crackinginterview.sortingTasks;

import org.abondar.experimental.algorithms.SearchUtil;
import org.abondar.experimental.algorithms.SortingUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortingTasks {

    private RankNode root = null;

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

    public int rotatedSearch(int[] arr, int elem) {

        return rotatedSearch(arr, 0, arr.length - 1, elem);
    }

    public int sortedSearch(Listy list, int elem) {
        int index = 1;
        while (list.elementAt(index) != -1 && list.elementAt(index) < elem) {
            index *= 2;
        }

        return bs(list, index / 2, index, elem);
    }

    private int bs(Listy list, int low, int high, int elem) {

        while (low < high) {
            int mid = (low + high) / 2;
            int middle = list.elementAt(mid);
            if (elem < middle || middle == -1) {
                high = mid - 1;
            } else if (elem > middle) {
                low = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    public int sparseSearch(String[] arr, String elem) {
        if (arr == null || elem == null || elem.isEmpty()) {
            return -1;
        }

        return sparseSearch(arr, 0, arr.length - 1, elem);
    }

    public List<Integer> checkDups(int[] arr) {
        List<Integer> res = new ArrayList<>();
        BitSet bs = new BitSet(32000);
        for (int num : arr) {
            //bit set start from 0
            int num0 = num - 1;
            if (bs.get(num0)) {
                System.out.println(num);
                res.add(num);
            } else {
                bs.set(num0);
            }
        }

        return res;
    }

    public MatrixElement sortedMatrixSearch(int[][] matrix, int elem) {
        MatrixElement res = new MatrixElement();

        int row = 0;
        int col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == elem) {
                res.setRow(row);
                res.setColumn(col);
                return res;
            } else if (matrix[row][col] > elem) {
                col--;
            } else {
                row++;
            }
        }

        return res;
    }

    public void trackNum(int num) {

        if (root == null) {
            root = new RankNode(num);
        } else {
            root.insert(num);
        }
    }

    public int getRankOfNum(int num) {
        return root.getRank(num);
    }

    public void valleyPeakSort(int[] array) {
        for (int i = 1; i < array.length; i += 2) {
            if (array[i - 1] < array[i]) {
                swap(array, i - 1, i);
            }
            if (i + 1 < array.length && array[i + 1] < array[i]) {
                swap(array, i + 1, i);
            }
        }
    }

    private void swap(int[] array,int left,int right){
        int tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }

    private int sparseSearch(String[] arr, int low, int high, String elem) {
        if (low > high) return -1;

        int mid = (low + high) / 2;

        //if mid empty closest non-empty
        if (arr[mid].isEmpty()) {
            int left = mid - 1;
            int right = mid + 1;

            while (true) {
                if (left < low && right > high) {
                    return -1;
                } else if (right <= high && !arr[right].isEmpty()) {
                    mid = right;
                    break;
                } else if (left >= low && !arr[left].isEmpty()) {
                    mid = left;
                    break;
                }
                right++;
                left--;
            }
        }

        //check str and recurse
        if (elem.equals(arr[mid])) {
            return mid;
        } else if (arr[mid].compareTo(elem) < 0) {
            //search right
            return sparseSearch(arr, mid + 1, high, elem);
        } else {
            //search left;
            return sparseSearch(arr, low, mid - 1, elem);
        }

    }

    private int rotatedSearch(int[] arr, int left, int right, int elem) {
        int mid = (left + right) / 2;
        if (elem == arr[mid]) return mid;

        if (right < left) return -1;

        if (arr[left] < arr[mid]) {
            if (elem >= arr[left] && elem < arr[mid]) {
                // rotatedSearch left
                return rotatedSearch(arr, left, mid - 1, elem);
            } else {
                // rotatedSearch right
                return rotatedSearch(arr, mid + 1, right, elem);
            }
        } else if (arr[mid] < arr[left]) {
            if (elem > arr[mid] && elem <= arr[right]) {
                return rotatedSearch(arr, mid + 1, right, elem);
            } else {
                return rotatedSearch(arr, left, mid - 1, elem);
            }
        } else if (arr[mid] == arr[left]) {
            if (arr[mid] != arr[right]) {
                return rotatedSearch(arr, mid + 1, right, elem);
            } else {
                int res = rotatedSearch(arr, left, mid - 1, elem);
                if (res == -1) {
                    return rotatedSearch(arr, mid + 1, right, elem);
                } else return elem;
            }
        }

        return -1;
    }

    private String sortChars(String str) {
        char[] content = str.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }
}
