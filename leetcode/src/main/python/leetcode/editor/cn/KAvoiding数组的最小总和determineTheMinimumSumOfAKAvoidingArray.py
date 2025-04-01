"""
Title: 2829.k-avoiding 数组的最小总和
Title Slug: determineTheMinimumSumOfAKAvoidingArray
Author: Neo
Date: 2025-03-26 12:59:15
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minimumSum(self, n: int, k: int) -> int:
        used = set()
        cur = 1
        while len(used) < n:
            if k - cur not in used:
                used.add(cur)
            cur += 1
        return sum(used)
# leetcode submit region end(Prohibit modification and deletion)
