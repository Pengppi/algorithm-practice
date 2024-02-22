/**
 * @Title: 21.合并两个有序链表
 * @TitleSlug: mergeTwoSortedLists
 * @Author: Neo
 * @Date: 2024-02-21 23:02:59
 */
package leetcode.editor.cn;

public class 合并两个有序链表 {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 合并两个有序链表().new Solution();
    }
    // leetcode submit region begin(Prohibit modification and deletion)
    
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
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode dummy = new ListNode(-1);
            ListNode cur = dummy;
            while (list1 != null || list2 != null) {
                if (list1 != null && list2 != null) {
                    if (list1.val < list2.val) {
                        cur.next = list1;
                        list1 = list1.next;
                    } else {
                        cur.next = list2;
                        list2 = list2.next;
                    }
                } else if (list1 != null) {
                    cur.next = list1;
                    break;
                } else if (list2 != null) {
                    cur.next = list2;
                    break;
                }
                cur = cur.next;
            }
            return dummy.next;
        }
    }
    
    // leetcode submit region end(Prohibit modification and deletion)
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
        
       