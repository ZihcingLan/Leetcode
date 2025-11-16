/*
Consider all the leaves of a binary tree, from left to right order, the values of those leaves form a leaf value sequence.



For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).

Two binary trees are considered leaf-similar if their leaf value sequence is the same.

Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.

 

Example 1:


Input: root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
Output: true
Example 2:


Input: root1 = [1,2,3], root2 = [1,3,2]
Output: false 
 */


/* 時間複雜度: O(n) -> 各自DFS一次O(n1 + n2)
   空間複雜度: O(n) -> ArrayList = O(n), O(n1 + n2) 
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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        collectLeaves(root1, list1);
        collectLeaves(root2, list2);
 
        if (list1.size() != list2.size()){
            return false;
        }
        for (int i = 0; i < list1.size(); i++){
            if (!list1.get(i).equals(list2.get(i))){
                return false;
            }
        }        
        return true;
    }

    public void collectLeaves(TreeNode node, List<Integer> out){
        if (node == null){
            return;
        }
        if (node.left == null && node.right == null){
            out.add(node.val);
        }

        collectLeaves(node.left, out);
        collectLeaves(node.right, out);
    }
}