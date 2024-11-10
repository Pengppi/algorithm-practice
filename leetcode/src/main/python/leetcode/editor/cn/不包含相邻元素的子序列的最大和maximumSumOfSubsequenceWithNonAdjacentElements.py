"""
Title: 3165.不包含相邻元素的子序列的最大和
Title Slug: maximumSumOfSubsequenceWithNonAdjacentElements
Author: Neo
Date: 2024-10-31 12:51:12
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maximumSumSubsequence(self, nums: List[int], queries: List[List[int]]) -> int:
        mod = 10 ** 9 + 7
        n = len(nums)
        t = [[0] * 4 for _ in range(2 << n.bit_length())]

        def pushDown(o, l, r):
            if l == r:
                t[o][3] = max(nums[l], 0)
                return
            m = (l + r) // 2
            pushDown(o * 2, l, m)
            pushDown(o * 2 + 1, m + 1, r)
            pushUp(o)

        def pushUp(o):
            l, r = t[o * 2], t[o * 2 + 1],
            t[o][0] = max(l[0] + r[2], l[1] + r[0])
            t[o][1] = max(l[0] + r[3], l[1] + r[1])
            t[o][2] = max(l[2] + r[2], l[3] + r[0])
            t[o][3] = max(l[2] + r[3], l[3] + r[1])

        def update(o, l, r, i, val):
            if l == r:
                t[o][3] = max(val, 0)
                return

            m = (l + r) // 2
            if i <= m:
                update(o * 2, l, m, i, val)
            else:
                update(o * 2 + 1, m + 1, r, i, val)
            pushUp(o)

        pushDown(1, 0, n - 1)
        ans = 0
        for i, x in queries:
            update(1, 0, n - 1, i, x)
            ans += t[1][3]
            ans %= mod
        return ans
# leetcode submit region end(Prohibit modification and deletion)
