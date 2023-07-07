/**
 * @Title: 1019.链表中的下一个更大节点
 * @TitleSlug: nextGreaterNodeInLinkedList
 * @Author: Neo
 * @Date: 2023-04-10 13:27:21
 */
package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Arrays;

public class 链表中的下一个更大节点 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 链表中的下一个更大节点().new Solution();
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

    class Solution {
        public int[] nextLargerNodes(ListNode head) {
            Deque<int[]> d = new ArrayDeque<>();
            int i = 0;
            ListNode cur = head;
            int[] a = new int[10005];
            while (cur != null) {
                while (!d.isEmpty() && cur.val > d.peekLast()[0]) {
                    int idx = d.pollLast()[1];
                    a[idx] = cur.val;
                }
                d.addLast(new int[]{cur.val, i});
                i++;
                cur = cur.next;
            }
            return Arrays.copyOf(a, i);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}
