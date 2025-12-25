/*
Given the roots of two binary trees p and q, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

 

Example 1:


Input: p = [1,2,3], q = [1,2,3]
Output: true
Example 2:


Input: p = [1,2], q = [1,null,2]
Output: false
Example 3:


Input: p = [1,2,1], q = [1,1,2]
Output: false
 

Constraints:

The number of nodes in both trees is in the range [0, 100].
-104 <= Node.val <= 104
*/

/*
時間複雜度:O(n) ->最差需要遍歷每個node
空間複雜度:O(n) ->recursion，空間複雜度主要來自於遞迴過程中，系統堆疊 (Stack) 儲存的函式呼叫資訊，最壞情況： 如果樹是單邊傾斜的（例如，只有左子樹或只有右子樹），樹高 $H$ 就等於節點總數 $N$。平均情況/最好情況： 如果樹是平衡的（Balanced Tree），則樹高 $H$ 大約是 $\log_2 N$。
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null){
            return true;
        }
        if (p == null || q == null || p.val != q.val){
            return false;
        }

        boolean isLeft = isSameTree(p.left, q.left);
        boolean isRight = isSameTree(p.right, q.right);

        return isLeft && isRight;
    }

}