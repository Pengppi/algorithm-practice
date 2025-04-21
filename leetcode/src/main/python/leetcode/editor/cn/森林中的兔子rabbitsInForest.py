"""
Title: 781.森林中的兔子
Title Slug: rabbitsInForest
Author: Neo
Date: 2025-04-20 12:49:57
"""
from collections import Counter
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def numRabbits(self, answers: List[int]) -> int:
        cnt = Counter(answers)
        ans = 0
        for k, c in cnt.items():
            ans += (c + k) // (k + 1) * (k + 1)

        return ans
# leetcode submit region end(Prohibit modification and deletion)
