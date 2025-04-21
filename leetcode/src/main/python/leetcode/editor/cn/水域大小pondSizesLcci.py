"""
Title: 面试题 16.19.水域大小
Title Slug: pondSizesLcci
Author: Neo
Date: 2025-04-19 18:01:11
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def pondSizes(self, land: List[List[int]]) -> List[int]:
        ans = []
        m, n = len(land), len(land[0])

        def dfs(i: int, j: int) -> int:
            if i < 0 or i >= m or j < 0 or j >= n or land[i][j] != 0:
                return 0
            land[i][j] = -1
            res = 1
            for x in range(i - 1, i + 2):
                for y in range(j - 1, j + 2):
                    res += dfs(x, y)

            return res

        for i in range(m):
            for j in range(n):
                if land[i][j] == 0:
                    ans.append(dfs(i, j))
        return sorted(ans)

# leetcode submit region end(Prohibit modification and deletion)
