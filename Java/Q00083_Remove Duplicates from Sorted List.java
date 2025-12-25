/*Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.

Example 1:

Input: head = [1,1,2]
Output: [1,2]
Example 2:

Input: head = [1,1,2,3,3]
Output: [1,2,3]
 
Constraints:

The number of nodes in the list is in the range [0, 300].
-100 <= Node.val <= 100
The list is guaranteed to be sorted in ascending order.
*/

/*
時間複雜度: O(n) -> 需遍歷所有的node
空間複雜度: O(1) -> 只用了 p 和 next 這兩個變數，所以是常數空間。
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null){
            return null;
        }

        ListNode p = head;
        while (p != null && p.next != null){
            ListNode next = p.next;
            if (p.val == next.val){
                next = next.next;
                p.next = next;
            } else {
                p = p.next;
            }
        }
        return head;
    }
}