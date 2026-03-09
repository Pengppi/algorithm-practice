"""
Title: 1980.Find Unique Binary String
Title Slug: findUniqueBinaryString
Author: Neo
Date: 2026-03-08 13:31:12
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def findDifferentBinaryString(self, nums: List[str]) -> str:
        st = {int(s, 2) for s in nums}

        ans = 0
        while ans in st:
            ans += 1

        n = len(nums)
        return f"{ans:0{n}b}"
# leetcode submit region end(Prohibit modification and deletion)

