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

/*
時間複雜度: 平均O(log n); 最差O(n) ->root找到target = O(h) + target有左右小孩要找min = O(h) + 遞迴刪掉minNode = O(h)
空間複雜度: O(n) -> 遞迴會開n個空間，還沒return前空間存在，因此同時存在的輔助空間是frame數量h
解題: recursion解BST
1. 第一層if 找到target node，找到後進入else，進入第二層if
2. 第二層if 判斷target node底下有沒有左右child，如果只有一邊，直接接上另外一邊
3. 如果有兩邊的child,找出右邊(左邊也可，擇一)最小值的minNode，用minNode.val替換target.val，再刪除minNode
   3.1. 刪除minNode是進入target.right subtree，resursively 用第一層if 判斷node.left = null，代表找到minNode，回傳他的右邊return minNode.right

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
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null){
            return null;
        }

        if (key < root.val){
            root.left = deleteNode(root.left, key);
        } else if (key > root.val){
            root.right = deleteNode(root.right, key);
        } else {
            //Found target node!
            // --- Simple Cases (0 or 1 Child) --- simply return the othe child to replace the current node.
            if (root.left == null){
                return root.right;
            } else if (root.right == null){
                return root.left;
            } else {
             // --- Complex Case (2 Children) --- find the min value of the right subtree of target node, copy the value to current node, delete the minNode.
                TreeNode minNode = findMin(root.right);
                root.val = minNode.val;
                //re-scan and delete minNode, minNode.left should be null due to it is the min.
                root.right = deleteNode(root.right, root.val);
            }
        }
        return root;
    }

    public TreeNode findMin(TreeNode node){
        int val = node.val;
        while (node.left != null){
            node = node.left;
        }
        return node;
    }
}