"""
Title: 135.分发糖果
Title Slug: candy
Author: Neo
Date: 2025-06-02 14:55:53
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def candy(self, ratings: List[int]) -> int:
        n = len(ratings)
        cnt = [1] * n
        for i in range(1, n):
            if ratings[i] > ratings[i - 1]:
                cnt[i] = cnt[i - 1] + 1

        for i in range(n - 2, -1, -1):
            if ratings[i] > ratings[i + 1]:
                cnt[i] = max(cnt[i], cnt[i + 1] + 1)
        return sum(cnt)
# leetcode submit region end(Prohibit modification and deletion)
