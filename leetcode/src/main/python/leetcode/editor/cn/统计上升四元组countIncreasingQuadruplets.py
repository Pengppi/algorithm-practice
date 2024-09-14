"""
Title: 2552.统计上升四元组
Title Slug: countIncreasingQuadruplets
Author: Neo
Date: 2024-09-10 12:37:54
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def countQuadruplets(self, nums: List[int]) -> int:
        n = len(nums)
        ans = 0
        gt = [0] * n
        gt[-1] = [0] * (n + 1)
        for k in range(n - 2, 1, -1):
            gt[k] = gt[k + 1][:]
            for x in range(1, nums[k + 1]):
                gt[k][x] += 1

        le = [0] * (n + 1)
        for j in range(1, n - 1):
            for x in range(nums[j - 1] + 1, n + 1):
                le[x] += 1
            for k in range(j + 1, n - 1):
                if nums[j] > nums[k]:
                    ans += le[nums[k]] * gt[k][nums[j]]
        return ans

# leetcode submit region end(Prohibit modification and deletion)
