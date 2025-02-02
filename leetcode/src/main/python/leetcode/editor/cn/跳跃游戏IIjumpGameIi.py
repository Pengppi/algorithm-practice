"""
Title: 45.跳跃游戏 II
Title Slug: jumpGameIi
Author: Neo
Date: 2025-01-27 09:49:54
"""
from cmath import inf
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def jump(self, nums: List[int]) -> int:
        n = len(nums)
        maxJump = 0
        end = 0
        ans = 0
        for i in range(n - 1):
            maxJump = max(maxJump, i + nums[i])
            if i == end:
                ans += 1
                end = maxJump

        return ans

# leetcode submit region end(Prohibit modification and deletion)
