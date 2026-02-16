"""
Title: 1234.Replace the Substring for Balanced String
Title Slug: replaceTheSubstringForBalancedString
Author: Neo
Date: 2026-01-11 15:09:24
"""
from cmath import inf
from collections import Counter


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:

    def balancedString(self, s: str) -> int:
        balancedCnt = len(s) // 4
        cnt = Counter(s)
        if all(cnt[c] == balancedCnt for c in 'QWER'):
            return 0
        ans, left = inf, 0
        for right, c in enumerate(s):
            cnt[c] -= 1
            while max(cnt.values()) <= balancedCnt:
                ans = min(ans, right - left + 1)
                cnt[s[left]] += 1
                left += 1

        return ans


# leetcode submit region end(Prohibit modification and deletion)
