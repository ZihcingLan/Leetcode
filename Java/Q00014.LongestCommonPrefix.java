/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

 

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 

Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters if it is non-empty.
 */

class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder ans = new StringBuilder();
        boolean isPrefix = true;

        for (int i = 0; i < strs[0].length() && isPrefix; i++){
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++){
                if (i >= strs[j].length() || strs[j].charAt(i) != c){
                    isPrefix = false;
                }
            }
            if (isPrefix){
                ans.append(strs[0].charAt(i));
            }
        }
        return ans.toString();
    }
}