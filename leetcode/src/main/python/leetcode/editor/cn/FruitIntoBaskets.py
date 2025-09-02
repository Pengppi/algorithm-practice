"""
Title: 904.Fruit Into Baskets
Title Slug: fruitIntoBaskets
Author: Neo
Date: 2025-08-04 18:22:30
"""
from collections import deque
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def totalFruit(self, fruits: List[int]) -> int:
        d = deque()
        ans = l = 0
        for r, x in enumerate(fruits):
            if x in d:
                d.remove(x)
            d.append(x)
            if len(d) > 2:
                rm = d.popleft()
                l = r
                while fruits[l - 1] != rm:
                    l -= 1
            ans = max(ans, r - l + 1)
        return ans

# leetcode submit region end(Prohibit modification and deletion)
