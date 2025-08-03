"""
Title: 1290.Convert Binary Number in a Linked List to Integer
Title Slug: convertBinaryNumberInALinkedListToInteger
Author: Neo
Date: 2025-07-14 22:34:38
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
    def getDecimalValue(self, head: Optional[ListNode]) -> int:
        ans = 0
        while head:
            ans = ans * 2 + head.val
            head = head.next
        return ans

# leetcode submit region end(Prohibit modification and deletion)
