/*
Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

 

Example 1:

Input: nums = [1,2,3,1]

Output: true

Explanation:

The element 1 occurs at the indices 0 and 3.

Example 2:

Input: nums = [1,2,3,4]

Output: false

Explanation:

All elements are distinct.

Example 3:

Input: nums = [1,1,1,3,3,4,3,2,4,2]

Output: true

 

Constraints:

1 <= nums.length <= 105
-109 <= nums[i] <= 109
*/


/*
Solution: Use Map to count the duplicate
Time: O(n) -> The worst case will walk through the whole array.
Space: O(n) -> The worst case will walk through the whole array.
*/

#include <iostream>
#include <unordered_map>

class Solution {
public:
    bool containsDuplicate(vector<int>& nums) {
        std::unordered_map<int,int> map;
        for(int i : nums){
            map[i]++;
            if (map[i] >= 2){
                return true;
            }
        }
        return false;
    }
};

/*
Second try: Use set
Time: O(n);
Space: O(n);
*/

class Solution {
public:
    bool containsDuplicate(vector<int>& nums) {
        std::unordered_set<int> seen;
        for (int i : nums){
            if (seen.count(i) == true){
                return true;
            }
            seen.insert(i);
        }
        return false;
    }
};


