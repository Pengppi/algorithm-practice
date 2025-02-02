"""
Title: 219.存在重复元素 II
Title Slug: containsDuplicateIi
Author: Neo
Date: 2025-01-29 10:51:16
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        st = set()
        for i, x in enumerate(nums):
            if i > k:
                st.remove(nums[i - k - 1])
            if x in st:
                return True
            st.add(x)
        return False
# leetcode submit region end(Prohibit modification and deletion)

