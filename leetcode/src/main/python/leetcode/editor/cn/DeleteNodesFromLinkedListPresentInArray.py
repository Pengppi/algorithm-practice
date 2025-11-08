"""
Title: 3217.Delete Nodes From Linked List Present in Array
Title Slug: deleteNodesFromLinkedListPresentInArray
Author: Neo
Date: 2025-11-01 21:58:02
"""
from typing import Optional, List

from leetcode.entity import ListNode


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def modifiedList(self, nums: List[int], head: Optional[ListNode]) -> Optional[ListNode]:
        dummy = ListNode(0)
        st = set(nums)
        dummy.next = head
        prev = dummy
        cur = head
        while cur:
            if cur.val in st:
                prev.next = cur.next
            else:
                prev = cur
            cur = cur.next
        return dummy.next

# leetcode submit region end(Prohibit modification and deletion)
