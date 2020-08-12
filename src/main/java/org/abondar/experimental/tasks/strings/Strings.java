package org.abondar.experimental.tasks.strings;


import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;


public class Strings {

    public boolean isUnique(String str) {
        boolean isUnique = false;

        char[] strc = str.toCharArray();
        Arrays.sort(strc);

        for (int i = 0; i < strc.length - 1; i++) {
            if (strc[i] != strc[i + 1]) {
                isUnique = true;
            } else {
                isUnique = false;
                break;
            }
        }

        return isUnique;
    }


    public boolean checkPermutation(String str1, String str2) {
        char[] strc1 = str1.toCharArray();
        char[] strc2 = str2.toCharArray();

        Arrays.sort(strc1);
        Arrays.sort(strc2);

        return Arrays.equals(strc1, strc2);
    }


    /*
     *
     * pureLen -  str at the end has spaces, pureLen size of str without them
     */
    public String urlify(String str, int pureLen) {

        char[] strc = str.toCharArray();
        char[] urlc = new char[strc.length];
        char[] symbols = {'%', '2', '0'};

        int nextChar = 0;
        for (int i = 0; i < pureLen; i++) {
            if (strc[i] == ' ') {
                for (int k = 0; k < symbols.length; k++) {
                    urlc[nextChar] = symbols[k];
                    nextChar++;
                }

            } else {
                urlc[nextChar] = strc[i];
                nextChar++;
            }
        }


        return String.valueOf(urlc);
    }


    public boolean palindromePermutation(String str) {
        boolean isPalindromePermutation;

        str = str.toLowerCase();

        char[] strc = str.toCharArray();

        int numberOfPairs = 0;
        if (str.length() % 2 == 0) {
            for (char c : strc) {
                if (str.indexOf(c) != str.lastIndexOf(c)) {
                    numberOfPairs++;
                }
            }
            isPalindromePermutation = numberOfPairs % 2 == 0;

        } else {
            for (char c : strc) {
                if (str.indexOf(c) == str.lastIndexOf(c)) {
                    numberOfPairs++;
                }
            }
            isPalindromePermutation = numberOfPairs == 1;

        }

        return isPalindromePermutation;
    }


    public boolean oneAway(String str1, String str2) {
        boolean oneEdit;

        char[] str1c = str1.toCharArray();
        char[] str2c = str2.toCharArray();

        Arrays.sort(str1c);
        Arrays.sort(str2c);


        if (Math.abs(str1c.length - str2c.length) > 1) {
            oneEdit = false;
        } else {
            if (str1c.length != str2c.length) {
                int minLen = Math.min(str1c.length, str1c.length);
                if (str1c.length == minLen) {
                    oneEdit = iterateOverMinStr(str1c, str2);
                } else {
                    oneEdit = iterateOverMinStr(str2c, str1);
                }

            } else {
                oneEdit = iterateOverMinStr(str1c, str2);
            }
        }


        return oneEdit;
    }

    private boolean iterateOverMinStr(char[] shortStr, String longStr) {


        int numberOfDiffs = 0;
        for (int i = 0; i < shortStr.length; i++) {
            if (longStr.indexOf(shortStr[i]) == -1) {
                numberOfDiffs++;
            }

        }

        return numberOfDiffs <= 1;
    }


    public String stringCompressor(String str) {
        StringBuilder compression = new StringBuilder();
        char[] strc = str.toCharArray();

        int numRepeats = 0;
        for (int i = 0; i < strc.length; i++) {
            numRepeats++;

            if (i + 1 >= strc.length || strc[i] != strc[i + 1]) {
                compression.append(strc[i]);
                compression.append(numRepeats);

                numRepeats = 0;
            }

        }

        return compression.toString();
    }


    public String reverseString(String str) {

        char[] strArr = str.toCharArray();

        int half = strArr.length / 2;

        int swpId;
        char buf;
        for (int i = 0; i < half; i++) {
            swpId = strArr.length - i - 1;
            buf = strArr[i];
            strArr[i] = strArr[swpId];
            strArr[swpId] = buf;

        }

        return new String(strArr);
    }

    public boolean isStringPalindrome(String str) {
        str = str
                .replaceAll("[^A-Za-z0-9]", "")
                .toLowerCase();

        String reverse = reverseString(str);

        return reverse.equals(str);
    }

    public String longestCommonPrefix(String[] arr) {
        if (arr.length == 0) {
            return "";
        }
        char[] prefixStr = arr[0].toCharArray();

        StringBuilder prefix = new StringBuilder();
        for (char pfx : prefixStr) {
            prefix.append(pfx);
            if (!containsPrefix(arr, prefix.toString())) {
                prefix.deleteCharAt(prefix.length() - 1);
                break;
            }
        }
        return prefix.toString();
    }

    private boolean containsPrefix(String[] arr, String prefix) {
        for (String s : arr) {
            if (s.indexOf(prefix) != 0) {
                return false;
            }
        }

        return true;
    }

