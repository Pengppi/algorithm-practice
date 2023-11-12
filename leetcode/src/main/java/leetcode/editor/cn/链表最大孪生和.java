/**
 * @Title: 2130.链表最大孪生和
 * @TitleSlug: maximumTwinSumOfALinkedList
 * @Author: Neo
 * @Date: 2023-11-12 12:47:07
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class 链表最大孪生和 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 链表最大孪生和().new Solution();
    }

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
        public int pairSum(ListNode head) {
            List<Integer> list = new ArrayList<>();
            ListNode cur = head;
            while (cur != null) {
                list.add(cur.val);
                cur = cur.next;
            }
            int l = 0, r = list.size() - 1;
            int ans = 0;
            while (l < r) {
                ans = Math.max(ans, list.get(l) + list.get(r));
                l++;
                r--;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       