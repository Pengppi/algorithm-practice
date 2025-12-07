"""
Title: 1018.Binary Prefix Divisible By 5
Title Slug: binaryPrefixDivisibleBy5
Author: Neo
Date: 2025-11-24 12:42:28
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def prefixesDivBy5(self, nums: List[int]) -> List[bool]:
        n = len(nums)
        ans = [False] * n
        cur = 0
        for i, x in enumerate(nums):
            cur = (cur * 2 + x) % 5
            ans[i] = cur == 0

        return ans
# leetcode submit region end(Prohibit modification and deletion)
