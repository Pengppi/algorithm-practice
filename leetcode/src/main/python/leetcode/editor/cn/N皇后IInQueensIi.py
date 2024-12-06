"""
Title: 52.N 皇后 II
Title Slug: nQueensIi
Author: Neo
Date: 2024-12-02 12:46:00
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def totalNQueens(self, n: int) -> int:
        def isValid(used: List[int], i: int):
            for j in range(i):
                if used[i] == used[j] or abs(used[i] - used[j]) == i - j:
                    return False
            return True

        def dfs(used: List[int], i: int):
            if i == n:
                return 1
            res = 0
            for j in range(n):
                used[i] = j
                if isValid(used, i):
                    res += dfs(used, i + 1)
            return res

        return dfs([0] * n, 0)

# leetcode submit region end(Prohibit modification and deletion)
