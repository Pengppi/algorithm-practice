"""
Title: 368.最大整除子集
Title Slug: largestDivisibleSubset
Author: Neo
Date: 2025-04-06 11:16:01
"""
from functools import cache
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def largestDivisibleSubset(self, nums: List[int]) -> List[int]:
        n = len(nums)
        nums.sort()

        frm = [-1] * n

        @cache
        def dfs(i):
            res = 0
            for j in range(i):
                if nums[i] % nums[j]:
                    continue
                f = dfs(j)
                if f > res:
                    res = f
                    frm[i] = j

            return res + 1

        mx_f = 0
        mx_i = 0
        for i in range(n):
            f = dfs(i)
            if f > mx_f:
                mx_f = f
                mx_i = i

        ans = []
        i = mx_i
        while i != -1:
            ans.append(nums[i])
            i = frm[i]

        return ans
# leetcode submit region end(Prohibit modification and deletion)
