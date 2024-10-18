"""
Title: 3194.最小元素和最大元素的最小平均值
Title Slug: minimumAverageOfSmallestAndLargestElements
Author: Neo
Date: 2024-10-16 12:46:00
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minimumAverage(self, nums: List[int]) -> float:
        n = len(nums)
        nums.sort()
        avgs = []
        for i in range(n // 2):
            avgs.append((nums[i] + nums[n - 1 - i]) / 2)
        return min(avgs)
# leetcode submit region end(Prohibit modification and deletion)
