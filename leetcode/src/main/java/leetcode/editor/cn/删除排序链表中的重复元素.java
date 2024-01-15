/**
 * @Title: 83.删除排序链表中的重复元素
 * @TitleSlug: removeDuplicatesFromSortedList
 * @Author: Neo
 * @Date: 2024-01-14 11:20:12
 */
package leetcode.editor.cn;

public class 删除排序链表中的重复元素 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 删除排序链表中的重复元素().new Solution();
    }
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
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null) {
                return null;
            }
            var p = head;
            var q = head.next;
            while (q != null) {
                while (q != null && p.val == q.val) {
                    q = q.next;
                }
                if (q == null) {
                    p.next = null;
                } else {
                    p.next = q;
                    q = q.next;
                    p = p.next;
                }
            }
            return head;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
        
       