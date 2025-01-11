"""
Title: 3019.按键变更的次数
Title Slug: numberOfChangingKeys
Author: Neo
Date: 2025-01-07 20:19:32
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def countKeyChanges(self, s: str) -> int:
        s = s.lower()
        return sum([1 if s[i] != s[i - 1] else 0 for i in range(1, len(s))])

# leetcode submit region end(Prohibit modification and deletion)
