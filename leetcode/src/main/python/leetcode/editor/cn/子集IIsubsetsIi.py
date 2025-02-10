"""
Title: 90.子集 II
Title Slug: subsetsIi
Author: Neo
Date: 2025-02-05 12:44:47
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        n = len(nums)
        ans = []
        path = []

        def dfs(x):
            if x == n:
                ans.append(path[:])
                return
            path.append(nums[x])
            dfs(x + 1)
            path.pop()

            x += 1
            while x < n and nums[x] == nums[x - 1]:
                x += 1
            dfs(x)

        dfs(0)
        return ans

    # leetcode submit region end(Prohibit modification and deletion)
