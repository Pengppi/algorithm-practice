"""
Title: 1014.最佳观光组合
Title Slug: bestSightseeingPair
Author: Neo
Date: 2024-09-23 12:17:39
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxScoreSightseeingPair(self, values: List[int]) -> int:
        ans = 0
        st = []
        for x in values:
            if st:
                st = [x - 1 for x in st]
                ans = max(ans, x + st[0])
            while st and st[-1] <= x:
                del st[-1]
            st.append(x)
        return ans

# leetcode submit region end(Prohibit modification and deletion)
