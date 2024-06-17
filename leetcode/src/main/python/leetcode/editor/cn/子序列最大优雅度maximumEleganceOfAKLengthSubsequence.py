"""
Title: 2813.子序列最大优雅度
Title Slug: maximumEleganceOfAKLengthSubsequence
Author: Neo
Date: 2024-06-13 23:01:26
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def findMaximumElegance(self, items: List[List[int]], k: int) -> int:
        items.sort(key=lambda x: -x[0])
        ans = tot_profit = 0
        vis = set()
        duplicate = []
        for i, (profit, category) in enumerate(items):
            if i < k:
                tot_profit += profit
                if category not in vis:
                    vis.add(category)
                else:
                    duplicate.append(profit)
            elif duplicate and category not in vis:
                vis.add(category)
                tot_profit += profit - duplicate.pop()
            ans = max(ans, tot_profit + len(vis) * len(vis))
        return ans
# leetcode submit region end(Prohibit modification and deletion)
