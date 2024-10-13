"""
Title: 1884.鸡蛋掉落-两枚鸡蛋
Title Slug: eggDropWith2EggsAndNFloors
Author: Neo
Date: 2024-10-13 12:11:11
"""
import math
from linecache import cache


# leetcode submit region begin(Prohibit modification and deletion)

@cache
def dfs(x: int) -> int:
    if x <= 1:
        return x
    return min(max(y, dfs(x - y) + 1) for y in range(1, x + 1))


class Solution:
    def twoEggDrop(self, n: int) -> int:
        return dfs(n)

# leetcode submit region end(Prohibit modification and deletion)
