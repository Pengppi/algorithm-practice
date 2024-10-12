"""
Title: 3162.优质数对的总数 I
Title Slug: findTheNumberOfGoodPairsI
Author: Neo
Date: 2024-10-10 12:47:31
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
