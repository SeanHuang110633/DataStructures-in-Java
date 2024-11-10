package main.java.sort.quicksort;

import org.junit.Test;

import java.util.Arrays;

/**
 * ClassName: Double
 * PackageName: main.java.sort.quicksort
 * Description: 雙邊快速排列(使用while)
 */
public class Double1 {
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
        quick(arr, 0, arr.length - 1);
    }

    private void quick(int[] arr, int left, int right) {
        if (left >= right) { // 不斷縮小分區直到左右相遇即結束
            return;
        }
        int p = partition(arr, left, right);
        quick(arr, left, p - 1);
        quick(arr, p + 1, right);
    }

    // 分區方法 : 返回基準點，讓左邊的都比它小，右邊的都比它大
    private int partition(int[] arr, int left, int right) {
        int pv = arr[left]; // 基準點元素
        int i = left;  // 找比基準點大的元素
        int j = right;  // 找比基準點小的元素
        while (i < j) {
            // 從右向左找比pv小的
            while (i < j && arr[j] > pv) {
                j--;
            }
            // 從右向左找比pv大的
            while (i < j && arr[i] <= pv) {
                i++;
            }
            // 找到了
            swap(arr, i, j);
        }
        swap(arr, i, left);
        return i;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
