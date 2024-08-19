"""
Title: 3152.特殊数组 II
Title Slug: specialArrayIi
Author: Neo
Date: 2024-08-14 12:20:15
"""
import bisect
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def isArraySpecial(self, nums: List[int], queries: List[List[int]]) -> List[bool]:
        index = []
        f = nums[0] & 1
        for i, x in enumerate(nums):
            if x & 1 != f:
                index.append(i)
            else:
                f ^= 1

        ans = []

        for x, y in queries:
            res = True
            i = bisect.bisect_left(index, x)
            while i < len(index) and index[i] <= y:
                if index[i] > x:
                    res = False
                    break
                i += 1
            ans.append(res)
        return ans


# leetcode submit region end(Prohibit modification and deletion)
Solution().isArraySpecial([3,4,1,2,6], [[0, 4]])
