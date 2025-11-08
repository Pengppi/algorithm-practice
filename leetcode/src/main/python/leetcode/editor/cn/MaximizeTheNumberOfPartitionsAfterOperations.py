"""
Title: 3003.Maximize the Number of Partitions After Operations
Title Slug: maximizeTheNumberOfPartitionsAfterOperations
Author: Neo
Date: 2025-10-17 12:31:50
"""
from functools import cache


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxPartitionsAfterOperations(self, s: str, k: int) -> int:
        n = len(s)
        arr = [ord(c) - 97 for c in s]

        @cache
        def dfs(i: int, mask: int, is_changed: bool) -> int:
            if i == n:
                return 1
            cur_bit = 1 << arr[i]
            new_mask = mask | cur_bit
            if new_mask.bit_count() > k:
                res = 1 + dfs(i + 1, cur_bit, is_changed)
            else:
                res = dfs(i + 1, new_mask, is_changed)

            if is_changed:
                return res

            for j in range(26):
                new_mask = mask | (1 << j)
                if new_mask.bit_count() > k:
                    res = max(res, 1 + dfs(i + 1, 1 << j, True))
                else:
                    res = max(res, dfs(i + 1, new_mask, True))
            return res

        return dfs(0, 0, False)

# leetcode submit region end(Prohibit modification and deletion)
