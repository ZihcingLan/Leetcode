/*You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

list_a: 1->2->4
list_b: 1->3->4
combine: 1->1->2->3->4->4
         b  a  a  b  a  b

Example 1:

Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
Example 2:

Input: list1 = [], list2 = []
Output: []
Example 3:

Input: list1 = [], list2 = [0]
Output: [0]
 

Constraints:

The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both list1 and list2 are sorted in non-decreasing order.
*/

/*
Solution: Dummy Node 可以當一個開頭，從dummy.next開始接答案 是 Linked List 題目的「萬用解」，它能幫你自動處理掉各種「空陣列」或「邊界情況」。
Time:O(m+n) -> Go through all nodes in List1 and List2.
Space: O(1) -> No new nodes is created.

*/

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */

#include <iostream>
 
class Solution {
public:
    ListNode* mergeTwoLists(ListNode* list1, ListNode* list2) {

        ListNode dummy(0);  //Create dummy node on the stack.
        ListNode* tail = &dummy; //Use tail to keep track of the current end

        while (list1 != nullptr && list2 != nullptr){  //Attach new nodes to tail->next
            if (list1->val <= list2->val){
                tail->next = list1;
                list1 = list1->next;
            } else {
                tail->next = list2;
                list2 = list2->next;
            }
                tail=tail->next;
        }

        if (list1 != nullptr){
            tail->next = list1;
        } else {
            tail->next = list2;
        }
        return dummy.next; //dummy.next is the actual start of the list
    }
};