"""
Title: 2106.Maximum Fruits Harvested After at Most K Steps
Title Slug: maximumFruitsHarvestedAfterAtMostKSteps
Author: Neo
Date: 2025-08-03 11:21:23
"""
from bisect import bisect_left
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxTotalFruits(self, fruits: List[List[int]], startPos: int, k: int) -> int:
        l = bisect_left(fruits, [startPos - k])
        r = bisect_left(fruits, [startPos + 1])
        ans = s = sum(f[1] for f in fruits[l:r])

        while r < len(fruits) and fruits[r][0] <= startPos + k:
            s += fruits[r][1]
            while fruits[r][0] - fruits[l][0] + startPos - fruits[l][0] > k and \
                    fruits[r][0] - fruits[l][0] + fruits[r][0] - startPos > k:
                s -= fruits[l][1]
                l += 1
            ans = max(ans, s)
            r += 1
        return ans

# leetcode submit region end(Prohibit modification and deletion)
