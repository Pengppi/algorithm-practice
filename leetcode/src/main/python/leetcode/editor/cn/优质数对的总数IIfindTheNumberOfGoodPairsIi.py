"""
Title: 3164.优质数对的总数 II
Title Slug: findTheNumberOfGoodPairsIi
Author: Neo
Date: 2024-10-11 13:11:49
"""
from collections import Counter
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def numberOfPairs(self, nums1: List[int], nums2: List[int], k: int) -> int:
        cnt1 = Counter(nums1)
        cnt2 = Counter(nums2)
        mx = max(cnt1)
        ans = 0
        for x, cnt in cnt2.items():
            s = sum(cnt1[y] for y in range(x * k, mx + 1, x * k))
            ans += s * cnt
        return ans
# leetcode submit region end(Prohibit modification and deletion)
