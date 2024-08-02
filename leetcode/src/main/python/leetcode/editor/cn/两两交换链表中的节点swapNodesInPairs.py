"""
Title: 24.两两交换链表中的节点
Title Slug: swapNodesInPairs
Author: Neo
Date: 2024-07-31 13:34:50
"""
from typing import Optional

from leetcode.entity import ListNode


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def swapPairs(self, head: Optional[ListNode]) -> Optional[ListNode]:
        dummy = ListNode(-1, head)
        cur = dummy
        while cur.next and cur.next.next:
            p = cur.next
            q = p.next
            nxt = q.next
            cur.next = q
            q.next = p
            p.next = nxt
            cur = p
        return dummy.next
# leetcode submit region end(Prohibit modification and deletion)
