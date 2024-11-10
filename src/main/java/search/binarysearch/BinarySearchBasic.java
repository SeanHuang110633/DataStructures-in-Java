package main.java.search.binarysearch;

import org.junit.Test;

/**
 * ClassName: BinarySearchBasic
 * PackageName: main.java.search.binarysearch
 * Description: 二分查找iteration實現，基礎版
 */

public class BinarySearchBasic {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 7, 8, 9, 10};
        int[] b = {1, 2, 43, 57, 998, 34510};
        int[] c = {1, 2, 3, 4, 12, 222, 322, 711, 2822, 9999};

        System.out.println(bs(a, 10));  //6
        System.out.println(bs(b, 10));  // -3
        System.out.println(bs(c, 10)); // -5

    }


    public static int bs(int[] arr, int target) {
        int i = 0; // 頭指針(也會參與比較)
        int j = arr.length - 1;  // 尾指針(也會參與比較)

        while (i <= j) {
            int mid = (i + j) >>> 1; // 找中間點
            if (arr[mid] < target) {
                i = mid + 1;
            } else if (target < arr[mid]) {
                j = mid - 1;
            } else {
                return mid;
            }
        }

        return -(i + 1); // i表示未找到的值應該插入的索引，+1是為了插入點為0的情況(-0和0是一樣的)
    }

}
