package main.java.practice;

import org.junit.Test;

import java.util.Arrays;

/**
 * PackageName: main.java.prac
 * Description:
 */
public class MergeSortPractice {

    @Test
    public void test1() {
        int[] arr = {4, 5, 9, 1, 77, 22, 55, 3};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public void mergeSort(int[] arr, int left, int right) {
        int[] arrVisual = Arrays.copyOfRange(arr, left, right + 1);
        System.out.println(Arrays.toString(arrVisual));

        if (left >= right) {
            return;
        }

        int mid = (left + right) >>> 1;

        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

    }

    public void merge(int[] arr, int left, int right, int mid) {

        int[] temp = new int[arr.length];
        int[] leftArr = new int[mid + 1];
        int[] rightArr = new int[right - mid];


        for (int i = 0; i <= mid; i++) {

        }
    }
}
