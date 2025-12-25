/*
Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

 

Example 1:

Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.
Example 2:

Input: haystack = "leetcode", needle = "leeto"
Output: -1
Explanation: "leeto" did not occur in "leetcode", so we return -1.
 

Constraints:

1 <= haystack.length, needle.length <= 104
haystack and needle consist of only lowercase English characters.
 */

import java.util.*;

class Solution {
    public int strStr(String haystack, String needle) {
        char[] s1 = haystack.toCharArray();
        char[] s2 = needle.toCharArray();

        int idx = 0;
        for (int i = 0; i < s1.length; i++){
            if (s1[i] == s2[idx]){
                idx++;
            } else{
                i = i - idx;
                idx = 0;
            }
            if (idx == s2.length){
                return i + 1 - s2.length;
            }
        }
        return -1;
    }
}