"""
Title: 1534.统计好三元组
Title Slug: countGoodTriplets
Author: Neo
Date: 2025-04-14 12:46:27
"""
from itertools import permutations
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def countGoodTriplets(self, arr: List[int], a: int, b: int, c: int) -> int:
        n = len(arr)
        ans = 0
        for i in range(n - 2):
            for j in range(i + 1, n - 1):
                if abs(arr[i] - arr[j]) > a:
                    continue
                for k in range(j + 1, n):
                    if abs(arr[j] - arr[k]) <= b and abs(arr[i] - arr[k]) <= c:
                        ans += 1
        return ans
# leetcode submit region end(Prohibit modification and deletion)
