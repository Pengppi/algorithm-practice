"""
Title: 1186.删除一次得到子数组最大和
Title Slug: maximumSubarraySumWithOneDeletion
Author: Neo
Date: 2024-07-21 11:32:19
"""
from cmath import inf
from functools import cache
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maximumSum(self, arr: List[int]) -> int:

        @cache
        def dfs(i: int, is_del: bool):
            if i == 0:
                if is_del:
                    return -inf
                else:
                    return arr[0]
            if not is_del:
                return max(0, dfs(i - 1, False)) + arr[i]
            else:
                return max(dfs(i - 1, False), arr[i] + dfs(i - 1, True))

        return max(max(dfs(i, True), dfs(i, False)) for i in range(len(arr)))
# leetcode submit region end(Prohibit modification and deletion)
