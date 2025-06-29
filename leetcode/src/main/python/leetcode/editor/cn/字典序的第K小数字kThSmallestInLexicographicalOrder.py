"""
Title: 440.字典序的第K小数字
Title Slug: kThSmallestInLexicographicalOrder
Author: Neo
Date: 2025-06-09 12:31:16
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def findKthNumber(self, n: int, k: int) -> int:
        def get_count(cur: int) -> int:
            res = 0
            l = r = cur
            while l <= n:
                res += min(n, r) - l + 1
                l = l * 10
                r = r * 10 + 9
            return res

        cur = 1
        while k > 1:
            cnt = get_count(cur)
            if cnt < k:
                k -= cnt
                cur += 1
            else:
                k -= 1
                cur *= 10
        return cur

# leetcode submit region end(Prohibit modification and deletion)
