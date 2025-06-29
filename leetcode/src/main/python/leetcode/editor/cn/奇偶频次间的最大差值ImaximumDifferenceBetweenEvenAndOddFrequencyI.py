"""
Title: 3442.奇偶频次间的最大差值 I
Title Slug: maximumDifferenceBetweenEvenAndOddFrequencyI
Author: Neo
Date: 2025-06-10 22:15:58
"""
from collections import Counter


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxDifference(self, s: str) -> int:
        cnt = [0] * 26
        for c in s:
            cnt[ord(c) - ord('a')] += 1
        mx_odd = 0
        mn_even = 100
        for i in range(26):
            if cnt[i] == 0:
                continue
            if cnt[i] & 1:
                mx_odd = max(mx_odd, cnt[i])
            else:
                mn_even = min(mn_even, cnt[i])
        return mx_odd - mn_even


# leetcode submit region end(Prohibit modification and deletion)
