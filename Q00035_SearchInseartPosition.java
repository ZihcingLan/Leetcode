/*
Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [1,3,5,6], target = 5
Output: 2
Example 2:

Input: nums = [1,3,5,6], target = 2
Output: 1
Example 3:

Input: nums = [1,3,5,6], target = 7
Output: 4
 

Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums contains distinct values sorted in ascending order.
-104 <= target <= 104
*/

/*
時間複雜度：O(n) -> 最差每個idx都會跑一遍
空間複雜度：O(1) -> 沒有額外的空間使用
＊/

class Solution {
    public int searchInsert(int[] nums, int target) {
        int idx = 0;
        while (idx < nums.length){
            if (target <= nums[idx]){
                return idx;
            } else {
                idx++;
            }    
        }
        return idx;
    }
}
  
