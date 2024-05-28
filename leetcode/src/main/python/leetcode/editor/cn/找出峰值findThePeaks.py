"""
Title: 2951.找出峰值
Title Slug: findThePeaks
Author: Neo
Date: 2024-05-28 22:45:00
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def findPeaks(self, mountain: List[int]) -> List[int]:
        i, n = 1, len(mountain)
        ans = []
        while i < n - 1:
            if mountain[i - 1] < mountain[i] > mountain[i + 1]:
                ans.append(i)
                i += 1
            i += 1
        return ans
# leetcode submit region end(Prohibit modification and deletion)
