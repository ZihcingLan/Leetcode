/*
Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

Search for a node to remove.
If the node is found, delete the node.
 

Example 1:


Input: root = [5,3,6,2,4,null,7], key = 3
Output: [5,4,6,2,null,null,7]
Explanation: Given key to delete is 3. So we find the node with value 3 and delete it.
One valid answer is [5,4,6,2,null,null,7], shown in the above BST.
Please notice that another valid answer is [5,2,6,null,4,null,7] and it's also accepted.

Example 2:

Input: root = [5,3,6,2,4,null,7], key = 0
Output: [5,3,6,2,4,null,7]
Explanation: The tree does not contain a node with value = 0.
Example 3:

Input: root = [], key = 0
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 104].
-105 <= Node.val <= 105
Each node has a unique value.
root is a valid binary search tree.
-105 <= key <= 105
*/


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 //Gemini協助，Iterative 暴力解
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null){
            return null;
        }

        //Find the target node
        TreeNode cur = root;
        TreeNode parent = null;
        while (cur != null && cur.val != key){
            parent = cur;
            if (key < cur.val){
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        //cur is the deleted node, parent is cur's upper node
        if (cur == null){
            return root;
        }

//以下是Gemini寫的 2. 準備刪除 cur，先決定誰要來接替 cur 的位置 (newSubTreeRoot)
        TreeNode newSubTreeRoot;

        // 情況 A: 如果左邊是空的，右邊直接接手 (包含兩邊都空的情況)
        if (cur.left == null) {
            newSubTreeRoot = cur.right;
        } 
        // 情況 B: 如果右邊是空的，左邊直接接手
        else if (cur.right == null) {
            newSubTreeRoot = cur.left;
        } 
        // 情況 C: ⭐ 兩個小孩都有 (最難的部分)
        else {
            // 策略：把「原本的右子樹」，接到「左子樹的最右下角」
            TreeNode rightChild = cur.right;
            TreeNode leftMax = cur.left;
            
            // 找到左子樹裡最大的點 (一直往右走)
            while (leftMax.right != null) {
                leftMax = leftMax.right;
            }
            
            // 把原本的右子樹，掛在左子樹最大值的右手邊
            leftMax.right = rightChild;
            
            // 新的根節點由原本的左小孩擔任
            newSubTreeRoot = cur.left;
        }

        // 3. 把接替者 (newSubTreeRoot) 接回 parent 身上
        if (parent == null) {
            // 如果刪除的是原本的 root，那接替者就是新的 root
            return newSubTreeRoot;
        }

        if (parent.left == cur) {
            parent.left = newSubTreeRoot;
        } else {
            parent.right = newSubTreeRoot;
        }

        return root;
    }
}