/*Given the roots of two binary trees p and q, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

Example 1:
    1         1
   / \       / \
  2   3     2   3

Input: p = [1,2,3], q = [1,2,3]
Output: true
Example 2:

    1      1
   /        \
  2          2
Input: p = [1,2], q = [1,null,2]
Output: false

Example 3:
    1         1
   / \       / \
  2   1     1   2

Input: p = [1,2,1], q = [1,1,2]
Output: false
 

Constraints:

The number of nodes in both trees is in the range [0, 100].
-104 <= Node.val <= 104

/*
Solution: DFS, if p and q has different value or one of them is nullptr, then return false;
Time: O(n) -> Walk through all nodes;
Space: O(h) -> In the worst case, the stack stores all function calls from the root to the deepest leaf. 
- Best case (Balanced Tree): $O(\log N)$
- Worst case (Skewed/Line Tree): $O(N)$
*/

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    bool isSameTree(TreeNode* p, TreeNode* q) {
        if (p == nullptr && q == nullptr){
            return true;
        }
        if (p == nullptr || q == nullptr || p->val != q->val){
            return false;
        }
        return isSameTree(p->left, q->left) && isSameTree(p->right, q->right);

    }
    
};