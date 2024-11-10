package main.java.search.binarysearch;

/**
 * ClassName: BinarySearchBasic
 * PackageName: main.java.search.binarysearch
 * Description: 二分查找處理重複元素
 */

public class BinarySearchLeftRightMost {
    public static void main(String[] args) {
        int[] a = {1, 2, 2, 2, 8, 9, 10};
        int[] b = {1, 2, 43, 43, 998, 34510};
        int[] c = {1, 2, 3, 4, 12, 222, 222, 222, 222, 9999};

        System.out.println(rightMost(a, 2));  //3
        System.out.println(rightMost(b, 43));  // 3
        System.out.println(rightMost(c, 222)); // 8

        System.out.println(leftMost(a, 2)); // 1
        System.out.println(leftMost(b, 43)); // 2
        System.out.println(leftMost(c, 222)); // 5
    }


    public static int rightMost(int[] arr, int target) {
        int i = 0;
        int j = arr.length - 1;
        int candidate = 0;
        while (i <= j) {
            int mid = (i + j) >>> 1;
            if (arr[mid] < target) {
                i = mid + 1;
            } else if (target < arr[mid]) {
                j = mid - 1;
            } else {
                candidate = mid;
                i = mid + 1;
            }
        }
        return candidate;
    }

    public static int leftMost(int[] arr, int target) {
        int i = 0;
        int j = arr.length - 1;
        int candidate = 0;
        while (i <= j) {
            int mid = (i + j) >>> 1;
            if (arr[mid] < target) {
                i = mid + 1;
            } else if (target < arr[mid]) {
                j = mid - 1;
            } else {
                candidate = mid;
                j = mid - 1;
            }
        }
        return candidate;
    }


}
