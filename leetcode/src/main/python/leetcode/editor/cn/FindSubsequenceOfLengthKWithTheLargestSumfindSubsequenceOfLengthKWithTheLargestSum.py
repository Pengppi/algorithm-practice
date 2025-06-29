"""
Title: 2099.Find Subsequence of Length K With the Largest Sum
Title Slug: findSubsequenceOfLengthKWithTheLargestSum
Author: Neo
Date: 2025-06-28 11:54:21
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxSubsequence(self, nums: List[int], k: int) -> List[int]:
        sorted_ids = sorted(range(len(nums)), key=lambda i: nums[i])
        need_ids = sorted_ids[-k:]
        return [x for i,x in enumerate(nums) if i in need_ids]

# leetcode submit region end(Prohibit modification and deletion)
