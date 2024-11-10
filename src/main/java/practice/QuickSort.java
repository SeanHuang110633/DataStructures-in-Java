package main.java.practice;

import org.junit.Test;

import java.util.Arrays;

/**
 * ClassName: QuickSort
 * PackageName: main.java.prac
 * Description:
 *
 * @Create: 2024/11/1-下午 01:36
 */
public class QuickSort {

    @Test
    public void test1() {
        int[] arr = {4, 5, 9, 1, 77, 22, 55, 3};
        func1(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public void func1(int[] arr, int left, int right) {
        if (left < right) { // 這個一定要
            // 兩個指針和PV
            int pv = arr[left];
            int i = left;
            int j = right + 1;
            // 如果I小於J就繼續
            do {
                do {
                    i++;
                } while (i <= right && arr[i] < pv);
                do {
                    j--;
                } while (j >= left && arr[j] > pv);
                // IJ都有找到他們該找的值就交換
                if (i < j) {
                    swap(arr, i, j);
                }
            } while (i < j);
            // 一輪結束要將j跟PV對調
            swap(arr, left, j);
            // recursive左右
            func1(arr, left, j - 1);
            func1(arr, j + 1, right);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int t = arr[j];
        arr[j] = arr[i];
        arr[i] = t;
    }

}
