"""
Title: 3397.Maximum Number of Distinct Elements After Operations
Title Slug: maximumNumberOfDistinctElementsAfterOperations
Author: Neo
Date: 2025-10-18 15:35:15
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxDistinctElements(self, nums: List[int], k: int) -> int:
        nums.sort()
        nums[0] = nums[0] - k
        ans = 1
        for i in range(1, len(nums)):
            last = nums[i - 1]
            cur = max(last + 1, nums[i] - k)
            if cur > nums[i] + k:
                nums[i] = last
                continue
            nums[i] = cur
            ans += 1
        return ans


# leetcode submit region end(Prohibit modification and deletion)


Solution().maxDistinctElements([1, 1, 1, 2, 2, 2, 4, 4, 4, 4], 2)
