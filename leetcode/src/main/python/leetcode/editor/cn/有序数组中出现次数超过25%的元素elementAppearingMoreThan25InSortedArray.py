"""
Title: 1287.有序数组中出现次数超过25%的元素
Title Slug: elementAppearingMoreThan25InSortedArray
Author: Neo
Date: 2025-02-17 12:49:45
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def findSpecialInteger(self, arr: List[int]) -> int:
        n = len(arr)
        k = n // 4
        for i in range(n - k):
            if arr[i] == arr[i + k]:
                return arr[i]

# leetcode submit region end(Prohibit modification and deletion)
