"""
Title: 3211.生成不含相邻零的二进制字符串
Title Slug: generateBinaryStringsWithoutAdjacentZeros
Author: Neo
Date: 2024-10-29 13:03:51
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def validStrings(self, n: int) -> List[str]:
        ans = []

        def dfs(x: int):
            if x.bit_length() == n:
                ans.append(bin(x)[2:])
                return
            elif x.bit_length() == n - 1:
                if n - 1 > 0:
                    ans.append('0' + bin(x)[2:])
                else:
                    ans.append(bin(x)[2:])

            dfs((x << 1) | 1)
            if x & 1:
                dfs(x << 1)

        dfs(0)
        return ans
# leetcode submit region end(Prohibit modification and deletion)
