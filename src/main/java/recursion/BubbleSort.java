package main.java.recursion;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {444, 33, 4, 1, 222, 199, 3};
        basic(arr);
        System.out.println();
        int[] recursion1 = recursion1(arr, arr.length - 1);
        Arrays.stream(recursion1).forEach(e-> System.out.print(e+", "));
        System.out.println();
        int[] recursion2 = recursion2(arr, arr.length - 1);
        Arrays.stream(recursion2).forEach(e-> System.out.print(e+", "));
    }


    //基礎款
    public static void basic(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        Arrays.stream(arr).forEach(e-> System.out.print(e+", "));
    }

    //遞迴基本
    public static int[] recursion1(int[] arr, int low) {

        if (low == 0) {
            return arr;
        }

        for (int j = 0; j < low; j++) {
            if (arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
        return  recursion1(arr, low - 1);
    }


    //遞迴:改良
    //原本：每次-1，只考慮每次排好最後一個數，但有可能其他的已經排好了，會做很多無用功
    //改良:用X紀錄最後一次交換發生的地方，即有序與無序的邊界
    public static int[] recursion2(int[] arr, int low) {
        if (low == 0) {
            return arr;
        }
        int x = 0;
        for (int j = 0; j < low; j++) {
            if (arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                x=j;
            }
        }
        return  recursion1(arr, x);
    }
}
