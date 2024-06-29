"""
Title: 1281.整数的各位积和之差
Title Slug: subtractTheProductAndSumOfDigitsOfAnInteger
Author: Neo
Date: 2024-06-29 01:21:26
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def subtractProductAndSum(self, n: int) -> int:
        s, p = 0, 1
        while n > 0:
            x = n % 10
            s += x
            p *= x
            n //= 10
        return p - s
# leetcode submit region end(Prohibit modification and deletion)
