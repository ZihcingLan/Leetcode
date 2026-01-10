/*
Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.

Example 1:
Input: nums = [3,0,1]
Output: 2
Explanation:
n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.

Example 2:
Input: nums = [0,1]
Output: 2
Explanation:
n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.

Example 3:
Input: nums = [9,6,4,2,3,5,7,0,1]
Output: 8
Explanation:
n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.

Constraints:
n == nums.length
1 <= n <= 104
0 <= nums[i] <= n
All the numbers of nums are unique. 
*/

/*
Solution1:
Time:O(2n) = O(n) -> Create a set O(n) + for loop O(n)
Space:O(n) = Create a set
*/

class Solution {
public:
    int missingNumber(vector<int>& nums) {
        int n = nums.size();
        std::unordered_set<int> numsSet(nums.begin(), nums.end());
        for (int i = 0; i <= n; i++){
            if (!numsSet.count(i)){
                return i;
            }
        }
        return -1;
    }
};

/*
Solution2: Sum up all elements and subtrate from all
Time: O(n)
Space: O(1)
*/

class Solution {
public:
    int missingNumber(vector<int>& nums) {
        int n = nums.size();
        long long expect = (n + 1) * n / 2;
        long long actual = 0;
        for (int num : nums){
            actual += num;
        }    
        return expect - actual;
    }
};

/*
Solution3: XOR
Time: O(n)
Space: O(1)
*/

class Solution {
public:
    int missingNumber(vector<int>& nums) {
        int n = nums.size();
        int ans = n; //last elements in nums is nums[n-1] 
        for (int i = 0; i < n; i++){
            ans ^= i ^ nums[i];
        }
        return ans; 
    }
};