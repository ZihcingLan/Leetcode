/*
Given a string s, reverse only all the vowels in the string and return it.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.

 

Example 1:

Input: s = "IceCreAm"

Output: "AceCreIm"

Explanation:

The vowels in s are ['I', 'e', 'e', 'A']. On reversing the vowels, s becomes "AceCreIm".

Example 2:

Input: s = "leetcode"

Output: "leotcede"

 

Constraints:

1 <= s.length <= 3 * 105
s consist of printable ASCII characters.
 */


class Solution {
    public String reverseVowels(String s) {
        StringBuilder str = new StringBuilder(s);
        int left = 0;
        int right = s.length() - 1;
        String vowels = "aeiouAEIOU";
        while (left < right){
            while (left < right && vowels.indexOf(str.charAt(left)) == -1){
                left++; 
            }
            //有一個left找到的
            while (left < right && vowels.indexOf(str.charAt(right)) == -1){
                right--;
            }
            //也找到一個right且right 固定
            char temp = str.charAt(left);
            str.setCharAt(left, str.charAt(right));
            str.setCharAt(right, temp);
            left++;
            right--;
        }
        return str.toString();
    }
}

/* Note:
也可用char[] arr = s.toCharArray(); 來取代 StringBuilder
最後return String ans = new String(arr);

 */
