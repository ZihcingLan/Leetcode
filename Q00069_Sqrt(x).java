/*
Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.

You must not use any built-in exponent function or operator.

For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
 

Example 1:

Input: x = 4
Output: 2
Explanation: The square root of 4 is 2, so we return 2.
Example 2:

Input: x = 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.
 

Constraints:

0 <= x <= 231 - 1
 */

/*
// 時間複雜度:O(log n) -> 二分搜尋法 (Binary Search) 的特性就是「每次迴圈都把搜尋範圍砍半。e.g. x = 2^31，最多跑31次。
空間複雜度: O(1) -> 指使用固定的變數left, right, mid。
解題:題目是要向下取整取最接近平方根的整數，因此用二分法的方式去逼近最接近但不超過的整數。
 */

class Solution {
    public int mySqrt(int x) {
        //binary search
        if (x == 0){
            return 0;
        }
        int left = 1;
        int right = x;
        while (left <= right){
            // Calculate mid. This prevents potential overflow from (left + right).
            int mid = left + (right - left) / 2; 
            if (mid == x / mid){ //rounded down
                return mid;
            } else if (mid < x / mid){
                left = mid + 1;
            } else if (mid > x / mid){
                right = mid - 1;
            }
        }
        return right; //right larger than x but the nearest value 
    }
}