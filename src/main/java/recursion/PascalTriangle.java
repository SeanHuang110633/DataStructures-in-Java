package main.java.recursion;

import org.junit.jupiter.api.Test;

public class PascalTriangle {

    public static void main(String[] args) {
        mine(5);
        System.out.println("====================");
        print2(5);
    }

    public static void mine(int n) {
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            arr[i][0] = 1;
            arr[i][i] = 1;

            for (int j = 1; j < i; j++) {
                arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
            }
        }

        print1(n, arr);
    }

    public static void print1(int n, int[][] arr) {
        // 打印楊輝三角
        for (int i = 0; i < n; i++) {
            // 打印每行前的空格，使數字對齊
            for (int k = n; k > i; k--) {
                System.out.print(" ");
            }
            // 打印每行的數字
            for (int j = 0; j <= i; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println(); // 換行
        }
    }


    public static int recursion(int i, int j, int[][] arr) {
        if (arr[i][j] > 0) {   //記憶法優化(如果大 0 代表已經找過了)
            return arr[i][j];
        }

        if (j == 0 || j == i) {
            arr[i][j] = 1;   //記憶法優化
            return 1;
        }

        arr[i][j] = recursion(i - 1, j - 1, arr) + recursion(i - 1, j, arr);
        return arr[i][j];

    }



    public static void print2(int n) {
        int[][] arr = new int[n][];  //記憶法優化
        for (int i = 0; i < n; i++) {
            arr[i] = new int[i + 1];
            for (int j = 0; j <= i; j++) {
                System.out.print(recursion(i, j, arr));
            }
            System.out.println();
        }
    }


    public static void dynamic(int n) {
        int[] arr = new int[n];
        arr[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = i; j > 0; j--) {
                arr[j] = arr[j-1]+arr[j];
            }

            for (int element : arr) {
                if (element > 0) {
                    System.out.print(element + " ");
                }
            }
            System.out.println();
        }
    }

    @Test
    public void testDynamic() {
        dynamic(5);
    }


}
