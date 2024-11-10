package main.java.recursion;

/**
 * ClassName: Ackerman
 * PackageName: main.java.recursion
 * Description:
 *
 * @Create: 2024/10/2-下午 11:16
 */
public class Ackerman {
    public static void main(String[] args) {
        System.out.println(fc(2, 2));
        System.out.println(fc(2, 1));
        System.out.println(fc(1, 2));
        System.out.println(fc(2, 3));
    }

    static int fc(int m, int n) {
        if (m == 0) {
            return n + 1;
        }

        if (n == 0) {
            return fc(m - 1, 1);
        }

        return fc(m-1,fc(m,n-1));
    }
}
