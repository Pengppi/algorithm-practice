"""
Title: 3068.最大节点价值之和
Title Slug: findTheMaximumSumOfNodeValues
Author: Neo
Date: 2025-05-23 20:18:26
"""
from cmath import inf
from typing import List, Tuple


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maximumValueSum(self, nums: List[int], k: int, edges: List[List[int]]) -> int:
        g = [[] for _ in nums]
        for u, v in edges:
            g[u].append(v)
            g[v].append(u)

        def dfs(x: int, fa: int) -> (int, int):
            f0, f1 = 0, -inf
            for y in g[x]:
                if y == fa:
                    continue
                r0, r1 = dfs(y, x)
                f0, f1 = max(f0 + r0, f1 + r1), max(f1 + r0, f0 + r1)
            return max(f0 + nums[x], f1 + (nums[x] ^ k)), max(f1 + nums[x], f0 + (nums[x] ^ k))

        return dfs(0, -1)[0]

# leetcode submit region end(Prohibit modification and deletion)
