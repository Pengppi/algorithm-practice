"""
Title: 143.重排链表
Title Slug: reorderList
Author: Neo
Date: 2024-09-29 14:20:36
"""
from collections import deque
from typing import Optional

from leetcode.entity import ListNode


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        d = deque()
        while head:
            d.append(head)
            head = head.next
        while d:
            cur = d.popleft()
            next = cur.next
            if not d:
                cur.next = None
                break
            cur.next = d.pop()
            cur = cur.next
            if not d:
                cur.next = None
                break
            cur.next = next

        """
        Do not return anything, modify head in-place instead.
        """
# leetcode submit region end(Prohibit modification and deletion)
