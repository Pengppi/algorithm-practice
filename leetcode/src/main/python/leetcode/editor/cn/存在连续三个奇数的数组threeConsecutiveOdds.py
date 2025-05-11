"""
Title: 1550.存在连续三个奇数的数组
Title Slug: threeConsecutiveOdds
Author: Neo
Date: 2025-05-11 19:08:00
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def threeConsecutiveOdds(self, arr: List[int]) -> bool:
        n = len(arr)
        for i in range(1, n - 1):
            a, b, c = arr[i - 1], arr[i], arr[i + 1]
            if a & 1 and b & 1 and c & 1:
                return True
        return False

# leetcode submit region end(Prohibit modification and deletion)
