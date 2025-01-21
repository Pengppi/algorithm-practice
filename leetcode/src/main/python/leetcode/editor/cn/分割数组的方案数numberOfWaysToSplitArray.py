"""
Title: 2270.分割数组的方案数
Title Slug: numberOfWaysToSplitArray
Author: Neo
Date: 2025-01-13 13:13:44
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def waysToSplitArray(self, nums: List[int]) -> int:
        tot = sum(nums)
        ans = s = 0
        for i in range(len(nums) - 1):
            s += nums[i]
            if s * 2 >= tot:
                ans += 1
        return ans

# leetcode submit region end(Prohibit modification and deletion)
