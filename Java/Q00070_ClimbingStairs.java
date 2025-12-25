/*
You are climbing a staircase. It takes n steps to reach the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
 
Constraints:

1 <= n <= 45
 */

/*
時間複雜度:O(n) -> 總共執行了n - 2次迭代，和N呈線性關係
空間複雜度:O(1) -> 常數空間
解題:問題轉化為 DP (動態規劃)： 每次只能爬 1 級或 2 級，因此到達第 i 級的方法數，只能來自於前一級 (DP[i-1]) 或前兩級 (DP[i-2])。
 */

class Solution {
    public int climbStairs(int n) {
        //n=1有一種走法，n=2有兩種走法
        if (n <= 2){
            return n;
        }
        int p = 1;  //n=1 -> (i-2)
        int q = 2;  //n=2 -> (i-1)
        int cur = 0;
        for (int i = 3; i <= n; i++){
            cur = p + q;
            p = q;
            q = cur;
        }
        return cur;
    }
}