"""
Title: 165.Compare Version Numbers
Title Slug: compareVersionNumbers
Author: Neo
Date: 2025-09-23 12:26:01
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def compareVersion(self, version1: str, version2: str) -> int:
        dot = '.'
        revisions1 = version1.split(dot)
        revisions2 = version2.split(dot)
        m = len(revisions1)
        n = len(revisions2)
        for i in range(max(m, n)):
            r1 = int(revisions1[i]) if i < m else 0
            r2 = int(revisions2[i]) if i < n else 0
            if r1 == r2:
                continue
            return -1 if r1 < r2 else 1
        return 0

# leetcode submit region end(Prohibit modification and deletion)
