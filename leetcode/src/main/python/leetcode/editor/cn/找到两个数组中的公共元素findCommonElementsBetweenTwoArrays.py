"""
Title: 2956.找到两个数组中的公共元素
Title Slug: findCommonElementsBetweenTwoArrays
Author: Neo
Date: 2024-07-16 12:44:33
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def findIntersectionValues(self, nums1: List[int], nums2: List[int]) -> List[int]:
        ans1, ans2 = 0, 0
        st1, st2 = set(nums1), set(nums2)
        for num in nums1:
            if num in st2:
                ans1 += 1
        for num in nums2:
            if num in st1:
                ans2 += 1
        return [ans1, ans2]

# leetcode submit region end(Prohibit modification and deletion)
