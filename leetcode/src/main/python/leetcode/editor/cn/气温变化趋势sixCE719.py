"""
Title: LCP 61.气温变化趋势
Title Slug: sixCE719
Author: Neo
Date: 2024-06-21 12:11:01
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def temperatureTrend(self, temperatureA: List[int], temperatureB: List[int]) -> int:
        n = len(temperatureA)
        f = [0] * n
        ans = 0
        for i in range(1, n):
            a = temperatureA[i] - temperatureA[i - 1]
            b = temperatureB[i] - temperatureB[i - 1]
            if a * b > 0 or a == 0 and b == 0:
                f[i] = f[i - 1] + 1
                ans = max(ans, f[i])
        return ans


# leetcode submit region end(Prohibit modification and deletion)
Solution().temperatureTrend([1, -15, 3, 14, -1, 4, 35, 36],
                            [-15, 32, 20, 9, 33, 4, -1, -5])
