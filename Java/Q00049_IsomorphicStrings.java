/*
Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

 

Example 1:

Input: s = "egg", t = "add"

Output: true

Explanation:

The strings s and t can be made identical by:

Mapping 'e' to 'a'.
Mapping 'g' to 'd'.
Example 2:

Input: s = "foo", t = "bar"

Output: false

Explanation:

The strings s and t can not be made identical as 'o' needs to be mapped to both 'a' and 'r'.

Example 3:

Input: s = "paper", t = "title"

Output: true

 

Constraints:

1 <= s.length <= 5 * 104
t.length == s.length
s and t consist of any valid ascii character.
 */

/*Time: O(n), Space: O(2n) ≈ O(n) --> Set 用哈希查找 value → O(1)  */
import java.util.*; 
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }

        Map<Character, Character> map = new HashMap<>();
        Set<Character> mapped = new HashSet<>();
        for (int i = 0; i < s.length(); i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (map.containsKey(c1)){
                if (map.get(c1) != c2){
                    return false;
                }                
            } else {
                if (mapped.contains(c2)){
                    return false;
                } else {
                    map.put(c1, c2);
                    mapped.add(c2);
                }
            }
        }
        return true;
    }
}

/*
 Note:
只用一個Map的版本: Time:O(n²), Space:O(n) --> 查 value 要掃整個 map
直接判斷map裡面有沒有containsValue(ch2)，效率較差但空間較少

 class Solution {
    public boolean isIsomorphic(String s, String t) {
       
        HashMap<Character,Character> hm = new HashMap<>();
        int n=s.length();
        for(int i=0;i<n;i++)
        {
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            if(hm.containsKey(ch1))
            {
                if(hm.get(ch1)!=ch2)
                return false;
            }
            else if(hm.containsValue(ch2))
            {
                return false;
            }
            hm.put(ch1,ch2);
            
        }
        return true;
    }
}
 */