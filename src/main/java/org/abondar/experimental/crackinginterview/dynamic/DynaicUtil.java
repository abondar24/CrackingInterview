package org.abondar.experimental.crackinginterview.dynamic;

import org.abondar.experimental.crackinginterview.arraystrings.ArraysStrings;

import java.util.*;

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

    public List<String> maxPermutationsNoDups(String str){
        ArraysStrings as = new ArraysStrings();
        if (!str.isEmpty() && !as.isUnique(str)) throw  new RuntimeException("Chars are not unique");


        int len = str.length();
        List<String> res = new ArrayList<>();
        if (len==0){
            res.add("");
            return res;
        }

        for (int i=0;i<len;i++){
            // find all perms without char i
            String before = str.substring(0,i);
            String after = str.substring(i+1,len);
            List<String> partials = getPerms(before+after);

            //prepend i to permutation
            for (String s: partials){
                res.add(str.charAt(i)+s);
            }
        }

        return res;
    }

    public List<String> maxPermutationsDups(String str){
        List<String> res = new ArrayList<>();
        Map<Character,Integer> freqs = buildFreqsMap(str);
        getPerms(freqs,"",str.length(),res);

        return res;
     }


    public List<String> parentheses(int pairs){
        List<String> res = new ArrayList<>();
        char[] str = new char[pairs*2];

        addParen(res,pairs,pairs,str,0);

        return res;
     }


     public int coins(int n){
        int[] denoms = {25,10,5,1};

        return makeChange(n,denoms,0);
     }

    private int makeChange(int amount, int[] denoms, int i) {
        if (i>denoms.length-1) return 1;

        int denomVal = denoms[i];
        int ways = 0;

        for (int j=0;j*denomVal<=amount;j++){
            int amountRemaining = amount - i*denomVal;
            ways +=makeChange(amountRemaining,denoms,i+1);
        }

        return ways;
    }

    private void addParen(List<String> res, int left, int right, char[] str, int i) {
        if (left<0 || right<left ) return;

        if (left==0 && right==0){
            res.add(String.copyValueOf(str));
        } else {
            str[i] = '(';
            addParen(res,left-1,right,str,i+1);

            str[i] = ')';
            addParen(res,left,right-1,str,i+1);

        }
    }


    private Map<Character,Integer> buildFreqsMap(String s){
         Map<Character,Integer> freqsMap = new HashMap<>();
         for (char c: s.toCharArray()){
             if (!freqsMap.containsKey(c)){
                 freqsMap.put(c,0);
             }

             freqsMap.put(c,freqsMap.get(c)+1);
         }

        return freqsMap;
     }


    private void getPerms(Map<Character, Integer> freqs, String prefix, int remaining, List<String> res) {
        if (remaining==0){
            res.add(prefix);
            return;
        }

        freqs.forEach((c,count)->{
            if (count>0){
                freqs.put(c,count-1);
                getPerms(freqs,prefix+c,remaining -1,res);
                freqs.put(c,count);
            }
        });

    }


    private List<String> getPerms(String s) {
        List<String> res = new ArrayList<>();
        getPerms("",s,res);
        return res;

    }

    private void getPerms(String prefix, String reminder, List<String> res) {
        if (reminder.length()==0) res.add(prefix);

        int len = reminder.length();
        for (int i=0;i<len;i++){
            String before = reminder.substring(0,i);
            String after = reminder.substring(i+1,len);
            char c = reminder.charAt(i);
            getPerms(prefix+c,before+after,res);
        }
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
