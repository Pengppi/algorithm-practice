/**
 * @Title: 82.删除排序链表中的重复元素 II
 * @TitleSlug: removeDuplicatesFromSortedListIi
 * @Author: Neo
 * @Date: 2024-01-15 09:12:46
 */
package leetcode.editor.cn;

public class 删除排序链表中的重复元素II {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 删除排序链表中的重复元素II().new Solution();
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
            ListNode dummy = new ListNode(-1000, head);
            ListNode cur = dummy;
            while (cur != null && cur.next != null) {
                ListNode p = cur.next;
                while (p != null && p.next != null && p.val == p.next.val) {
                    ListNode q = p.next.next;
                    while (q != null && q.val == p.val) {
                        q = q.next;
                    }
                    p = q;
                }
                cur.next = p;
                cur = cur.next;
            }

            return dummy.next;
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
        
       