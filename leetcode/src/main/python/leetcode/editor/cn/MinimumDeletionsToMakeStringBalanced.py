"""
Title: 1653.Minimum Deletions to Make String Balanced
Title Slug: minimumDeletionsToMakeStringBalanced
Author: Neo
Date: 2026-02-07 19:44:18
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minimumDeletions(self, s: str) -> int:
        f = cntB = 0
        for c in s:
            if c == "b":
                cntB += 1
            else:
                f = min(f + 1, cntB)
        return f

# leetcode submit region end(Prohibit modification and deletion)
