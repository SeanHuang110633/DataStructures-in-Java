package main.java.sort.quicksort;

import org.junit.Test;

import java.util.Arrays;

/**
 * ClassName: Double2
 * PackageName: main.java.sort.quicksort
 * Description: 雙邊快速排列(使用do while)
 */
public class Double2 {
    @Test
    public void test() {
        int[] arr1 = {4, 5, 9, 1, 77, 22, 55, 3};
        sort(arr1);
        System.out.println(Arrays.toString(arr1));
        int[] arr2 = {4, 5, 9, 1, 77, 22, 55, 333};
        sort(arr2);
        System.out.println(Arrays.toString(arr2));
    }

    public void sort(int[] arr) {
        qs(arr, 0, arr.length - 1);
    }

    public void qs(int[] arr, int left, int right) {
        if (left < right) {
            int i = left;
            int j = right + 1;
            int pv = arr[left]; // 基準值為左側的第一個元素
            do {
                do {
                    i++;
                } while (i <= right && arr[i] < pv); // 記得加上邊界檢查
                do {
                    j--;
                } while (j >= left && arr[j] > pv); // 記得加上邊界檢查
                if (i < j) {
                    swap(arr, i, j);
                }
            } while (i < j);
            swap(arr, left, j); // 把基準值放到正確位置
            qs(arr, left, j - 1); // 遞迴處理左半部分
            qs(arr, j+1, right);    // 遞迴處理右半部分
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
