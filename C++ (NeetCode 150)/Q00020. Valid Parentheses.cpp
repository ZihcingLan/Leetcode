/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 

Example 1:

Input: s = "()"

Output: true

Example 2:

Input: s = "()[]{}"

Output: true

Example 3:

Input: s = "(]"

Output: false

Example 4:

Input: s = "([])"

Output: true

Example 5:

Input: s = "([)]"

Output: false

 

Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
*/

/*
Solution: Map + Stack
時間複雜度:O(n) -> 一定要從頭到尾遍例一次
空間複雜度:O(n) -> 在最差的情況下（例如輸入字串全是左括號 "((((("），Stack 會存入所有字元。Map 雖然佔用空間，但它只存了 3 組固定的括號對。
*/

#include <iostream>
#include <unordered_map>
#include <stack>
#include <string>

class Solution {
public:
    bool isValid(string s) {

        std::unordered_map<char, char> map = {
            {')', '('},
            {']', '['},
            {'}', '{'}
        };
        //C++ 11 可以用emplace(K, V)，直接在記憶體空間構造元素，重複的key會直接忽略，但不可使用在初始化，適合用在執行中途要加一筆新資料

        std::stack<char> stack;

        for (char c : s){
            if (map.count(c)){ //map中有沒有c這個key
                char topElement = stack.empty() ? '#' : stack.top(); 
                //top是負責查看，#是哨兵值 (Sentinel Value)，代表目前沒東西可配對

                if (topElement == map[c]){
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.empty();
    }
};

/*
類似寫法，差在上面用inline，這版用更好讀的if else條件
*/
#include <iostream>
#include <unordered_map>
#include <stack>
#include <string>

class Solution {
public:
    bool isValid(string s) {

        std::unordered_map<char, char> map = {
            {')', '('},
            {']', '['},
            {'}', '{'}
        };
 
        std::stack<char> stack;

        for (char c : s){
            if (map.count(c) == 0){ //0=false -> left parentheses
                stack.push(c);
            } else if (!stack.empty() && map[c] == stack.top()){  //right paretheses
                stack.pop();
            } else {
                return false;
            }
        }

        return stack.empty();   
    }
};