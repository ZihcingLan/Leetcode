/*
You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

 

Example 1:


Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:

Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Example 3:

Input: grid = [[0,2]]
Output: 0
Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 10
grid[i][j] is 0, 1, or 2.
*/

/*
Solution: BFS
Time: O(mxn) -> IWe traverse the whole grid during initialization and each cell is visited at most once during BFS.
Space: O(mxn) -> In the worst case, all oranges are rotten at the same time, the queue can store up to m x n elements.
*/

class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        //1. 先看有沒有no rotten return 0
        int rows = grid.size();
        int cols = grid[0].size();
        int freshOrange = 0;
        queue<pair<int, int>> q;
        for (int r = 0; r < rows; r++){
            for (int c = 0; c < cols; c++){
                if (grid[r][c] == 2){
                    q.push({r, c});
                } else if (grid[r][c] == 1){
                    freshOrange++;
                }
            }
        }
        if (freshOrange == 0){
            return 0;
        }

        vector<pair<int, int>> dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int min = 0;
        while (q.size() != 0 && freshOrange > 0){
            min++;
            int size = q.size();
            for (int i = 0; i < size; i++){
                auto [curR, curC] = q.front();
                q.pop();
                for (auto [dr, dc] : dirs){
                    int nextR = curR + dr;
                    int nextC = curC + dc;
                    if (nextR >= 0 && nextR < rows && nextC >= 0 && nextC < cols && grid[nextR][nextC] == 1){
                        grid[nextR][nextC] = 2;
                        q.push({nextR, nextC});
                        freshOrange--;
                    }
                }
            }
        }
        //2. 有無法抵達的return -1
        return  (freshOrange == 0) ? min : -1;

    }
};