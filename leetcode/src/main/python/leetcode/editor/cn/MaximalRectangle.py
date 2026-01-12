"""
Title: 85.Maximal Rectangle
Title Slug: maximalRectangle
Author: Neo
Date: 2026-01-11 14:37:53
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:

    def largestRectangleArea(self, heights: List[int]) -> int:
        heights.append(-1)
        st = [-1]
        ans = 0
        for right, h in enumerate(heights):
            while len(st) > 1 and heights[st[-1]] >= h:
                i = st.pop()
                left = st[-1]
                ans = max(ans, heights[i] * (right - left - 1))
            st.append(right)

        return ans

    def maximalRectangle(self, matrix: List[List[str]]) -> int:
        m, n = len(matrix), len(matrix[0])
        heights = [0] * n
        ans = 0
        for i in range(m):
            for j in range(n):
                heights[j] = heights[j] + 1 if matrix[i][j] == '1' else 0
            ans = max(ans, self.largestRectangleArea(heights))
        return ans


# leetcode submit region end(Prohibit modification and deletion)
