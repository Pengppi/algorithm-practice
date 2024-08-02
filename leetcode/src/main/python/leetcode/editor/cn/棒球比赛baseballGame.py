"""
Title: 682.棒球比赛
Title Slug: baseballGame
Author: Neo
Date: 2024-07-29 12:52:24
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def calPoints(self, operations: List[str]) -> int:
        ans = []
        for ops in operations:
            if ops == '+':
                ans.append(ans[-1] + ans[-2])
            elif ops == 'D':
                ans.append(ans[-1] * 2)
            elif ops == 'C':
                del ans[-1]
            else:
                ans.append(int(ops))
        return sum(ans)

# leetcode submit region end(Prohibit modification and deletion)
