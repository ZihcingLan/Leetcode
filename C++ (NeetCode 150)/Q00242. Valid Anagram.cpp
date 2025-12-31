/*
Given two strings s and t, return true if t is an anagram of s, and false otherwise.

Example 1:
Input: s = "anagram", t = "nagaram"
Output: true

Example 2:
Input: s = "rat", t = "car"
Output: false

Constraints:
1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.
*/

/*
Solution: Check the length of both strings. Counts char in s. Decrement counts using t
Time: O(n) -> Counts char in s O(n) + Check t O(n).
Space: O(26) → O(1) -> If two input strings are consisted of lowercase alpahbet characters. Create an map with 26 characters at most.
*/

#include <iostream>
#include <string>
#include <unordered_map>

using namespace std; //Tell compiler to look into std library automatically if it doesn't recognize a name.

class Solution {
public:
    bool isAnagram(string s, string t) {
        if (s.length() != t.length()){
            return false;
        }
        unordered_map<char, int> map;
        for (char c : s){
            map[c] = map[c] + 1;
        }

        for (char c : t){
            if (map[c] == 0){
                return false;
            }
            map[c]--;
        }

        return true;
    }
};