/*
Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.

Return the smallest level x such that the sum of all the values of nodes at level x is maximal.

 

Example 1:


Input: root = [1,7,0,7,-8,null,null]
Output: 2
Explanation: 
Level 1 sum = 1.
Level 2 sum = 7 + 0 = 7.
Level 3 sum = 7 + -8 = -1.
So we return the level with the maximum sum which is level 2.
Example 2:

Input: root = [989,null,10250,98693,-89388,null,null,null,-32127]
Output: 2
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
 */

/*
時間複雜度: O(n) -> 遍歷所有節點O(n) + for迴圈O(n)
空間複雜度: O(n) -> 樹最差是退化成單一鏈結列表，等於樹的深度L=n，所以存n層=O(n)；q寬度最差是n/2個，和O(n)同量級
解法:BFS
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

import java.util.*;
class Solution {
    public int maxLevelSum(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null){
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            int size = q.size();
            int sum = 0;
            for (int i = 0; i < size; i++){
                TreeNode cur = q.poll();
                sum += cur.val;
                if (cur.left != null){
                    q.add(cur.left);
                }
                if (cur.right != null){
                    q.add(cur.right);
                }
            }
            ans.add(sum);
        }

        //Find maximum + 1
        int maxLevel = 1;
        int max = ans.get(0);
        for (int i = 0; i < ans.size(); i++){
            if (ans.get(i) > max){
                max = ans.get(i);
                maxLevel = i + 1;
            }
        }
        return maxLevel;
    }
}