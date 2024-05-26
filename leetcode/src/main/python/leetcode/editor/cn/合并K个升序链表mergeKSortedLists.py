"""
Title: 23.合并 K 个升序链表
Title Slug: mergeKSortedLists
Author: Neo
Date: 2024-05-26 13:38:15
"""
import heapq
from heapq import heapify
from math import inf
from typing import List, Optional

from leetcode.entity import ListNode

# leetcode submit region begin(Prohibit modification and deletion)
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next


class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        ListNode.__lt__ = lambda a, b: a.val < b.val
        cur = dummy = ListNode()
        h = [head for head in lists if head]
        heapq.heapify(h)
        while h:
            p = heapq.heappop(h)
            if p.next:
                heapq.heappush(h, p.next)
            cur.next = ListNode(p.val)
            cur = cur.next
        return dummy.next

# leetcode submit region end(Prohibit modification and deletion)
