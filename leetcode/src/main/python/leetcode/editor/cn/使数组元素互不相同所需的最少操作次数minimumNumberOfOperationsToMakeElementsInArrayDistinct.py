"""
Title: 3396.使数组元素互不相同所需的最少操作次数
Title Slug: minimumNumberOfOperationsToMakeElementsInArrayDistinct
Author: Neo
Date: 2025-04-08 12:59:17
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minimumOperations(self, nums: List[int]) -> int:
        st = set()
        n = len(nums)
        for i in range(n - 1, -1, -1):
            if nums[i] in st:
                return i // 3 + 1
            st.add(nums[i])

        return 0
# leetcode submit region end(Prohibit modification and deletion)
