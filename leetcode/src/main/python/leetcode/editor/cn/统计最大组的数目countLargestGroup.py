"""
Title: 1399.统计最大组的数目
Title Slug: countLargestGroup
Author: Neo
Date: 2025-04-23 09:43:50
"""
from collections import defaultdict


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def countLargestGroup(self, n: int) -> int:
        mx = 0
        cnt = defaultdict(int)
        for x in range(1, n + 1):
            s = 0
            while x:
                s += x % 10
                x //= 10
            cnt[s] += 1
            mx = max(mx, cnt[s])

        return sum(1 for x in cnt.values() if x == mx)

# leetcode submit region end(Prohibit modification and deletion)
