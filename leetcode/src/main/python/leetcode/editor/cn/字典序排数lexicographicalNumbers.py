"""
Title: 386.字典序排数
Title Slug: lexicographicalNumbers
Author: Neo
Date: 2025-06-08 13:35:58
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def lexicalOrder(self, n: int) -> List[int]:
        ans = []

        def dfs(x: int):
            if x > n:
                return
            nonlocal ans
            ans.append(x)
            for j in range(0, 10):
                dfs(x * 10 + j)

        for i in range(1, 10):
            dfs(i)
        return ans
# leetcode submit region end(Prohibit modification and deletion)
