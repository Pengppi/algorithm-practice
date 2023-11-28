/**
 * @Title: 142.环形链表 II
 * @TitleSlug: linkedListCycleIi
 * @Author: Neo
 * @Date: 2023-11-27 21:28:09
 */
package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class 环形链表II {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 环形链表II().new Solution();
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            Set<ListNode> set = new HashSet<>();
            while (head != null) {
                if (set.contains(head)) {
                    return head;
                }
                set.add(head);
                head = head.next;
            }
            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       