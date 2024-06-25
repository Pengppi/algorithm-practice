"""
Title: 503.下一个更大元素 II
Title Slug: nextGreaterElementIi
Author: Neo
Date: 2024-06-24 12:29:20
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        n = len(nums)
        ans, st = [-1] * n, []
        for i in range(n * 2):
            while st and nums[st[-1]] < nums[i % n]:
                small_one = st.pop()
                ans[small_one] = nums[i % n]
            st.append(i % n)

        return ans

# leetcode submit region end(Prohibit modification and deletion)
