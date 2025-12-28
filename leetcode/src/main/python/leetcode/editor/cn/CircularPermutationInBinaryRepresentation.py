"""
Title: 1238.Circular Permutation in Binary Representation
Title Slug: circularPermutationInBinaryRepresentation
Author: Neo
Date: 2025-12-22 19:24:14
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:

    def circularPermutation(self, n: int, start: int) -> List[int]:

        def grey_code(x: int) -> int:
            return x ^ (x >> 1)

        g = [grey_code(i) for i in range(1 << n)]
        i = g.index(start)
        return g[i:] + g[:i]


# leetcode submit region end(Prohibit modification and deletion)
