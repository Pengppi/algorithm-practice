"""
Title: 3137.K 周期字符串需要的最少操作次数
Title Slug: minimumNumberOfOperationsToMakeWordKPeriodic
Author: Neo
Date: 2024-08-17 21:17:04
"""
from collections import defaultdict


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minimumOperationsToMakeKPeriodic(self, word: str, k: int) -> int:
        mp = defaultdict(int)
        i = 0
        n = len(word)
        cnt = 0
        while i < n:
            v = hash(word[i:i + k])
            mp[v] += 1
            cnt = max(cnt, mp[v])
            i += k
        return n // k - cnt

    # leetcode submit region end(Prohibit modification and deletion)
