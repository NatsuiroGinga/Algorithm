//Given a linked list, swap every two adjacent nodes and return its head. You 
//must solve the problem without modifying the values in the list's nodes (i.e., 
//only nodes themselves may be changed.) 
//
// 
// Example 1: 
// 
// 
//Input: head = [1,2,3,4]
//Output: [2,1,4,3]
// 
//
// Example 2: 
//
// 
//Input: head = []
//Output: []
// 
//
// Example 3: 
//
// 
//Input: head = [1]
//Output: [1]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range [0, 100]. 
// 0 <= Node.val <= 100 
// 
//
// Related Topics Linked List Recursion 👍 10771 👎 391


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(-1, head);
        ListNode cur = dummyHead;

        // 链表有奇数个结点，cur.next == null
        // 链表有偶数个结点, cur.next.next == null
        // cur -> node 1 -> node 2 -> node 3
        while (cur.next != null && cur.next.next != null) {
            ListNode node1 = cur.next, node3 = cur.next.next.next;
            cur.next = node1.next; // cur -> node2
            cur.next.next = node1; // node2 -> node1
            node1.next = node3; // node1 -> node3
            // 当前 cur -> node2 -> node1 -> node3
            cur = cur.next.next;
        }

        return dummyHead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
