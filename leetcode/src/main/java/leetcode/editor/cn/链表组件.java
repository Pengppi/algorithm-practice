/**
 * @Title: 817.链表组件
 * @TitleSlug: LinkedListComponents
 * @Author: Neo
 * @Date: 2022-10-12 19:19:28
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class 链表组件 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 链表组件().new Solution();
    }

//力扣代码
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
        public int numComponents(ListNode head, int[] nums) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            int cnt = 0;
            int ans = 0;
            ListNode cur = head;
            while (cur != null) {
                if (list.contains(cur.val)) {
                    cnt++;
                    while (cur != null && list.contains(cur.val)) {
                        cur = cur.next;
                    }
                    if (cur == null) {
                        break;
                    }
                }
                cur = cur.next;
            }
            return cnt;
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
