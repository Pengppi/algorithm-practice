"""
Title: 3542.Minimum Operations to Convert All Elements to Zero
Title Slug: minimumOperationsToConvertAllElementsToZero
Author: Neo
Date: 2025-11-10 12:30:47
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minOperations(self, nums: List[int]) -> int:
        st = []
        ans = 0
        for x in nums:
            while st and x < st[-1]:
                del st[-1]
                ans += 1
            if not st or x != st[-1]:
                st.append(x)
        return ans + len(st) - (st[0] == 0)

        # leetcode submit region end(Prohibit modification and deletion)


Solution().minOperations([2, 4, 5])
