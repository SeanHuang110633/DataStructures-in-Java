package main.java.sort.quicksort;

import org.junit.Test;

import java.util.Arrays;

/**
 * ClassName: single
 * PackageName: main.java.sort.quicksort
 * Description: 單側快速排序 lomuto
 * (1) 選擇最右邊的元素當作比較基準(pivot)
 * (2) 設定 i 和 j 指針，並從最左邊開始向右前進，j找比pivot小的,i找大於等於pivot的
 * (3) 找到後就停下來交換(相等時不交換)
 * (4) 當j抵達最右邊時結束，pivot與當下的i交換，並返回pivot位置
 * (5) 基於新的基準點對左右分區重複進行相同流程
 */
public class Single {

    @Test
    public void test() {
        int[] arr1 = {4, 5, 9, 1, 77, 22, 55, 3};
        sort(arr1);
        System.out.println(Arrays.toString(arr1));
        int[] arr2 = {2,8,7,1,3,5,6,4};
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
        int pv = arr[right]; // 基準點元素
        int i = left;  // 找比基準點大的元素
        int j = left;  // 找比基準點小的元素
        while (j < right) { // j = right時不用在進到迴圈中
            if (arr[j] < pv) {
                if (i != j) {  // 相同的時候就不交換
                    swap(arr, i, j);
                }
                i++;
            }
            j++;
        }
        swap(arr, i, right);
        return i;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
