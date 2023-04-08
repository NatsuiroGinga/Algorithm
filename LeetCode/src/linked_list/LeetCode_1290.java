package linked_list;

/**
 * @author ginga
 * @since 26/3/2023 下午5:27
 */
public class LeetCode_1290 {
    public int getDecimalValue(ListNode head) {
        int ans = 0;
        for (; head != null; head = head.next) {
            ans = ans * 2 + head.val;
        }
        return ans;
    }
}
