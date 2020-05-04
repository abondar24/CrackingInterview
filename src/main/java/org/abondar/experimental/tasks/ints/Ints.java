package org.abondar.experimental.tasks.ints;

public class Ints {

    public int reverseInteger(int x) {
        long res=0;
        long xl = x;

        while (xl!=0){
            res = xl%10 + res*10;
            xl = xl/10;
        }

        return (res == (int)res) ? (int)res : 0;

    }

    public boolean isIntegerPalindrome(int x){
        if (x<0){
            return false;
        }

        int reverseX = reverseInteger(x);

        return reverseX==x;
    }
}
