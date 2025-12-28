"""
Title: 3075.Maximize Happiness of Selected Children
Title Slug: maximizeHappinessOfSelectedChildren
Author: Neo
Date: 2025-12-25 12:44:26
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:

    def maximumHappinessSum(self, happiness: List[int], k: int) -> int:
        happiness.sort(reverse=True)
        ans = 0
        for i, x in enumerate(happiness):
            if i >= k or x - i <= 0:
                break
            ans += x - i
        return ans


# leetcode submit region end(Prohibit modification and deletion)
