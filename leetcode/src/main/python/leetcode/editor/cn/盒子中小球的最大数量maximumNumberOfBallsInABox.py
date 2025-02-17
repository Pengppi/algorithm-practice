"""
Title: 1742.盒子中小球的最大数量
Title Slug: maximumNumberOfBallsInABox
Author: Neo
Date: 2025-02-13 13:10:56
"""
from collections import defaultdict


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def countBalls(self, lowLimit: int, highLimit: int) -> int:
        cnt = defaultdict(int)
        ans = 0
        for x in range(lowLimit, highLimit + 1):
            s = 0
            while x > 0:
                s += x % 10
                x //= 10
            cnt[s] += 1
            ans = max(ans, cnt[s])
        return ans

# leetcode submit region end(Prohibit modification and deletion)
