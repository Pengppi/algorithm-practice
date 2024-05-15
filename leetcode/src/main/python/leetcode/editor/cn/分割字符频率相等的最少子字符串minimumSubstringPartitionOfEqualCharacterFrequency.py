"""
Title: 3144.分割字符频率相等的最少子字符串
Title Slug: minimumSubstringPartitionOfEqualCharacterFrequency
Author: Neo
Date: 2024-05-15 13:28:42
"""
from collections import Counter
from functools import cache
from math import inf


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minimumSubstringsInPartition(self, s: str) -> int:
        @cache
        def dfs(i: int) -> int:
            if i < 0:
                return 0
            res = inf
            cnt = Counter()
            for j in range(i, -1, -1):
                cnt[s[j]] += 1
                if (i - j + 1) % len(cnt):
                    continue
                val = cnt[s[j]]
                if all(val == c for c in cnt.values()):
                    res = min(res, dfs(j - 1) + 1)
            return res

        return dfs(len(s) - 1)

# leetcode submit region end(Prohibit modification and deletion)
