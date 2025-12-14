"""
Title: 1925.Count Square Sum Triples
Title Slug: countSquareSumTriples
Author: Neo
Date: 2025-12-08 12:06:36
"""

# leetcode submit region begin(Prohibit modification and deletion)


class Solution:

    def countTriples(self, n: int) -> int:
        ans = 0
        for c in range(5, n + 1):
            for a in range(1, c):
                for b in range(a, c):
                    if a * a + b * b == c * c:
                        ans += 2 if a != b else 1
        return ans


# leetcode submit region end(Prohibit modification and deletion)
Solution().countTriples(5)
