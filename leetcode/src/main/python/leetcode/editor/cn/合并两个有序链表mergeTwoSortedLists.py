"""
Title: 21.合并两个有序链表
Title Slug: mergeTwoSortedLists
Author: Neo
Date: 2024-05-02 23:26:34
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
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        if list1 and list2:
            if list1.val <= list2.val:
                list1.next = self.mergeTwoLists(list1.next, list2)
                return list1
            else:
                return self.mergeTwoLists(list2, list1)
        elif list1:
            return list1
        elif list2:
            return list2
        else:
            return None

# leetcode submit region end(Prohibit modification and deletion)
