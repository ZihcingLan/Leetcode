/*
Given a binary tree, determine if it is height-balanced.

Example 1:

      3
     / \
    9  20
       / \
      15  7

Input: root = [3,9,20,null,null,15,7]
Output: true
Example 2:

      1
     / \
    2   2
   / \  
   3  3 
  / \
 4   4

Input: root = [1,2,2,3,3,null,null,4,4]
Output: false
Example 3:

Input: root = []
Output: true 

Constraints:
The number of nodes in the tree is in the range [0, 5000].
-104 <= Node.val <= 104
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

/*
Solution: Use a bottom-up resursive DFS approach to calculate the height of each subtree. If the height difference between left and right subtrees exceeds 1, return -1 immeditely.
Use recursive approach to execute DFS. Calculate the amount of layers from the bottom to the root. Once the gap is larger than 1, return -1 directly to the top.
Time:O(n) -> As the algorithm visits every node in the tree once.
Space: O(n) -> The space requries for the recursion stack. In the worst case, the stack depth equals the number of nodes.
*/

class Solution {
public:
    bool isBalanced(TreeNode* root) {
        return getBalanced(root) != -1;
    }

    int getBalanced(TreeNode* node){
        if (!node){
            return 0;
        }
        int leftNode = getBalanced(node->left);
        if (leftNode == -1){
            return -1;
        }
        int rightNode = getBalanced(node->right);
        if (rightNode == -1){
            return -1;
        }

        if (abs(leftNode - rightNode) > 1){
            return -1;
        }
        return max(leftNode, rightNode) + 1;
    }
};