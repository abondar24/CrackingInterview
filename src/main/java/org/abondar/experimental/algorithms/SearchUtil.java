package org.abondar.experimental.algorithms;


import java.util.LinkedList;

public class SearchUtil {
    private static int  tableSize = 65136;
    public static boolean sequentialSearch(int[] data, int elem){
        for (int i:data){
            if (i == elem){
                return true;
            }
        }
        return false;
    }

    public static boolean binarySearch(int[] data, int elem){
       int low =0;
       int high = data.length -1;

       while (low<high){
           int mid = (low + high)/2;
           if (elem<data[mid]){
               high = mid - 1;
           } else if (elem>data[mid]){
               low = mid + 1;
           } else {
               return true;
           }
       }

       return false;
    }


    public static boolean hashSearch(int[] data, int elem) {
        int h = hash(elem);

        LinkedList[] table = loadHashTable(data);
        LinkedList<Integer> list = (LinkedList<Integer>) table[h];
        return list != null && list.contains(elem);

    }


    private static LinkedList<Integer>[] loadHashTable(int[] data){
        LinkedList<Integer>[] table = (LinkedList<Integer>[]) new LinkedList[tableSize];

        for (int i:data){

            int h = hash(i);
            if (table[h] == null){
                table[h] = new LinkedList<>();
            }
            table[h].add(i);
        }
       return table;
    }

    private  static int hash(int i){
        int h = Integer.valueOf(i).hashCode();
        if (h<0) {
            h = 0 -h;
        }

        return h % tableSize;
    }

}
