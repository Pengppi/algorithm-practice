"""
Title: 2181.合并零之间的节点
Title Slug: mergeNodesInBetweenZeros
Author: Neo
Date: 2024-09-09 12:27:57
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
    def mergeNodes(self, head: Optional[ListNode]) -> Optional[ListNode]:
        dummy = ListNode()
        last = dummy
        s = 0
        head = head.next
        while head:
            if head.val == 0:
                last.next = ListNode(s)
                last = last.next
                s = 0
            else:
                s += head.val
            head = head.next
        return dummy.next

# leetcode submit region end(Prohibit modification and deletion)
