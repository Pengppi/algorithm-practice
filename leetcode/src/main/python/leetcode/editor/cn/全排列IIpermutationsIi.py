"""
Title: 47.全排列 II
Title Slug: permutationsIi
Author: Neo
Date: 2025-02-06 13:12:38
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        n = len(nums)
        ans = []
        vis = [False] * n

        def dfs(path):
            if len(path) == n:
                ans.append(path[:])
                return
            for i in range(n):
                if vis[i]:
                    continue
                if i > 0 and nums[i] == nums[i - 1] and not vis[i - 1]:
                    continue
                vis[i] = True
                path.append(nums[i])
                dfs(path)
                path.pop()
                vis[i] = False

        dfs([])
        return ans
# leetcode submit region end(Prohibit modification and deletion)
