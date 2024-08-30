"""
Title: 3153.所有数对中数位不同之和
Title Slug: sumOfDigitDifferencesOfAllPairs
Author: Neo
Date: 2024-08-30 12:03:50
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def sumDigitDifferences(self, nums: List[int]) -> int:
        cnt = [[0 for _ in range(10)] for _ in range(len(str(nums[0])))]
        ans = 0
        for i, x in enumerate(nums):
            j = 0
            while x > 0:
                d = x % 10
                ans += i - cnt[j][d]
                cnt[j][d] += 1
                x //= 10
                j += 1
        return ans
# leetcode submit region end(Prohibit modification and deletion)
