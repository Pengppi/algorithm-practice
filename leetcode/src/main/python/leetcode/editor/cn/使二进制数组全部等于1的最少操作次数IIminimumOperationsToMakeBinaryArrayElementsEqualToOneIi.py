"""
Title: 3192.使二进制数组全部等于 1 的最少操作次数 II
Title Slug: minimumOperationsToMakeBinaryArrayElementsEqualToOneIi
Author: Neo
Date: 2024-10-19 11:38:17
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minOperations(self, nums: List[int]) -> int:
        f = 0
        ans = 0
        for x in nums:
            if f == x:
                ans += 1
                f ^= 1

        return ans
# leetcode submit region end(Prohibit modification and deletion)
