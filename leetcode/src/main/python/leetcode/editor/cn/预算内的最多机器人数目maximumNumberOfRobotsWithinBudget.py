"""
Title: 2398.预算内的最多机器人数目
Title Slug: maximumNumberOfRobotsWithinBudget
Author: Neo
Date: 2024-09-13 11:59:45
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maximumRobots(self, chargeTimes: List[int], runningCosts: List[int], budget: int) -> int:
        n = len(chargeTimes)
        st = []
        s = 0
        l = 0
        ans = 0
        for r in range(n):
            while st and chargeTimes[st[-1]] <= chargeTimes[r]:
                del st[-1]
            st.append(r)
            s += runningCosts[r]
            while l <= r and chargeTimes[st[0]] + (r - l + 1) * s > budget:
                s -= runningCosts[l]
                if l in st:
                    st.remove(l)
                l += 1
            ans = max(ans, r - l + 1)
        return ans
# leetcode submit region end(Prohibit modification and deletion)
