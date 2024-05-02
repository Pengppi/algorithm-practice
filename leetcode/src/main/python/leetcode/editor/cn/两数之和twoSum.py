"""
Title: 1.两数之和
Title Slug: twoSum
Author: Neo
Date: 2024-05-02 20:24:18
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hashmap = dict()
        for i, num in enumerate(nums):
            if target - num in hashmap:
                return [hashmap[target - num], i]
            hashmap[num] = i
        return []
# leetcode submit region end(Prohibit modification and deletion)
