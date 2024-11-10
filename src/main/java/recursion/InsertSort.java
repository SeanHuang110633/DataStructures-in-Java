package main.java.recursion;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {444, 33, 4, 1, 222, 199, 3};
        int[] recursion1 = recursion1(arr, 1);
        Arrays.stream(recursion1).forEach(e -> System.out.print(e + ", "));
    }

    public static int[] recursion1(int[] arr, int low) {
        if (low == arr.length) {
            return arr;
        }

        int currentElement = arr[low];
        int j = low - 1;

        while (j >= 0 && currentElement < arr[j]) {
            arr[j + 1] = arr[j];
            j--;
        }

        if ((j + 1) != low) {   //沒有進到迴圈中的話(原本順序就沒問題)，不需要給j + 1(=low)賦currentElement(=arr[low])
            arr[j + 1] = currentElement;
        }

        return recursion1(arr, low+1);
    }
}
