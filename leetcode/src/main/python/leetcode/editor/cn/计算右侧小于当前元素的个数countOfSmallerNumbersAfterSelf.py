"""
Title: 315.计算右侧小于当前元素的个数
Title Slug: countOfSmallerNumbersAfterSelf
Author: Neo
Date: 2024-05-05 14:38:42
"""
from bisect import bisect_right, bisect_left
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def countSmaller(self, nums: List[int]) -> List[int]:
        n = len(nums)
        ans = [0] * n
        sort_list = []
        for i in range(n - 1, -1, -1):
            if not sort_list:
                sort_list.append(nums[i])
            else:
                k = bisect_left(sort_list, nums[i], 0)
                ans[i] = k
                sort_list.insert(k, nums[i])
        return ans

# leetcode submit region end(Prohibit modification and deletion)
