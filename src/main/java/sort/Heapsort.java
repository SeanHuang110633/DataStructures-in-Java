package main.java.sort;

import java.util.Arrays;

/**
 * ClassName: Heapsort
 * PackageName: main.java.sort
 */
public class Heapsort {

    public static void main(String[] args) {
        int[] arr = {4, 5, 9, 1, 77, 22, 55, 3};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void heapSort(int[] arr) {
        int n = arr.length;

        // 建立最大堆
        // n/2-1是最後一個non-leaf節點
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify2(arr, n, i);
        }

        // 從堆中取出元素，放到已排序部分
        for (int i = n - 1; i > 0; i--) {
            // 將root(最大值根)跟最後一個節點交換
            swap(arr, 0, i);

            // 將剩餘部分(已剔除最後一個節點，現在最後是最大的)重新調整為最大堆
            heapify2(arr, i, 0);
        }
    }

    // 將子樹調整為最大堆(遞迴)
    private static void heapify1(int[] arr, int n, int i) {
        int largest = i; // 設定最後一個non-leaf節點為最大值
        int left = 2 * i + 1; // 左子
        int right = 2 * i + 2; // 右子

        // 若左子比當前節點大，更新最大值
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // 若右子節點比當前最大值大，更新最大值
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // 若最大值非最後一個non-leaf節點，進行交換並遞迴調整
        if (largest != i) {
            swap(arr, i, largest);
            heapify1(arr, n, largest);
        }
    }

    // 將子樹調整為最大堆(迭代)
    private static void heapify2(int[] arr, int n, int i) {
        while (true) {
            int largest = i; // 設定最後一個non-leaf節點為最大值
            int left = 2 * i + 1; // 左子
            int right = 2 * i + 2; // 右子

            // 若左子比當前節點大，更新最大值
            if (left < n && arr[left] > arr[largest]) {
                largest = left;
            }

            // 若右子節點比當前最大值大，更新最大值
            if (right < n && arr[right] > arr[largest]) {
                largest = right;
            }

            // 最大值仍是最後一個non-leaf節點，代表沒有比較大的孩子或沒有孩子，循環結束
            if (largest == i) {
                break;
            }

            // 若最大值非最後一個non-leaf節點，進行交換
            swap(arr, i, largest);
            // 下次循環從找到的子節點位置開始
            i = largest;
        }

    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
