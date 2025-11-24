"""
Title: 1930.Unique Length-3 Palindromic Subsequences
Title Slug: uniqueLength3PalindromicSubsequences
Author: Neo
Date: 2025-11-21 20:34:07
"""
from collections import defaultdict


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def countPalindromicSubsequence(self, s: str) -> int:

        def count_distinct(l, r):
            if l > r:
                return 0
            return len(set(s[l:r + 1]))

        s = list(s)
        dt = defaultdict(list)
        for i, c in enumerate(s):
            if c not in dt:
                dt[c] = [i, -1]
            elif len(dt[c]) == 1:
                dt[c].append(i)
            else:
                dt[c][-1] = i

        ans = 0
        for c, ids in dt.items():
            if len(ids) < 2:
                continue
            l, r = ids[0], ids[-1]
            ans += count_distinct(l + 1, r - 1)
        return ans

# leetcode submit region end(Prohibit modification and deletion)

Solution().countPalindromicSubsequence("bbcbaba")