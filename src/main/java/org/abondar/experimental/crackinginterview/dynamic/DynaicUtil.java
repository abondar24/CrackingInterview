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

    private int countWaysMemo(int n, int[] memo) {
        if (n<0) return 0;

        if (n==0) return 1;

        if (memo[n]>-1) return memo[n];

         memo[n] = countWaysMemo(n-1,memo) + countWaysMemo(n-2,memo) + countWaysMemo(n-3,memo);

         return memo[n];
    }
}
