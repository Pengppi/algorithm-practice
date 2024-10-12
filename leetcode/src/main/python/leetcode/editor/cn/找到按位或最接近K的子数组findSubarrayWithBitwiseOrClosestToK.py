"""
Title: 3171.找到按位或最接近 K 的子数组
Title Slug: findSubarrayWithBitwiseOrClosestToK
Author: Neo
Date: 2024-10-09 12:09:22
"""
from cmath import inf
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minimumDifference(self, nums: List[int], k: int) -> int:
        ans = inf
        for i, x in enumerate(nums):
            ans = min(ans, abs(x - k))
            j = i - 1
            while j >= 0 and nums[j] | x != nums[j]:
                nums[j] |= x
                ans = min(ans, abs(nums[j] - k))
                j -= 1
        return ans
# leetcode submit region end(Prohibit modification and deletion)
