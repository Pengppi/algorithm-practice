"""
Title: 2873.有序三元组中的最大值 I
Title Slug: maximumValueOfAnOrderedTripletI
Author: Neo
Date: 2025-04-02 15:30:02
"""
from cmath import inf
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maximumTripletValue(self, nums: List[int]) -> int:
        n = len(nums)
        mx = nums[0]
        mx_ij = -inf
        ans = 0
        for i in range(1, n):
            if i > 1:
                ans = max(ans, mx_ij * nums[i])
            mx_ij = max(mx_ij, mx - nums[i])
            mx = max(mx, nums[i])
        return ans

# leetcode submit region end(Prohibit modification and deletion)
