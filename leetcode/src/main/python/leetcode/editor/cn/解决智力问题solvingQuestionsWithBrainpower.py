"""
Title: 2140.解决智力问题
Title Slug: solvingQuestionsWithBrainpower
Author: Neo
Date: 2025-04-01 12:55:05
"""
from functools import cache
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def mostPoints(self, questions: List[List[int]]) -> int:
        n = len(questions)

        f = [0] * n
        f[-1] = questions[-1][0]
        for i in range(n - 2, -1, -1):
            # skip
            f[i] = f[i + 1]
            # choose
            next = i + questions[i][1] + 1
            nextPoint = f[next] if next < n else 0
            f[i] = max(f[i], questions[i][0] + nextPoint)

        return f[0]

        # @cache
        # def dfs(x):
        #     if x >= n:
        #         return 0
        #
        #     return max(questions[x][0] + dfs(x + questions[x][1] + 1), dfs(x + 1))
        #
        # return dfs(0)

# leetcode submit region end(Prohibit modification and deletion)
