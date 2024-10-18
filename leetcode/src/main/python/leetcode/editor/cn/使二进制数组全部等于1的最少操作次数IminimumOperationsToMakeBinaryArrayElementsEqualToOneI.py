"""
Title: 3191.使二进制数组全部等于 1 的最少操作次数 I
Title Slug: minimumOperationsToMakeBinaryArrayElementsEqualToOneI
Author: Neo
Date: 2024-10-18 12:45:32
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minOperations(self, nums: List[int]) -> int:
        n = len(nums)
        ans = 0
        for i in range(n):
            if nums[i] & 1:
                continue
            if i + 2 >= n:
                return -1
            else:
                nums[i + 1] ^= 1
                nums[i + 2] ^= 1
                ans += 1
        return ans
# leetcode submit region end(Prohibit modification and deletion)
