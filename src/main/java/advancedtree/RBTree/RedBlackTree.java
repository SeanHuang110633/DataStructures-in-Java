package main.java.advancedtree.RBTree;

/**
 * ClassName: RedBlackTree
 * PackageName: main.java.advancedtree.RBTree
 * Description: 紅黑樹
 */
public class RedBlackTree {

    enum Color {
        RED, BLACK
    }

    private Node root;

    private static class Node {
        Node left;
        Node right;
        Node parent;
        Integer key;
        Object val;
        Color color = Color.RED;

        public Node(Integer key, Object val) {
            this.key = key;
            this.val = val;
        }


        // 是不是左孩子
        boolean isLeftChild() {
            return parent != null && parent.left == this;
            // return node == node.parent.leftNode; 一開始寫的
        }

        // find uncle
        Node uncle() {
            if (parent == null || parent.parent == null) {
                return null;
            }

            if (parent.isLeftChild()) {
                return parent.parent.right;
            } else {
                return parent.parent.right;
            }
        }

        // find sibling
        Node sibling() {
            if (parent == null) {
                return null;
            }

            if (this.isLeftChild()) {
                return parent.right;
            } else {
                return parent.left;
            }
        }
    }

    // is red ?
    boolean isRed(Node node) {
        return node != null && node.color == Color.RED;
    }

    // is black ?
    boolean isBlack(Node node) {
        return node == null || node.color == Color.BLACK;
    }

    // 右旋
    private void rightRotate(Node pink) {
        Node parent = pink.parent;
        Node yellow = pink.left;
        Node green = yellow.right;

        // change dad
        if (green != null) {
            green.parent = pink;
        }
        // rotate
        yellow.right = pink;
        yellow.parent = parent;
        pink.left = green;
        pink.parent = yellow;

        if (parent == null) {
            // 原本pink是root
            root = yellow;
            // 原本pink不是root，那yellow是left or right
        } else if (parent.left == pink) {
            parent.left = yellow;
        } else {
            parent.right = yellow;
        }
    }

    // 左旋
    private void leftRotate(Node pink) {
        Node parent = pink.parent;
        Node yellow = pink.right;
        Node green = yellow.left;

        // change dad
        if (green != null) {
            green.parent = pink;
        }
        // rotate
        yellow.left = pink;
        yellow.parent = parent;
        pink.right = green;
        pink.parent = yellow;

        if (parent == null) {
            // 原本pink是root
            root = yellow;
            // 原本pink不是root，那yellow是left or right
        } else if (parent.right == pink) {
            parent.right = yellow;
        } else {
            parent.left = yellow;
        }
    }


    /**
     * 相鄰的紅色必須被改(Node的預設值是紅色)
     * :有四種情況
     * @param x 新增的節點
     */
    void fixRedRed(Node x){
        // 1.插入的是跟節點的話必須是黑色
        if(x == root){
            x.color = Color.BLACK;
            return;
        }

        // 2.如果父節點是黑色則顏色不固定
        if(isBlack(x.parent)){
            return;
        }

        // 3.紅紅相鄰，uncle is red, turn dad and uncle to black, turn grandparent red
        //   and 對grandparent進行遞迴
        Node parent = x.parent;
        Node uncle = x.uncle();
        Node grandParent = parent.parent;
        if(isRed(uncle)){
            parent.color = Color.BLACK;
            uncle.color = Color.BLACK;
            grandParent.color = Color.RED;
            fixRedRed(grandParent);
            return;
        }

        // 4.紅紅相鄰，uncle is black
        if(parent.isLeftChild() && x.isLeftChild()){
            // 4.1 父親是左孩子，插入的也是左孩子，左左不平衡
            // 父親變黑
            parent.color = Color.BLACK;
            // 祖父變紅
            grandParent.color = Color.RED;
            // 祖父右旋
            rightRotate(grandParent);
        } else if (parent.isLeftChild() && !x.isLeftChild()) {
            // 4.2 父親是左孩子，插入的是右孩子，左右不平衡
            // 先父親左旋
            leftRotate(parent);
            // x旋轉到原本父親的位置，把他變黑
            x.color = Color.BLACK;
            // 祖父變紅
            grandParent.color = Color.RED;
            // 祖父右旋
            rightRotate(grandParent);
        } else if (!parent.isLeftChild() && !x.isLeftChild()) {
            // 4.3 父親是右孩子，插入的也是右孩子，右右不平衡
            // 父親變黑
            parent.color = Color.BLACK;
            // 祖父變紅
            grandParent.color = Color.RED;
            // 祖父左旋
            leftRotate(grandParent);
        }else{
            // 4.4 父親是右孩子，插入的是左孩子，右左不平衡
            // 先父親右旋
            rightRotate(parent);
            // x旋轉到原本父親的位置，把他變黑
            x.color = Color.BLACK;
            // 祖父變紅
            grandParent.color = Color.RED;
            // 祖父右旋
            leftRotate(grandParent);
        }
    }


    /**
     * 新增或更新
     * :正常新增，遇到紅紅相鄰再進行調整
     * @param key 鍵
     * @param val 值
     */
    public void put(Integer key, Object val){
        Node p = root;
        Node parent = null; // 紀錄新增節點的父節點
        // 從根結點開始找空位
        while(p != null){
            parent = p;
            if(key < p.key){
                // 向左找
                p = p.left;
            }else if (key > p.key){
                // 向右找
                p = p.right;
            }else{
                // 找到相同的key--> 更新
                p.val = val;
                return;
            }
        }

        // 退出循環代表找到空位
        Node insertNode = new Node(key,val);
        if(parent == null){
            // 代表根本沒進循環，root = null
            root = insertNode;
        } else if (key < parent.key) {
            // 要插在左邊
            parent.left = insertNode;
            insertNode.parent = parent;  // RBTree相較BT必須多出這步
        }else{
            parent.right = insertNode;
            insertNode.parent = parent;  // RBTree相較BT必須多出這步
        }
    }
}
