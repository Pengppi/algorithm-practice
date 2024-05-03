"""
Title: 160.相交链表
Title Slug: intersectionOfTwoLinkedLists
Author: Neo
Date: 2024-05-03 00:26:53
"""
from typing import Optional

from leetcode.entity import ListNode


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        cur1, cur2 = headA, headB
        while cur1 != cur2:
            cur1 = cur1.next
            cur2 = cur2.next
            if cur1 == cur2:
                return cur1
            if not cur1:
                cur1 = headB
            if not cur2:
                cur2 = headA
        return cur1
# leetcode submit region end(Prohibit modification and deletion)
