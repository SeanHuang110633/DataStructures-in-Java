package main.java.quickpower;

import org.junit.Test;

/**
 * ClassName: ModularExp
 * PackageName: main.java.quickpower
 * Description:
 *
 * @Create: 2024/11/13-下午 02:05
 */
public class ModularExp {
    @Test
    public void test(){
        System.out.println(function(10,3,10));
        System.out.println(function(2,9,9));
        System.out.println(function(5,4,3));
        System.out.println(function(7,560,561));
    }


    int function(int base, int exp, int mod) {
        int res = 1 % mod;

        while (exp != 0) {
            if ((exp & 1) == 1) {
                res = (res * base) % mod;
            }
            base = (base * base) % mod;
            exp = exp >> 1;
        }
        return res;
    }
}
