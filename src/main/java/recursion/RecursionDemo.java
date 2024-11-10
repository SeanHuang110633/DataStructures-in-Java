package main.java.recursion;

/**
 * ClassName: RecursionDemo
 * PackageName: main.java.recursion
 * Description: 打印觀察遞迴執行情況
 *
 */
public class RecursionDemo {

    public static void main(String[] args) {
        my(1);
    }

    static void my(int i){
        System.out.println("調用my方法第 " + i + " 次");
        if(i == 10){
            System.out.println("調用了第" + i +"次囉，準備掉頭");
            return;
        }
        int local = i;

        my(++i);
        System.out.println("走回頭路囉，這是第" + local + "次被調用時的那個堆疊，要回到第" + (local-1) + "次的地方囉" );
    }
}
