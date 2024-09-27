"""
Title: 2516.每种字符至少取 K 个
Title Slug: takeKOfEachCharacterFromLeftAndRight
Author: Neo
Date: 2024-09-27 13:06:03
"""
from collections import Counter


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def takeCharacters(self, s: str, k: int) -> int:
        cnt = [0] * 3
        for c in s:
            i = ord(c) - ord('a')
            cnt[i] += 1
        if min(cnt) < k:
            return -1
        n = len(s)
        ans = n
        l = 0
        for r, c in enumerate(s):
            i = ord(c) - ord('a')
            cnt[i] -= 1
            while cnt[i] < k:
                j = ord(s[l]) - ord('a')
                cnt[j] += 1
                l += 1
            ans = min(ans, n - (r - l + 1))
        return ans
# leetcode submit region end(Prohibit modification and deletion)
