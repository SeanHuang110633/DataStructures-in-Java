package main.java.recursion;

import java.util.Currency;


public class Binomial {
    public static void main(String[] args) {
        System.out.println(fc(5, 3));
    }



    static int fc(int n, int m) {
        if (n == m || m == 0) {
            return 1;
        }

        return fc(n - 1, m) + fc(n - 1, m - 1);
    }
}
