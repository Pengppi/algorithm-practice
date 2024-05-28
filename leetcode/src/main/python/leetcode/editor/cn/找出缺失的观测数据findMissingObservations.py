"""
Title: 2028.找出缺失的观测数据
Title Slug: findMissingObservations
Author: Neo
Date: 2024-05-27 21:26:00
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def missingRolls(self, rolls: List[int], mean: int, n: int) -> List[int]:
        m = len(rolls)
        tot = mean * (n + m)
        for roll in rolls:
            tot -= roll
        if tot > n * 6 or tot < n:
            return []
        avg = tot // n
        remain = tot % n
        ans = []
        for i in range(n):
            if remain > 0:
                ans.append(avg + 1)
                remain -= 1
            else:
                ans.append(avg)
        return ans
# leetcode submit region end(Prohibit modification and deletion)
