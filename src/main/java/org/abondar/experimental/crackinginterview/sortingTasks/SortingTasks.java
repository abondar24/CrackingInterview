package org.abondar.experimental.crackinginterview.sortingTasks;

import org.abondar.experimental.algorithms.SearchUtil;
import org.abondar.experimental.algorithms.SortingUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortingTasks {

    private SortingUtil su = new SortingUtil();
    private SearchUtil se = new SearchUtil();

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

    public int rotatedSearch(int[] arr,int elem){

        return search(arr,0,arr.length-1,elem);
    }

    public int sortedSearch(Listy list,int elem){
        int index =1;
        while (list.elementAt(index)!=-1 && list.elementAt(index)< elem){
            index *=2;
        }

        return bs(list,index/2,index,elem);
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

    private int search(int[] arr, int left, int right, int elem) {
       int mid = (left + right)/2;
       if (elem==arr[mid]) return mid;

       if (right<left) return -1;

       if (arr[left]<arr[mid]){
           if (elem>=arr[left] && elem<arr[mid]){
               // search left
               return search(arr,left,mid-1,elem);
           } else {
               // search right
               return search(arr,mid+1,right,elem);
           }
       } else if (arr[mid] < arr[left]){
           if (elem>arr[mid] && elem<=arr[right]){
               return search(arr,mid+1,right,elem);
           } else {
               return search(arr,left,mid-1,elem);
           }
       } else if(arr[mid]==arr[left]){
            if (arr[mid]!=arr[right]){
                return search(arr,mid+1,right,elem);
            } else {
                int res = search(arr,left,mid-1,elem);
                if (res==-1){
                    return search(arr,mid+1,right,elem);
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
