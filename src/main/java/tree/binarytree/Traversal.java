package main.java.tree.binarytree;

import java.util.LinkedList;

/**
 * ClassName: Traversal
 * PackageName: main.java.binarytree
 * Description: 用recursive和iteration實現BT的前、中、後序追蹤
 */
public class Traversal {

    public static void main(String[] args) {
        /**
         * 創建一binaryTree
         *          1
         *         / \
         *        2   3
         *       /   / \
         *      4   5   6
         */

        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), null)
                , new TreeNode(3, new TreeNode(5), new TreeNode(6)));

        // recursive
        System.out.println("===== 前序 ======");
        preOrder(root);  // 1 2 4 3 5 6
        System.out.println("\n" + "===== 中序 ======");
        inOrder(root);  // 4 2 1 5 3 6
        System.out.println("\n" + "===== 後序 ======");
        postOrder(root); // 4 2 5 6 3 1

        // iteration
        System.out.println("\n" + "===== 前序 ======");
        preOrder_iteration(root);
        System.out.println("\n" + "===== 中序 ======");
        inOrder_iteration(root);
        System.out.println("\n" + "===== 後序 ======");
        postOrder_iteration(root);
    }
    // region recursive (遞迴實現前中後序遍歷)

    /**
     * 前序
     * root(D) -> Left(L) -> Right(R)
     */
    public static void preOrder(TreeNode node) {
        if (node != null) {
            System.out.print(node + "\t");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    /**
     * 中序
     * Left(L) -> root(D) -> Right(R)
     */
    public static void inOrder(TreeNode node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node + "\t");
            inOrder(node.right);
        }
    }

    /**
     * 後序
     * Left(L) -> Right(R) -> root(D)
     */
    public static void postOrder(TreeNode node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node + "\t");
        }
    }

    // endregion


    // region iteration (非遞迴實現，要借助stack)

    /**
     * 前序
     * root(D) -> Left(L) -> Right(R)
     */
    public static void preOrder_iteration(TreeNode node) {
        if (node == null) {
            return;
        }
        // 創建stack紀錄走過路徑的，往回走時要用
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode current = node;
        while (current != null || !stack.isEmpty()) {  // stack有元素代表還沒往回走完
            if (current != null) { // current不為空代表"去程"還沒走完
                System.out.println("前序: " + current); // 去程就是前序
                stack.push(current); // 記錄走過的路
                current = current.left; // 繼續往下走
            } else {
                // 開始回程
                TreeNode backNode = stack.pop();
                current = backNode.right; // 回程時要查看每個節點有無右子樹，如果有，要進入並執行相同過程
            }
        }
    }

    /**
     * 中序
     * Left(L) -> root(D) -> Right(R)
     */
    public static void inOrder_iteration(TreeNode node) {
        if (node == null) {
            return;
        }
        // 創建stack紀錄走過路徑的，往回走時要用
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode current = node;
        while (current != null || !stack.isEmpty()) {  // stack有元素代表還沒往回走完
            if (current != null) { // current不為空代表"去程"還沒走完
                stack.push(current); // 記錄走過的路
                current = current.left; // 繼續往下走
            } else {
                // 開始回程
                TreeNode backNode = stack.pop();
                System.out.println("前序: " + backNode);
                current = backNode.right; // 回程時要查看每個節點有無右子樹，如果有，要進入並執行相同過程
            }
        }
    }

    /**
     * 後序
     * Left(L) -> Right(R) -> root(D)
     */
    public static void postOrder_iteration(TreeNode node) {
        if (node == null) {
            return;
        }
        // 創建stack紀錄走過路徑的，往回走時要用
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode current = node;
        TreeNode doneNode = null; // 回程時，紀錄是從左子樹還是右子樹返回；如從左子樹返回，代表可能還有右子樹沒處理，右子樹返回則代表子樹都處理了
        while (current != null || !stack.isEmpty()) {  // stack有元素代表還沒往回走完
            if (current != null) { // current不為空代表"去程"還沒走完
                stack.push(current); // 記錄走過的路
                current = current.left; // 繼續往下走
            } else {
                // 開始回程
                TreeNode peek = stack.peek(); // 取得stack頂的元素，回程時，要檢查有沒有右子樹
                if (peek.right == null || peek.right == doneNode) {  // 說明右子樹處理完了(即沒右子樹或從右子樹返回的情況)
                    doneNode = stack.pop();
                    System.out.println("後序: " + doneNode);
                } else {
                    // 有右子樹，進入並執行相同過程
                    current = peek.right;
                }
            }
        }
    }

    // endregion
}
