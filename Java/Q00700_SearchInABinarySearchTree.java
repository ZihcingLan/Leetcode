/*
You are given the root of a binary search tree (BST) and an integer val.

Find the node in the BST that the node's value equals val and return the subtree rooted with that node. If such a node does not exist, return null.

Example 1:

      4
    /   \
   2     7
  / \
 1   3
Input: root = [4,2,7,1,3], val = 2
Output: [2,1,3]
Example 2:

      4
    /   \
   2     7
  / \
 1   3
Input: root = [4,2,7,1,3], val = 5
Output: []

Constraints:

The number of nodes in the tree is in the range [1, 5000].
1 <= Node.val <= 107
root is a binary search tree.
1 <= val <= 107
 */


/*
時間複雜度:O(n) ->最差有可能要找完所有的nodes
空間複雜度:O(1) ->只用了一個指標 cur
解題: BST規則為，本身包含每個node都是binary tree，且node.left一定比node小，node.right一定比較大。
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
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode cur = root; 
        while(cur != null){
            if (cur.val == val){
                return cur;
            } else if (val < cur.val){
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return null;
    }
}