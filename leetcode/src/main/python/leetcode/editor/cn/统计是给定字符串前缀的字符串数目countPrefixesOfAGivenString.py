"""
Title: 2255.统计是给定字符串前缀的字符串数目
Title Slug: countPrefixesOfAGivenString
Author: Neo
Date: 2025-03-24 12:22:36
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def countPrefixes(self, words: List[str], s: str) -> int:
        return sum(s.startswith(w) for w in words)
# leetcode submit region end(Prohibit modification and deletion)

