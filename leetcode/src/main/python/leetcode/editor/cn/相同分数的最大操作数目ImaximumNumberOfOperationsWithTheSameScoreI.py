"""
Title: 3038.相同分数的最大操作数目 I
Title Slug: maximumNumberOfOperationsWithTheSameScoreI
Author: Neo
Date: 2024-06-07 10:46:33
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxOperations(self, nums: List[int]) -> int:
        if len(nums) < 2:
            return 0
        ans, last = 1, nums.pop(0) + nums.pop(0)
        while len(nums) >= 2:
            cur = nums.pop(0) + nums.pop(0)
            if cur != last:
                return ans
            ans += 1
        return ans
# leetcode submit region end(Prohibit modification and deletion)
