"""
Title: 2643.一最多的行
Title Slug: rowWithMaximumOnes
Author: Neo
Date: 2025-03-22 22:52:56
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def rowAndMaximumOnes(self, mat: List[List[int]]) -> List[int]:
        ans = 0
        mx = 0
        for i in range(len(mat)):
            cnt = sum(mat[i])
            if cnt > mx:
                mx = cnt
                ans = i
        return [ans, mx]


        
# leetcode submit region end(Prohibit modification and deletion)

