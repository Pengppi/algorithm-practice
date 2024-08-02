"""
Title: 2961.双模幂运算
Title Slug: doubleModularExponentiation
Author: Neo
Date: 2024-07-30 09:36:39
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def getGoodIndices(self, variables: List[List[int]], target: int) -> List[int]:
        ans = []
        for i, (a, b, c, m) in enumerate(variables):
            if ((a ** b % 10) ** c) % m == target:
                ans.append(i)

        return ans
# leetcode submit region end(Prohibit modification and deletion)
