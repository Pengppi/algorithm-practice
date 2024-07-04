"""
Title: 3086.拾起 K 个 1 需要的最少行动次数
Title Slug: minimumMovesToPickKOnes
Author: Neo
Date: 2024-07-04 12:28:36
"""
from cmath import inf
from itertools import accumulate
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minimumMoves(self, nums: List[int], k: int, maxChanges: int) -> int:
        pos = []
        c = 0
        for i, x in enumerate(nums):
            if x == 0:
                continue
            pos.append(i)
            c = max(c, 1)
            if i > 0 and nums[i - 1] == 1:
                c = max(c, 2)
                if i > 1 and nums[i - 2] == 1:
                    c = 3
        c = min(k, c)
        if maxChanges >= k - c:
            return max(c - 1, 0) + (k - c) * 2

        n = len(pos)
        pre_sum = list(accumulate(pos, initial=0))
        sz = k - maxChanges
        ans = inf
        for r in range(sz, n + 1):
            l = r - sz
            m = l + sz // 2
            s1 = pos[m] * (m - l) - (pre_sum[m] - pre_sum[l])
            s2 = pre_sum[r] - pre_sum[m] - pos[m] * (r - m)
            ans = min(ans, s1 + s2)
        return ans + maxChanges * 2
# leetcode submit region end(Prohibit modification and deletion)
