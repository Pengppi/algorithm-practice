"""
Title: 84.Largest Rectangle in Histogram
Title Slug: largestRectangleInHistogram
Author: Neo
Date: 2026-01-11 14:56:12
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:

    def largestRectangleArea(self, heights: List[int]) -> int:
        heights.append(1)
        st = [-1]
        ans = 0
        for right, h in enumerate(heights):
            while len(st) > 1 and heights[st[-1]] >= h:
                i = st.pop()
                left = st[-1]
                ans = max(ans, heights[i] * (right - left - 1))
            st.append(right)

        return ans


# leetcode submit region end(Prohibit modification and deletion)
