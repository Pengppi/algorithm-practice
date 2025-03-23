"""
Title: 2680.最大或值
Title Slug: maximumOr
Author: Neo
Date: 2025-03-21 23:17:39
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maximumOr(self, nums: List[int], k: int) -> int:
        n = len(nums)
        # suf[i] 表示 nums[i+1:] 的 OR
        suf = [0] * n
        for i in range(n - 2, -1, -1):
            suf[i] = suf[i + 1] | nums[i + 1]

        # pre 表示 nums[:i] 的 OR
        ans = pre = 0
        for x, suf_or in zip(nums, suf):
            ans = max(ans, pre | (x << k) | suf_or)
            pre |= x
        return ans

# leetcode submit region end(Prohibit modification and deletion)

