/*
Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

 

Example 1:

Input: root = [1,2,3,null,5,null,4]

Output: [1,3,4]

Explanation:



Example 2:

Input: root = [1,2,3,4,null,null,null,5]

Output: [1,3,4,5]

Explanation:



Example 3:

Input: root = [1,null,3]

Output: [1,3]

Example 4:

Input: root = []

Output: []
 */

/*
時間複雜度:O(n) -> 每個node走一次。
空間複雜度:O(n) -> 遞迴，tree高度最高是n (if 都只有1個分支往下)。
DFS寫法: 每次都先看最右邊，紀錄level，如果這個level還沒存過，level 會等於ans.size()。
E.g. 找第1層最右邊時，還沒找到的狀態: level = 1，size = 1; 已經找到時，level = 1，size = 2, 就可知這層已經找到過最右邊了。

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
//DFS
import java.util.*;
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        if (root == null){
            return ans;
        }
        record(root, 0, ans);
        return ans;
    }

    public void record(TreeNode node, int level, List<Integer> ans){
        if (node == null){
            return;
        }
        
        if (level == ans.size()){
            ans.add(node.val);
        }
        record(node.right, level+1, ans);
        record(node.left, level+1, ans);
    }
}