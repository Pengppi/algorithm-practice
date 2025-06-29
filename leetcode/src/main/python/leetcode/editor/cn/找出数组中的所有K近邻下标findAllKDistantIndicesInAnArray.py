"""
Title: 2200.找出数组中的所有 K 近邻下标
Title Slug: findAllKDistantIndicesInAnArray
Author: Neo
Date: 2025-06-24 10:40:38
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def findKDistantIndices(self, nums: List[int], key: int, k: int) -> List[int]:
        ans = []
        last = 0
        for i, x in enumerate(nums):
            if x == key:
                for j in range(max(last, i - k), min(i + k + 1, len(nums))):
                    ans.append(j)
                last = i + k + 1
        return ans

# leetcode submit region end(Prohibit modification and deletion)
