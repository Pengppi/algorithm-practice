"""
Title: 3432.Count Partitions with Even Sum Difference
Title Slug: countPartitionsWithEvenSumDifference
Author: Neo
Date: 2025-12-05 22:00:55
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:

    def countPartitions(self, nums: List[int]) -> int:
        tot = sum(nums)
        left = 0
        ans = 0
        for x in nums[:-1]:
            left += x
            right = tot - left
            if (left - right) % 2 == 0:
                ans += 1
        return ans

# leetcode submit region end(Prohibit modification and deletion)
