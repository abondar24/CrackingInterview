package org.abondar.experimental.crackinginterview.dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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


    public List<List<Integer>> powerSet(List<Integer> set){
        List<List<Integer>> res = new ArrayList<>();

        // makes 2^n
        Integer maxSubs = 1 << set.size();
        for (int i=0;i<maxSubs;i++){
            List<Integer> subset = getSubset(i,set);
            res.add(subset);
        }

        return res;
    }

    public int recursiveMult(int a,int b){
        int bigger = a > b ? a : b;
        int smaller = a < b ? a : b;

        return multHelper(smaller,bigger);
    }

    private int multHelper(int smaller, int bigger) {
        if (smaller==0) return 0;
        else if (smaller ==1) return bigger;


        int s = smaller >> 1;

        int halfProd = multHelper(s,bigger);

        if (smaller % 2 ==0) return halfProd + halfProd;


        return halfProd + halfProd + bigger;
    }


    public Tower [] hanoiTowers(int numDisks){

        Tower[] towers = new Tower[3];
        for (int i=0;i<3;i++){
            towers[i] = new Tower(i);
        }

        for (int i=numDisks-1;i>=0;i--){
            towers[0].add(i);
        }

        towers[0].moveDisks(numDisks,towers[2],towers[1]);

        return towers;
    }


    public boolean paintFill(Color[][] screen, int r,int c, Color newColor){
        if (screen[r][c] == newColor ) return false;
        return  paintFill(screen,r,c,screen[r][c],newColor);
    }

    private boolean paintFill(Color[][] screen, int r, int c, Color oldColor, Color newColor) {
        if (r<0 || r>=screen.length || c<0 || c>= screen[0].length){
            return false;
        }

        if (screen[r][c] == oldColor) {
            screen[r][c] = newColor;

            paintFill(screen, r - 1, c, oldColor, newColor);
            paintFill(screen,r+1,c,oldColor,newColor);
            paintFill(screen,r,c-1,oldColor,newColor);
            paintFill(screen,r,c+1,oldColor,newColor);
        }
        return true;
    }


    private List<Integer> getSubset(int i, List<Integer> set) {
        List<Integer> subset = new ArrayList<>();
        int index =0;

        //div j by 2
        for (int j=i;j>0;j>>=1){
            // if elem is in set add it
            if ((j&1)==1){
                subset.add(set.get(index));
            }

            index++;
        }
        return subset;
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

        return magicIndex(a,rightIndex,end);
    }

    private int countWaysMemo(int n, int[] memo) {
        if (n<0) return 0;

        if (n==0) return 1;

        if (memo[n]>-1) return memo[n];

         memo[n] = countWaysMemo(n-1,memo) + countWaysMemo(n-2,memo) + countWaysMemo(n-3,memo);

         return memo[n];
    }
}
