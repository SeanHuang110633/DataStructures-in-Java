package main.java.quickpower;

import org.junit.Test;

/**
 * ClassName: BinExp
 * PackageName: main.java.quickpower
 * Description:
 */
public class BinExp {

    @Test
    public void test(){
        System.out.println(function(10,3));
        System.out.println(function(2,9));
        System.out.println(function(5,4));
    }


    int function(int base, int exp) {
        int res = 1;

        while (exp != 0) {
            if ((exp & 1) == 1) {
                res = res * base;
            }
            base = base * base;
            exp = exp >> 1;
        }
        return res;
    }
}
