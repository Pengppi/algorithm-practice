"""
Title: 994.腐烂的橘子
Title Slug: rottingOranges
Author: Neo
Date: 2024-05-13 00:31:38
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        cnt = 0
        st = []
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 2:
                    st.append([i, j])
                if grid[i][j] == 1:
                    cnt += 1
        dirs = [1, 0, -1, 0, 1]
        ans = -1
        while st:
            ans += 1
            for _ in range(len(st)):
                x, y = st.pop(0)
                for i in range(len(dirs) - 1):
                    nx, ny = x + dirs[i], y + dirs[i + 1]
                    if 0 <= nx < m and 0 <= ny < n and grid[nx][ny] == 1:
                        cnt -= 1
                        grid[nx][ny] = 2
                        st.append([nx, ny])
        return -1 if cnt > 0 else max(0, ans)


# leetcode submit region end(Prohibit modification and deletion)
Solution().orangesRotting([[2, 1, 1], [1, 1, 0], [0, 1, 1]])
