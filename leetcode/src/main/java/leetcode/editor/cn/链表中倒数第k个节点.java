/**
 * @Title: 剑指 Offer 22.链表中倒数第k个节点
 * @TitleSlug: lianBiaoZhongDaoShuDiKgeJieDianLcof
 * @Author: Neo
 * @Date: 2023-05-29 00:33:28
 */
package leetcode.editor.cn;

import java.sql.Array;
import java.util.ArrayDeque;

public class 链表中倒数第k个节点 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 链表中倒数第k个节点().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode getKthFromEnd(ListNode head, int k) {
            Deque<ListNode> d = new ArrayDeque<>();
            ListNode cur = head;
            while (cur != null) {
                d.addLast(cur);
                cur = cur.next;
            }
            if (k > d.size()) {
                return null;
            }
            for (int i = 0; i < k - 1; i++) {
                d.pollLast();
            }
            return d.peekLast();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       