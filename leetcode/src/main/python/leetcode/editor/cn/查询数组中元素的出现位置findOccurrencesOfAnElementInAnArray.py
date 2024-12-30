"""
Title: 3159.查询数组中元素的出现位置
Title Slug: findOccurrencesOfAnElementInAnArray
Author: Neo
Date: 2024-12-27 12:20:22
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def occurrencesOfElement(self, nums: List[int], queries: List[int], x: int) -> List[int]:
        pos = [i for i, num in enumerate(nums) if num == x]
        ans = [-1] * len(queries)
        for i, q in enumerate(queries):
            if q > len(pos):
                continue
            ans[i] = pos[q - 1]
        return ans

# leetcode submit region end(Prohibit modification and deletion)
