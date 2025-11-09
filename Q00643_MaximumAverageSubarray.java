/*
You are given an integer array nums consisting of n elements, and an integer k.

Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.

 

Example 1:

Input: nums = [1,12,-5,-6,50,3], k = 4
Output: 12.75000
Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
Example 2:

Input: nums = [5], k = 1
Output: 5.00000
 

Constraints:

n == nums.length
1 <= k <= n <= 105
-104 <= nums[i] <= 104
 */

//時間複雜度是 O(n) -> O(k+(n-K))，空間複雜度是 O(1) ->只儲存常數

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        if (nums == null){
            return 0;
        }
        if (nums.length == 1){
            return nums[0];
        }
        int left = 0;
        double sum = 0;
        for (int right = 0; right < k; right++){
            sum += nums[right];
        }
        double avg = sum / k;
        // System.out.println(sum);
        // System.out.println(avg);
        double temp_avg = avg;
        for (int right = k; right < nums.length; right++){
            sum = sum - nums[left] + nums[right];
            left++;

            // System.out.println("sum: " + sum);

            avg = sum / k;
            // System.out.println(avg);

            if (avg > temp_avg){
                temp_avg = avg;
            }
        }
        return temp_avg;
    }
}

/*Note:
avg可以在sum比較完之後再除就好。

 */