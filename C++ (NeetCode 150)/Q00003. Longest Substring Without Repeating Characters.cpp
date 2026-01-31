/*
Given a string s, find the length of the longest substring without duplicate characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
*/


/*
Solution 1: Window slide. Use left and right pointer to count the number of elements. When the element has showed up, left pointer jumps to that location as the start of a new sum.
Time: O(n) -> Walk through
Space: O(1) -> Create a 128 bits space only.
*/
#include <math.h>
#include <ostream>
#include <vector>
#include <string>

class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int maxLength = 0;
        int left = 0;
        std::vector<char> lastS(128, -1);
        for (int right = 0; right < s.size(); right++){
            char cur = s[right]; //a
            if (lastS[cur] >= left){
                left = lastS[cur] + 1;
            }
            lastS[cur] = right;
            maxLength = std::max(maxLength, right - left + 1);
        }    
        return maxLength;
    }
};


/*
Solution 2: unordered set. When the duplicate char appears, use while loop to remove all elements before the current char, and update the left index to the current position.
Time: O(n) -> Each element is inserted and erased at most once, resulting in O(2n) which simplfies to O(n).
Space: O(k) -> The set stores at most all unique characters present in the current window."
*/

class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        std::unordered_set<char> set;
        int maxLength = 0;
        int left = 0;
        for (int right = 0; right < s.size(); right++){
            if (set.count(s[right]) == 0){
                set.insert(s[right]);
                maxLength = std::max(maxLength, right - left + 1);
            } else {
                while (set.count(s[right]) != 0){
                    set.erase(s[left]); //remove the leftmost element
                    left++; 
                }
                set.insert(s[right]);
            }
        }
        return maxLength;
    }
};

/*
Solution 3: unordered_map.
Time: O(n) -> Scan from o to n-1
Space: O(k) -> The map stores at most all unique character present in the current window.
*/

class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        std::unordered_map<char, int> map;
        int maxLength = 0;
        int left = 0;
        for (int right = 0; right < s.size(); right++){
            if (map.count(s[right]) == 0 || map[s[right]] < left){ //s[right] is on the left of left
                map[s[right]] = right;
                maxLength = std::max(maxLength, right - left + 1);
            } else {
                left = map[s[right]] + 1;
                map[s[right]] = right;
            }
        }
        return maxLength;
    }
};

practice**