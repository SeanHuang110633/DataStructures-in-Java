package main.java.recursion;

import java.util.Currency;

/**
 * ClassName: Binomial
 * PackageName: main.java.recursion
 * Description:
 *
 * @Create: 2024/10/2-下午 10:53
 */
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
