/*
Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

Can you solve it without sorting?

 

Example 1:

Input: nums = [3,2,1,5,6,4], k = 2
Output: 5
Example 2:

Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4
 

Constraints:

1 <= k <= nums.length <= 105
-104 <= nums[i] <= 104
*/

/*
Solution:Use Quick Selection
Time: O(n) -> iterate
Space: O(1) -> sort the array in-place
*/


class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        //1.From right to left, left-right to find the answer
        //2. swap the needed array to sorted array
        int left = 0;
        int right = nums.size() - 1;
        int kIdx = k - 1; // 0-based
        while (left <= right){
            int pivotIdx = partition(nums, left, right);
            if (pivotIdx == kIdx){
                return nums[pivotIdx];
            } else if (pivotIdx > kIdx){
                right = pivotIdx - 1;
            } else {
                left = pivotIdx + 1;
            }
        }
        return -1;
    }
private:
    int partition(vector<int>& nums, int left, int right){
        int mid = left + (right - left) / 2;
        std::swap(nums[mid], nums[right]); // avoid extreme cases
        int pivot = nums[right];
        int p = left;
        for (int i = left; i < right; i++){
            if (nums[i] > pivot){
                std::swap(nums[i], nums[p]);
                p++;
            }
        }
        std::swap(nums[p], nums[right]);
        return p;
    }
};


/*
Solution 2: minHeap
Time: O(n)
Space: O(k)
*/

class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        std::priority_queue<int, vector<int>, greater<int>> minHeap;
        for (int num : nums){
            minHeap.push(num);
            if (minHeap.size() > k){
                minHeap.pop();
            }
        }
        return minHeap.top();
    }
};

Practice: **