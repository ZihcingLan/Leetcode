/*
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
You must implement a solution with a linear runtime complexity and use only constant extra space.

Example 1:
Input: nums = [2,2,1]
Output: 1

Example 2:
Input: nums = [4,1,2,1,2]
Output: 4

Example 3:
Input: nums = [1]
Output: 1

Constraints:

1 <= nums.length <= 3 * 104
-3 * 104 <= nums[i] <= 3 * 104
Each element in the array appears twice except for one element which appears only once.
*/

/*
First Try: Not fullfil the requirement -> Time:O(n), Space:O(1);
Solution: Store counts and erase pairs. Use map to record and remove keys when it counts 2 times. But this only works for the limitation of how many times elements apear.
Time: O(n)
Space: O(n) -> Create a map
*/

class Solution {
public:
    int singleNumber(vector<int>& nums) {
        std::unordered_map<int, int> map;
        for (int i : nums){
            map[i] = map[i] + 1;
            if (map[i] > 1){
                map.erase(i);
            }
        }
        return map.begin()->first;
    }
};

/*
Second try: achieve!
Solution:Use XOR (1^1 = 0, 1^0 = 1, 1^1 = 0)，
Time:O(n) -> You only walk through the list once.
Space:O(1) -> You only store one integer.
*/

class Solution {
public:
    int singleNumber(vector<int>& nums) {
        int ans = 0;
        for (int i : nums){
            ans ^= i;
        }
        return ans;
    }
};

Complete:**