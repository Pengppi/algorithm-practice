/**
 * @Title: 剑指 Offer 06.从尾到头打印链表
 * @TitleSlug: congWeiDaoTouDaYinLianBiaoLcof
 * @Author: Neo
 * @Date: 2023-05-27 16:03:47
 */
package leetcode.editor.cn;

public class 从尾到头打印链表 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 从尾到头打印链表().new Solution();
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
        public int[] reversePrint(ListNode head) {
            ListNode pre = null;
            ListNode cur = head;

            int size = 0;
            while (cur != null) {
                size++;
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            cur = pre;
            int[] ans = new int[size];
            int i = 0;
            while (cur != null) {
                ans[i++] = cur.val;
                cur = cur.next;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       