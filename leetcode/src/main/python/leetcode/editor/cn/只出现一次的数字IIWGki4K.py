"""
Title: LCR 004.只出现一次的数字 II
Title Slug: WGki4K
Author: Neo
Date: 2024-06-12 19:25:15
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        ans = 0
        for i in range(32):
            tot = sum((num >> i) & 1 for num in nums)
            if tot % 3:
                if i == 31:
                    ans -= (1 << i)
                else:
                    ans |= (1 << i)
        return ans
    # leetcode submit region end(Prohibit modification and deletion)
