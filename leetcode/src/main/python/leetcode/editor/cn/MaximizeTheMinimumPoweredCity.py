"""
Title: 2528.Maximize the Minimum Powered City
Title Slug: maximizeTheMinimumPoweredCity
Author: Neo
Date: 2025-11-07 12:41:16
"""
from itertools import accumulate
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxPower(self, stations: List[int], r: int, k: int) -> int:
        n = len(stations)
        ps = list(accumulate(stations, initial=0))
        power = [ps[min(i + r + 1, n)] - ps[max(i - r, 0)] for i in range(n)]

        def check(low: int) -> bool:
            diff = [0] * n  # 差分数组
            sum_d = built = 0
            for i, p in enumerate(power):
                sum_d += diff[i]  # 累加差分值
                m = low - (p + sum_d)
                if m <= 0:
                    continue
                # 需要在 i+r 额外建造 m 个供电站
                built += m
                if built > k:  # 不满足要求
                    return False
                # 把区间 [i, i+2r] 增加 m
                sum_d += m  # 由于 diff[i] 后面不会再访问，我们直接加到 sum_d 中
                if (right := i + r * 2 + 1) < n:
                    diff[right] -= m
            return True

        mn = min(power)
        left = mn + k // n
        right = mn + k + 1
        while left + 1 < right:
            mid = (left + right) // 2
            if check(mid):
                left = mid
            else:
                right = mid
        return left

# leetcode submit region end(Prohibit modification and deletion)
