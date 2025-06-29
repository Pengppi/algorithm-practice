"""
Title: 3443.K 次修改后的最大曼哈顿距离
Title Slug: maximumManhattanDistanceAfterKChanges
Author: Neo
Date: 2025-06-20 12:36:24
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxDistance(self, s: str, k: int) -> int:
        ans = x = y = 0
        for i, ch in enumerate(s):
            if ch == 'N':
                y += 1
            elif ch == 'S':
                y -= 1
            elif ch == 'E':
                x += 1
            elif ch == 'W':
                x -= 1
            ans = max(ans, min(abs(x) + abs(y) + k * 2, i + 1))
        return ans
# leetcode submit region end(Prohibit modification and deletion)
