package main.java.recursion;


public class HanoiTower2 {

    public static void main(String[] args) {
        int n = 3; // 上好美盤
        moveDisks1(n, 'A', 'B', 'C');
    }


    public static void moveDisks1(int n, char src, char aux, char dest) {
        if (n == 1) {
            System.out.println("將第" + n + "個盤子從" + src + "移動到" + dest);
            return;
        }

        moveDisks1(n - 1, src, dest, aux);
        System.out.println("將第" + n + "個盤子從" + src + "移動到" + dest);
        moveDisks1(n - 1, aux, src, dest);
    }
}
