"""
Title: 3291.形成目标字符串需要的最少字符串数 I
Title Slug: minimumNumberOfValidStringsToFormTargetI
Author: Neo
Date: 2024-12-17 13:01:09
"""
from math import inf
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minValidStrings(self, words: List[str], target: str) -> int:
        def func_z(s):
            n = len(s)
            z = [0] * n
            l = r = 0
            for i in range(1, n):
                if i <= r:
                    z[i] = min(z[i - l], r - i + 1)
                while i + z[i] < n and s[z[i]] == s[i + z[i]]:
                    l, r = i, i + z[i]
                    z[i] += 1
            return z

        def jump(mx_jumps):
            ans = 0
            cur = nxt = 0
            for i, mx in enumerate(mx_jumps):
                nxt = max(nxt, i + mx)
                if i == cur:
                    if i == nxt:
                        return -1
                    cur = nxt
                    ans += 1
            return ans

        n = len(target)
        mx_jumps = [0] * n
        for word in words:
            z = func_z(word + "#" + target)
            m = len(word) + 1
            for i in range(n):
                mx_jumps[i] = max(mx_jumps[i], z[m + i])

        return jump(mx_jumps)
# leetcode submit region end(Prohibit modification and deletion)
