"""
Title: 350.两个数组的交集 II
Title Slug: intersectionOfTwoArraysIi
Author: Neo
Date: 2025-01-30 19:45:02
"""
from collections import Counter
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        cnt1 = Counter(nums1)
        cnt2 = Counter(nums2)
        ans = []
        for k, v in cnt1.items():
            if k in cnt2:
                cnt = min(v, cnt2[k])
                for _ in range(cnt):
                    ans.append(k)
        return ans
# leetcode submit region end(Prohibit modification and deletion)

