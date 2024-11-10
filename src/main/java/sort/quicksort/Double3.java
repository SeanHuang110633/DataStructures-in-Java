package main.java.sort.quicksort;

import org.junit.Test;

import java.util.Arrays;

/**
 * ClassName: Double3
 * PackageName: main.java.sort.quicksort
 * Description: 使用 Middle of three 避免worst case
 *
 * @Create: 2024/10/31-上午 11:56
 */
public class Double3 {
    @Test
    public void test() {
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7};
        sort(arr1);
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = {7, 6, 5, 4, 3, 2, 1};
        sort(arr2);
        System.out.println(Arrays.toString(arr2));
    }

    public void sort(int[] arr) {
        qs(arr, 0, arr.length - 1);
    }

    public void qs(int[] arr, int left, int right) {
        if (left < right) {
            int pivotIndex = getPivot(arr, left, right); // 使用三數取中策略獲得基準值索引
            swap(arr, left, pivotIndex); // 將基準值交換到最左側
            int i = left;
            int j = right + 1;
            int pv = arr[left]; // 基準值為三數取中選出的中位數
            do {
                do {
                    i++;
                } while (i <= right && arr[i] < pv);
                do {
                    j--;
                } while (j >= left && arr[j] > pv);
                if (i < j) {
                    swap(arr, i, j);
                }
            } while (i < j);
            swap(arr, left, j); // 把基準值放到正確位置
            qs(arr, left, j - 1); // 遞迴處理左半部分
            qs(arr, j + 1, right); // 遞迴處理右半部分
        }
    }

    private int getPivot(int[] arr, int left, int right) {
        int middle = left + (right - left) / 2;
        // 比較三數並選取中位數索引
        if ((arr[left] - arr[middle]) * (arr[right] - arr[left]) >= 0) {
            return left; // 左端為中位數
        } else if ((arr[middle] - arr[left]) * (arr[right] - arr[middle]) >= 0) {
            return middle; // 中間為中位數
        } else {
            return right; // 右端為中位數
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
