"""
Title: 661.图片平滑器
Title Slug: imageSmoother
Author: Neo
Date: 2024-11-18 12:24:41
"""
from copy import deepcopy
from math import floor
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def imageSmoother(self, img: List[List[int]]) -> List[List[int]]:
        m, n = len(img), len(img[0]),
        ans = deepcopy(img)

        def compute(x, y):
            s = 0
            c = 0
            for i in range(x - 1, x + 2):
                if i < 0 or i >= m:
                    continue
                for j in range(y - 1, y + 2):
                    if 0 <= j < n:
                        s += img[i][j]
                        c += 1
            ans[x][y] = floor(s / c)

        for i in range(m):
            for j in range(n):
                compute(i, j)
        return ans
# leetcode submit region end(Prohibit modification and deletion)
Solution().imageSmoother([[100,200,100],[200,50,200],[100,200,100]])
