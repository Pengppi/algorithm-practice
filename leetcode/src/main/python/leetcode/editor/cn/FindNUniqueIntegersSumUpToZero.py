"""
Title: 1304.Find N Unique Integers Sum up to Zero
Title Slug: findNUniqueIntegersSumUpToZero
Author: Neo
Date: 2025-09-07 11:24:05
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def sumZero(self, n: int) -> List[int]:
        m = n // 2
        if n % 2 == 1:
            return [i for i in range(-m, m + 1)]
        else:
            return [i for i in range(-m, m + 1) if i != 0]

# leetcode submit region end(Prohibit modification and deletion)
