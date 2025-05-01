"""
Title: 1295.统计位数为偶数的数字
Title Slug: findNumbersWithEvenNumberOfDigits
Author: Neo
Date: 2025-04-30 12:18:20
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def findNumbers(self, nums: List[int]) -> int:
        return len(nums) - sum(len(str(x)) & 1 for x in nums)

# leetcode submit region end(Prohibit modification and deletion)
