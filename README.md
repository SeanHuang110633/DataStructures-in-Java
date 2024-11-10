## 簡介
使用Java實現資料結構，目的是透過實作深入理解每種結構的概念與操作，同時維持JAVA語法的熟悉度；另因程式碼主要是自己練習使用，有些地方的命名及註釋可能有錯字還請見諒並忽略它XD。
## 目錄 
依照我的學習順序排序 : 
+ **Array** : 實現動態陣列。
+ **LinkedList**
  + SinglyLinkedList
  + SinglyLinkedListSentinel
  + DoublyLinkedList (有加 Sentinel)
  + CircularLinkedList
  + LeetCode相關題目
    + MergeTwoSinglyLinkedListWithOrder : 合併兩個元素有序的單向鏈表，合併後元素必須維持順序
    + RemoveByValue : 根據節點值刪除對應的單項鏈表節點
    + QuickSlowPointer : 利用快慢指針找到鏈表的中間節點 and 鏈表尾部開始的第 n 個節點
    + RemoveDuplicatedValue : 刪除單項鏈表中重複的值，保留一個
    + ReverseSinglyLinkedList : 反轉單項鏈表
+ **Recursion** : 實現常見的遞迴程式碼
  + Fib (費氏數列)
  + Ackerman
  + Binomial
  + HanoiTower
  + PascalTriangle
  + BubbleSort
  + InsertSort
  + ArraySum
+ **Queue**
  + CircularArrayQueue : 環形陣列實現
  + CircularLinkedListQueue : 環形鏈表實現
  + DoubleStackImpQueue : 雙stack實現
+ **Stack**
  +  ArrayStack : 陣列實現stack
  +  SinglyLinkedListStack : 單向鏈表實現stack
  +  InfixToPostfix : 中綴表達式轉後綴
  +  InfixToPrefix : 中綴表達式轉前綴
  +  PostfixCount : 輸入後綴表達式取得結果
+ **Search**
  + BinarySearchBasic
  + BinarySearchLeftRightMost : 二分查找處理重複元素
  + BinarySearchRecursion(遞迴版)
  + linearsearch
  + Interpolation
+ **Sort**
  + Bubble
  + Insertion
  + Shell
  + Selection
  + Heap
  + Quick
  + Merge
  + Count
  + Bucket
  + Radix
+ **Tree** : 分別用recursion和iteration實現BinaryTree的前、中、後序traversal
+ **Graph** : 只實現了Edge類和Vertex類，續將實現其DFS、BFS、Dijkstra等Algo
+ **advancedTree** : 實現紅黑樹與其Insert (但還沒測試)
