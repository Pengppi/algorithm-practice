/**
 * @Title: 剑指 Offer 18.删除链表的节点
 * @TitleSlug: shanChuLianBiaoDeJieDianLcof
 * @Author: Neo
 * @Date: 2023-05-01 15:00:54
 */
package leetcode.editor.cn;

public class 删除链表的节点 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 删除链表的节点().new Solution();
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
        public ListNode deleteNode(ListNode head, int val) {
            if (head.val == val) {
                return head.next;
            }
            ListNode p = head;
            ListNode q = p.next;
            while (q != null) {
                if (q.val == val) {
                    p.next = q.next;
                    break;
                }
                q = q.next;
                p = p.next;
            }
            return head;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
        
       