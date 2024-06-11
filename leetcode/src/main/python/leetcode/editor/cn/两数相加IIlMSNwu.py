"""
Title: LCR 025.两数相加 II
Title Slug: lMSNwu
Author: Neo
Date: 2024-06-11 12:29:57
"""
from leetcode.src.main.python.leetcode.entity import ListNode


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        a1, a2 = [], []
        while l1:
            a1.append(l1.val)
            l1 = l1.next
        while l2:
            a2.append(l2.val)
            l2 = l2.next
        i1, i2 = len(a1) - 1, len(a2) - 1
        carry, last = 0, None
        while i1 >= 0 or i2 >= 0:
            if i1 >= 0:
                carry += a1[i1]
                i1 -= 1
            if i2 >= 0:
                carry += a2[i2]
                i2 -= 1
            cur = ListNode(carry % 10, last)
            last = cur
            carry //= 10
        while carry > 0:
            cur = ListNode(carry % 10, last)
            last = cur
            carry //= 10
        return last

# leetcode submit region end(Prohibit modification and deletion)
