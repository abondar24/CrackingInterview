package org.abondar.experimental.crackinginterview.dynamic;

import java.util.Arrays;

public class DynaicUtil {

    public int countWays(int n){
        if (n<0) return 0;

        if (n==0) return 1;

        return countWays(n-1)+countWays(n-2)+countWays(n-3);
    }

    public int countWaysMemo(int n){
        int memo[] = new int[n+1];

        Arrays.fill(memo,-1);

        return countWaysMemo(n,memo);
    }

    public int magicIndex(int[] A){
        return  magicIndex(A,0,A.length -1);
    }

    private int magicIndex(int[] a, int start, int end) {
        if (end<start) return -1;

        int midIndex = (start+end)/2;
        int midValue = a[midIndex];
        if (midValue == midIndex){
            return midIndex;
        }


        int leftIndex = Math.min(midIndex -1,midValue);
        int left = magicIndex(a, start, leftIndex);
        if (left>=0){
            return left;
        }

        int rightIndex = Math.max(midIndex+1,midValue);
        int right = magicIndex(a,rightIndex,end);

        return right;
    }

    private int countWaysMemo(int n, int[] memo) {
        if (n<0) return 0;

        if (n==0) return 1;

        if (memo[n]>-1) return memo[n];

         memo[n] = countWaysMemo(n-1,memo) + countWaysMemo(n-2,memo) + countWaysMemo(n-3,memo);

         return memo[n];
    }
}
