"""
Title: 2506.统计相似字符串对的数目
Title Slug: countPairsOfSimilarStrings
Author: Neo
Date: 2025-02-22 13:15:01
"""
from collections import defaultdict
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def similarPairs(self, words: List[str]) -> int:
        ans = 0
        mp = defaultdict(int)
        for i in range(len(words)):
            mask = 0
            for c in words[i]:
                t = ord(c) - ord('a')
                mask |= 1 << t

            ans += mp[mask]
            mp[mask] += 1

        return ans
# leetcode submit region end(Prohibit modification and deletion)
