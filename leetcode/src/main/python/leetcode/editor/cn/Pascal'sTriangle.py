"""
Title: 118.Pascal's Triangle
Title Slug: pascalsTriangle
Author: Neo
Date: 2025-08-01 22:21:24
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        ans = [[1]]

        for i in range(1, numRows):
            last = ans[i - 1]
            ans.append([1] + [last[j] + last[j + 1] for j in range(i - 1)] + [1])

        return ans

# leetcode submit region end(Prohibit modification and deletion)
