"""
Title: 1494.并行课程 II
Title Slug: parallelCoursesIi
Author: Neo
Date: 2025-06-27 19:04:46
"""
from cmath import inf
from functools import cache
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minNumberOfSemesters(self, n: int, relations: List[List[int]], k: int) -> int:
        pre_req = [0] * n
        for x, y in relations:
            pre_req[y - 1] |= 1 << (x - 1)

        all = (1 << n) - 1 #全集

        @cache
        def dfs(cur: int) -> int:
            if cur == 0:
                return 0

            other = all ^ cur #补集
            learn_pre = 0
            for y, pre in enumerate(pre_req):
                if cur & (1 << y) == 0:
                    continue
                if pre | other != other:
                    continue
                learn_pre |= 1 << y
            if learn_pre.bit_count() <= k:
                return 1 + dfs(cur ^ learn_pre)
            res = inf
            cur_pre = learn_pre
            while cur_pre:
                if cur_pre.bit_count() == k:
                    res = min(res, 1 + dfs(cur ^ cur_pre))
                cur_pre = (cur_pre - 1) & learn_pre
            return res

        return dfs(all)

# leetcode submit region end(Prohibit modification and deletion)
