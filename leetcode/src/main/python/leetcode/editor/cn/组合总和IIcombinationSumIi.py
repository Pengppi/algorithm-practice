"""
Title: 40.组合总和 II
Title Slug: combinationSumIi
Author: Neo
Date: 2025-01-26 15:23:32
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        candidates.sort()
        ans = []

        def dfs(x, ta, path):
            if ta == 0:
                nonlocal ans
                ans.append(path)
                return
            if ta < 0:
                return
            for i in range(x, len(candidates)):
                if i > x and candidates[i] == candidates[i - 1]:
                    continue
                if candidates[i] > ta:
                    break
                dfs(i + 1, ta - candidates[i], path + [candidates[i]])

        dfs(0, target, [])
        return ans
# leetcode submit region end(Prohibit modification and deletion)
