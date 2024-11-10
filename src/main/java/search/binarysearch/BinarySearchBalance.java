package main.java.search.binarysearch;


/**
 * ClassName: BinarySearchBalance
 * PackageName: main.java.search.binarysearch
 * Description: 二分查找iteration實現，平衡版(減少循環內部的平均比較次數)
 * 基礎版中，欲查找元素在最右邊或最左邊的情況，兩者比較次數會差2倍
 */
public class BinarySearchBalance {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 7, 8, 9, 10};
        int[] b = {1, 2, 43, 57, 998, 34510};
        int[] c = {1, 2, 3, 4, 12, 222, 322, 711, 2822, 9999};

        System.out.println(f(a, 10));  //6
        System.out.println(f(b, 10));  // -2
        System.out.println(f(c, 10)); // -3
    }


    public static int f(int[] arr, int target) {
        int i = 0;
        int j = arr.length; // 表示邊界(不參與比較)

        while (1 < j - i) {  // 表示範圍內待查找的元素個數
            int mid = (i + j) >>> 1;
            if (arr[mid] < target) {
                i = mid + 1;  //不要加一，i如果等於mid，代表還沒找到
            } else {
                j = mid;  //j=mid且i跟j中間沒有值，代表找到了
            }
        }

        if(arr[i] == target){
            return i;
        }else{
            return -i; // i表示未找到的值應該插入的索引
        }
    }
}
