"""
Title: 887.鸡蛋掉落
Title Slug: superEggDrop
Author: Neo
Date: 2024-10-14 12:49:59
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def superEggDrop(self, k: int, n: int) -> int:
        if n == 1:
            return 1
        f = [[0 for _ in range(k + 1)] for _ in range(n + 1)]
        for j in range(1, k + 1):
            f[1][j] = 1
        for i in range(2, n + 1):
            for j in range(1, k + 1):
                f[i][j] = 1 + f[i - 1][j - 1] + f[i - 1][j]
            if f[i][k] >= n:
                return i
        return -1
# leetcode submit region end(Prohibit modification and deletion)
