/*
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

 

Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
Example 3:

Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.
 

Constraints:

1 <= s.length <= 2 * 105
s consists only of printable ASCII characters.
*/

/*
Solution: Remember how to use erase and remove_if functions
Time: O(n) -> remove_if traverses the string once O(n) + walk through string s to lowercase once O(n) + two pointers compares form the left and right until they exceed the middle(1/2 n)
Space: O(1) -> modifying the input string s in-place, no extra space created.
*/

#include <iostream>
#include <string>
#include <algorithm>
#include <cctype>

using namespace std;

class Solution {
public:
    bool isPalindrome(string s) {
        //1. clean
        s.erase(remove_if(s.begin(), s.end(), [](unsigned char c){ 
            //isalonum只能接受unsigned int, 只寫char會包含特殊符號
            return !isalnum(c);
        }), s.end());
        //2. convert every alphbet to the lowercase
        for(char &c : s){
            c = tolower(c);
        }

        //3. two pointers 
        int left = 0;
        int right = s.length() - 1;
        while (left < right){
            if (s[left] != s[right]){
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
};