package main.java.tree.binarytree;

/**
 * ClassName: TreeNode
 * Description: 實現樹節點結構
 *
 */

public class TreeNode {
    public int value;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int value) {
        this.value = value;
    }

    public TreeNode(int value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}