    public boolean validParentheses(String str) {
        Map<Character, Character> parMap = new HashMap<>();
        parMap.put('}', '{');
        parMap.put(']', '[');
        parMap.put(')', '(');

        Stack<Character> pars = new Stack<>();

        for (char c : str.toCharArray()) {
            if (parMap.containsKey(c)) {
                char top = pars.isEmpty() ? '#' : pars.pop();
                if (top != parMap.get(c)) {
                    return false;
                }
            } else {
                pars.push(c);
            }
        }

        return pars.isEmpty();
    }

    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }


    public int stringLen(String str) {
        int count = 0;

        char[] strc = str.toCharArray();

        String mult;
        int startBracket = 0;
        int endBracket = 0;
        int multStart = -1;
        for (int i = 0; i < strc.length; i++) {
            if (strc[i] == '[') {

                startBracket = i;
                endBracket = findEndBracketPos(str.toCharArray(), startBracket);
                String substr = str.substring(startBracket + 1, endBracket);
                mult = str.substring(multStart, startBracket);
                if (!mult.isEmpty()) {
                    if (substr.contains("[") && substr.contains("]")) {
                        count += Integer.parseInt(mult) * stringLen(substr);
                        if (endBracket == strc.length - 1) {
                            break;
                        }
                    } else {
                        count += countInside(substr, Integer.parseInt(mult));
                        multStart = -1;
                    }
                }
            }

            if (Character.isDigit(strc[i])) {
                if (multStart == -1) {
                    multStart = i;
                }

            } else if (startBracket == 0 || i > endBracket) {
                count++;
            }
        }
        return count;
    }

    private int findEndBracketPos(char[] str, int index) {
        int closePos = index;
        int counter = 1;
        while (counter > 0) {
            char c = str[++closePos];
            if (c == '[') {
                counter++;
            } else if (c == ']') {
                counter--;
            }
        }
        return closePos;
    }

    private int countInside(String str, int mult) {
        return mult * str.length();
    }

    public int stringLen1(String str) {
        int count = 0;
        char[] strc = str.toCharArray();

        String mult = "0";
        int multStart = -1;

        Stack<MultCLass> multStack = new Stack<>();
        int intCount = -1;

        for (int i = 0; i < strc.length; i++) {
            MultCLass mcl = new MultCLass();
            if (strc[i] == '[') {
                intCount = 0;
                mult = str.substring(multStart, i);

                multStart = -1;
                mcl.mult = Integer.parseInt(mult);
                mcl.count = intCount;
                multStack.push(mcl);

            }

            if (strc[i] == ']') {
                mcl = multStack.pop();
                if (mcl.count==0){
                    count*=mcl.mult;
                } else {
                    count += mcl.count * mcl.mult;
                }

                intCount = -1;
            }

            if (Character.isDigit(strc[i])) {
                if (multStart == -1) {
                    multStart = i;
                }

            } else if (strc[i] != '[' && strc[i] != ']') {

                if (intCount != -1) {
                    intCount++;
                    mcl.mult = Integer.parseInt(mult);
                    mcl.count = intCount;
                    multStack.push(mcl);
                } else {
                    count++;
                }
            }

        }


        return count;
    }

    static class MultCLass {
        private int mult;
        private int count;
    }


    public List<String> filterStrings(Collection<String> strings) {

        return strings.stream()
                .filter(s -> s != null && !s.isEmpty())
                .map(String::trim)
                .map(String::toUpperCase)
                .distinct()
                .sorted(Comparator.comparing(String::length))
                .collect(Collectors.toList());
    }



    public int cardWar(String A, String B) {
        if (A.length() != B.length()) {
            return -1;
        }
        int count = 0;
        for (int x = 0; x < A.length(); x++) {
            char ac = A.charAt(x);
            char bc = B.charAt(x);

            count += getRank(ac, bc);
        }
        return count;
    }

    private  int getRank(Character a, Character b) {

        int count = 0;
        Map<Integer, Character> rank = new HashMap<>();
        rank.put(2, '2');
        rank.put(3, '3');
        rank.put(4, '4');
        rank.put(5, '5');
        rank.put(7, '6');
        rank.put(6, '7');
        rank.put(8, '8');
        rank.put(9, '9');
        rank.put(10, 'T');
        rank.put(11, 'J');
        rank.put(12, 'Q');
        rank.put(13, 'K');
        rank.put(14, 'A');

        AtomicInteger ap = new AtomicInteger();
        AtomicInteger bp = new AtomicInteger();


        rank.forEach((k,v)->{
            if (v==a){
                ap.set(k);
            }

            if (v==b){
                bp.set(k);
            }

        });


        if (ap.get() > bp.get()) {
            count++;
        }
        return count;
    }

    public int stringChains(List<String> words){
        Map<String,Integer> chains = new HashMap<>();
        AtomicInteger res = new AtomicInteger();
        res.set(0);

        Set<String> dict = words.stream().collect(Collectors.toSet());


        words.forEach(w->{
            res.set(dfs(w,dict,chains));
        });


        return res.get();
    }

    private  int dfs(String word,Set<String> dict, Map<String,Integer> chains){
        int maxChain = 0;
        StringBuilder sb = new StringBuilder(word);

        if (word.length()==0 || !dict.contains(word)){
            return 0;
        }

        if (chains.containsKey(word)){
            return chains.get(word);
        }

        for (int i = 0; i<word.length();i++){
            char delete = sb.charAt(i);
            sb.deleteCharAt(i);

            String predcessor = sb.toString();
            maxChain = Math.max(maxChain, 1 + dfs(predcessor, dict, chains));

            sb.insert(i, delete);
        }

        chains.put(word, maxChain);

        return maxChain;
    }
}
