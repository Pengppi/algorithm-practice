"""
Title: 1338.数组大小减半
Title Slug: reduceArraySizeToTheHalf
Author: Neo
Date: 2024-12-15 12:20:38
"""
import heapq
from collections import Counter
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minSetSize(self, arr: List[int]) -> int:
        target = len(arr) // 2
        q = [-c for c in Counter(arr).values()]
        heapq.heapify(q)
        ans = 0
        while target > 0:
            target += heapq.heappop(q)
            ans += 1
        return ans

# leetcode submit region end(Prohibit modification and deletion)
