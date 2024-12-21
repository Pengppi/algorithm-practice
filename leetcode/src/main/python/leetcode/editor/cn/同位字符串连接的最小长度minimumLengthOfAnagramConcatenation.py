"""
Title: 3138.同位字符串连接的最小长度
Title Slug: minimumLengthOfAnagramConcatenation
Author: Neo
Date: 2024-12-20 13:42:11
"""
from collections import Counter


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minAnagramLength(self, s: str) -> int:
        n = len(s)
        for k in range(1, n // 2 + 1):
            if n % k:
                continue
            cnt = Counter(s[:k])
            for i in range(k * 2, n + 1, k):
                if cnt != Counter(s[i - k:i]):
                    break
            else:
                return k
        return n
# leetcode submit region end(Prohibit modification and deletion)
