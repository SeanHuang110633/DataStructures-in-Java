package main.java.search.binarysearch;

/**
 * ClassName: BinarySearchRecursion
 * PackageName: main.java.search.binarysearch
 * Description: 二分查找Recursion實現
 */

public class BinarySearchRecursion {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 7, 8, 9, 10};
        int[] b = {1, 2, 43, 57, 998, 34510};
        int[] c = {1, 2, 3, 4, 12, 222, 322, 711, 2822, 9999};

        System.out.println(bs(a, 10,0,a.length-1));  //6
        System.out.println(bs(b, 10,0,b.length-1));  // -3
        System.out.println(bs(c, 10,0,c.length-1)); // -5
    }


    public static int bs(int[] arr, int target, int i, int j) {
        if (i > j) {
            return -(i+1);
        }

        int mid = (i + j) >>> 1;
        if (arr[mid] < target) {
            i = mid + 1;
            return bs(arr, target, i, j);
        } else if (target < arr[mid]) {
            j = mid - 1;
            return bs(arr, target, i, j);
        } else {
            return mid;
        }
    }
}
