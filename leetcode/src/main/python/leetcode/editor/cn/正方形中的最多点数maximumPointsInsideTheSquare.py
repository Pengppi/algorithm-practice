"""
Title: 3143.正方形中的最多点数
Title Slug: maximumPointsInsideTheSquare
Author: Neo
Date: 2024-08-03 12:08:13
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxPointsInsideSquare(self, points: List[List[int]], s: str) -> int:
        n = len(s)
        idx = [i for i in range(n)]
        idx.sort(key=lambda i: max(abs(points[i][0]), abs(points[i][1])))
        st = set()
        ans = 0
        last_dist = -1
        same_dist_cnt = 0
        for i in idx:
            dist = max(abs(points[i][0]), abs(points[i][1]))
            if dist == last_dist:
                same_dist_cnt += 1
            else:
                ans += same_dist_cnt
                last_dist = dist
                same_dist_cnt = 1
            if s[i] in st:
                return ans
            st.add(s[i])
        return ans + same_dist_cnt
# leetcode submit region end(Prohibit modification and deletion)
