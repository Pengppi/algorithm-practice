"""
Title: 1394.Find Lucky Integer in an Array
Title Slug: findLuckyIntegerInAnArray
Author: Neo
Date: 2025-07-05 17:23:46
"""
from collections import defaultdict, Counter
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def findLucky(self, arr: List[int]) -> int:
        cnt = Counter(arr)
        ans = -1
        for x, c in cnt.items():
            if x == c:
                ans = max(ans, x)
        return ans
# leetcode submit region end(Prohibit modification and deletion)
