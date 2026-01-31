/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

 

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]
 

Constraints:

2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.
*/

/*
Method 1: Use unordered map
時間複雜度:O(n) -> 只需要遍歷陣列一次。雖然 unordered_map 的搜尋有成本，但其平均搜尋速度是 O(1)。
空間複雜度:O(n) -> 最壞的情況下（答案在最後一對），我們需要把陣列中幾乎所有的數字都存進 Map 裡，佔用的空間與 n 成正比。
*/
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> map;

        for (int i = 0; i < nums.size(); i++){
            int complement = target - nums[i];
            if (map.find(complement) != map.end()){
                return {map[complement], i};
            }
            map[nums[i]] = i;
        }
        return {};
    }
};

/*
Method 2: Brute Force
時間複雜度:O(n^2) -> 雙重迴圈，外層執行n次，內層平均執行n/2次，總運算次數與n的平方成正比。
空間複雜度:O(1) -> 僅新增常數函數，除了存入結果的空間外，沒有使用額外的資料結構來儲存資料，只用了幾個變數。
*/

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        for (int i = 0; i < nums.size() - 1; i++){
            for (int j = i + 1; j < nums.size(); j++){ //注意要從i+1開始才不會重複算到自己
                if (nums[i] + nums[j] == target){
                    return {i, j};
                }
            }
        }
        return {};
    }
};

Practice: ***