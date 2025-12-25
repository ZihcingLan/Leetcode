/*
There are n rooms labeled from 0 to n - 1 and all the rooms are locked except for room 0. Your goal is to visit all the rooms. However, you cannot enter a locked room without having its key.

When you visit a room, you may find a set of distinct keys in it. Each key has a number on it, denoting which room it unlocks, and you can take all of them with you to unlock the other rooms.

Given an array rooms where rooms[i] is the set of keys that you can obtain if you visited room i, return true if you can visit all the rooms, or false otherwise.

 

Example 1:

Input: rooms = [[1],[2],[3],[]]
Output: true
Explanation: 
We visit room 0 and pick up key 1.
We then visit room 1 and pick up key 2.
We then visit room 2 and pick up key 3.
We then visit room 3.
Since we were able to visit every room, we return true.
Example 2:

Input: rooms = [[1,3],[3,0,1],[2],[0]]
Output: false
Explanation: We can not enter room number 2 since the only key that unlocks it is in that room.
 

Constraints:

n == rooms.length
2 <= n <= 1000
0 <= rooms[i].length <= 1000
1 <= sum(rooms[i].length) <= 3000
0 <= rooms[i][j] < n
All the values of rooms[i] are unique.
*/

/*
時間複雜度:O(N+E)->房間的數量n + 鑰匙的總數量e
空間複雜度:O(n) ->boolean[n], DFS遞迴深度最深也是O(n)
*/
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        // 1. 建立一個名單，長度是房間的總數
        boolean[] visited = new boolean[rooms.size()]; 
        
        // 2. 從 "0號房" 開始進行深度探索 (DFS)
        dfs(0, rooms, visited);
        
        // 3. 檢查名單：是不是所有房間都打勾了？
        for (boolean v : visited) {
            if (!v) { // 如果發現有任何一個房間是 false
                return false;
            }
        }
        return true;
    }

    // 這是你的遞迴小幫手
    private void dfs(int currentRoom, List<List<Integer>> rooms, boolean[] visited) {
        // Step A: 既然進來了這個房間，第一件事要在名單上打勾
        visited[currentRoom] = true;
        
        // Step B: 看看這個房間裡有哪些鑰匙 (遍歷 keys)
        for (int key : rooms.get(currentRoom)) {
            
            // Step C: 關鍵判斷！
            // 只有當這個鑰匙通往的房間 "還沒去過" 時，才繼續往下鑽
            if (!visited[key]) {
                dfs(key, rooms, visited); // 遞迴呼叫：拿著鑰匙去下一個房間
            }
        }
    }
}


