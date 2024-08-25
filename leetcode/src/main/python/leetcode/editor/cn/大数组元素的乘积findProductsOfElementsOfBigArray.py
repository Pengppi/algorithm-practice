"""
Title: 3145.大数组元素的乘积
Title Slug: findProductsOfElementsOfBigArray
Author: Neo
Date: 2024-08-23 11:17:15
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def findProductsOfElements(self, queries: List[List[int]]) -> List[int]:
        def sum(x):
            res = 0
            n = 0
            cnt = 0
            s = 0
            for i in range((x + 1).bit_length() - 1, 0, -1):
                c = (cnt << i) + (i << (i - 1))
                if c <= x:
                    x -= c
                    res += (s << i) + ((i * (i - 1) // 2) << (i - 1))
                    s += i
                    cnt += 1
                    n |= 1 << i

            if cnt <= x:
                x -= cnt
                res += s
                n |= 1
            for _ in range(x):
                lb = n & -n
                res += lb.bit_length() - 1
                n ^= lb
            return res

        return [pow(2, sum(r + 1) - sum(l), mod) for l, r, mod in queries]

# leetcode submit region end(Prohibit modification and deletion)
