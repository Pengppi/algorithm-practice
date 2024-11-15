"""
Title: 3261.统计满足 K 约束的子字符串数量 II
Title Slug: countSubstringsThatSatisfyKConstraintIi
Author: Neo
Date: 2024-11-13 12:40:03
"""
from bisect import bisect_left
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def countKConstraintSubstrings(self, s: str, k: int, queries: List[List[int]]) -> List[int]:
        n = len(s)
        cnt = [0, 0]
        left = [0] * n
        pre = [0] * (n + 1)
        l = 0
        for r, c in enumerate(s):
            cnt[ord(c) & 1] += 1
            while cnt[0] > k and cnt[1] > k:
                cnt[ord(s[l]) & 1] -= 1
                l += 1
            left[r] = l
            pre[r + 1] = pre[r] + r - l + 1

        ans = []
        for l, r in queries:
            j = bisect_left(left, l, l, r + 1)
            ans.append(pre[r + 1] - pre[j] + (j - l + 1) * (j - l) // 2)
        return ans
# leetcode submit region end(Prohibit modification and deletion)
