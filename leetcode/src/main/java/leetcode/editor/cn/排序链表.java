/**
 * @Title: 148.排序链表
 * @TitleSlug: sortList
 * @Author: Neo
 * @Date: 2024-01-08 13:31:32
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 排序链表 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 排序链表().new Solution();
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
        public ListNode sortList(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode cur = head;
            List<ListNode> list = new ArrayList<>();
            while (cur != null) {
                list.add(cur);
                cur = cur.next;
            }
            Collections.sort(list, (a, b) -> (a.val - b.val));
            for (int i = 1; i < list.size(); i++) {
                list.get(i - 1).next = list.get(i);
            }
            list.get(list.size() - 1).next = null;
            return list.get(0);
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
        
       