"""
Title: 1673.找出最具竞争力的子序列
Title Slug: findTheMostCompetitiveSubsequence
Author: Neo
Date: 2024-05-24 21:53:24
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def mostCompetitive(self, nums: List[int], k: int) -> List[int]:
        st = []
        for i, x in enumerate(nums):
            if len(st) + len(nums) - i == k:
                return st + nums[i:]
            while st and st[-1] > x:
                del st[-1]
                if len(st) + len(nums) - i == k:
                    return st + nums[i:]
            st.append(x)
        return st[:k]
# leetcode submit region end(Prohibit modification and deletion)
