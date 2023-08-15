//Design your implementation of the linked list. You can choose to use a singly 
//or doubly linked list. A node in a singly linked list should have two 
//attributes: val and next. val is the value of the current node, and next is a pointer/
//reference to the next node. If you want to use the doubly linked list, you will 
//need one more attribute prev to indicate the previous node in the linked list. 
//Assume all nodes in the linked list are 0-indexed. 
//
// Implement the MyLinkedList class: 
//
// 
// MyLinkedList() Initializes the MyLinkedList object. 
// int get(int index) Get the value of the indexᵗʰ node in the linked list. If 
//the index is invalid, return -1. 
// void addAtHead(int val) Add a node of value val before the first element of 
//the linked list. After the insertion, the new node will be the first node of the 
//linked list. 
// void addAtTail(int val) Append a node of value val as the last element of 
//the linked list. 
// void addAtIndex(int index, int val) Add a node of value val before the indexᵗ
//ʰ node in the linked list. If index equals the length of the linked list, the 
//node will be appended to the end of the linked list. If index is greater than the 
//length, the node will not be inserted. 
// void deleteAtIndex(int index) Delete the indexᵗʰ node in the linked list, if 
//the index is valid. 
// 
//
// 
// Example 1: 
//
// 
//Input
//["MyLinkedList", "addAtHead", "addAtTail", "addAtIndex", "get", 
//"deleteAtIndex", "get"]
//[[], [1], [3], [1, 2], [1], [1], [1]]
//Output
//[null, null, null, null, 2, null, 3]
//
//Explanation
//MyLinkedList myLinkedList = new MyLinkedList();
//myLinkedList.addAtHead(1);
//myLinkedList.addAtTail(3);
//myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
//myLinkedList.get(1);              // return 2
//myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
//myLinkedList.get(1);              // return 3
// 
//
// 
// Constraints: 
//
// 
// 0 <= index, val <= 1000 
// Please do not use the built-in LinkedList library. 
// At most 2000 calls will be made to get, addAtHead, addAtTail, addAtIndex and 
//deleteAtIndex. 
// 
//
// Related Topics Linked List Design 👍 2284 👎 1467


//leetcode submit region begin(Prohibit modification and deletion)
class ListNode {
    int val;
    ListNode next, prev;

    ListNode() {
    }

    ListNode(int val, ListNode prev, ListNode next) {
        this.val = val;
        this.prev = prev;
        this.next = next;
    }

    ListNode(int val) {
        this.val = val;
    }
}

class MyLinkedList {

    private int size;
    private ListNode head, tail;

    public MyLinkedList() {
        this.size = 0;
        this.head = new ListNode();
        this.tail = head;
        this.head.next = tail;
        this.tail.prev = this.head;
    }

    public int get(int index) {
        if (index < 0 || index >= this.size) {
            return -1;
        }

        ListNode cur = this.head;

        if (index >= size / 2) {
            cur = this.tail;
            for (int i = 0; i < size - index; i++) {
                cur = cur.prev;
            }
        } else {
            cur = this.head;
            for (int i = 0; i <= index; i++) {
                cur = cur.next;
            }
        }

        return cur.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(this.size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index > this.size) return;
        if (index < 0) index = 0;

        ListNode pre = this.head;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        ListNode node = new ListNode(val, pre, pre.next);
        pre.next.prev = node;
        pre.next = node;
        this.size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        ListNode pre = this.head;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        pre.next.prev = pre;
        pre.next = pre.next.next;
        this.size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
//leetcode submit region end(Prohibit modification and deletion)
