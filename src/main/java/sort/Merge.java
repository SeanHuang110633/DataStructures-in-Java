package main.java.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * ClassName: Merge
 * PackageName: main.java.sort
 * Description: 合併排序
 */
public class Merge {

    @Test
    public void test(){
        int[] arr = {4, 5, 9, 1, 77, 22, 55, 3};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public void mergeSort(int[] arr, int left, int right) {
        // 把每次分割的結果打出來看看
        int[] arrVisual = Arrays.copyOfRange(arr, left, right + 1);
        System.out.println(Arrays.toString(arrVisual));

        if (left >= right) {
            return;
        }
        int mid = (left + right) >>> 1;

        // 遞迴分割左半部分
        mergeSort(arr, left, mid);
        // 遞迴分割右半部分
        mergeSort(arr, mid + 1, right);

        // 看看都在甚麼時候合併
        System.out.println("執行merge");
        // 合併
        merge(arr, left, mid, right);
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        // 計算左右兩邊的長度
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // 分別建立輔助陣列
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        // 複製數據到輔助陣列
        for (int i = 0; i < n1; i++) {
            leftArr[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArr[j] = arr[mid + 1 + j];
        }

        // 合併左右兩個輔助陣列到原陣列中
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {  // 當兩個陣列的元素尚未比較完
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        // 將剩餘元素拷貝到原陣列
        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }
}
