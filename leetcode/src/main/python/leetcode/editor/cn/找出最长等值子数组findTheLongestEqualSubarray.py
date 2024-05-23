"""
Title: 2831.找出最长等值子数组
Title Slug: findTheLongestEqualSubarray
Author: Neo
Date: 2024-05-23 21:53:17
"""
from collections import defaultdict
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def longestEqualSubarray(self, nums: List[int], k: int) -> int:
        pos_list = defaultdict(list)
        for i, x in enumerate(nums):
            pos_list[x].append(i - len(pos_list[x]))
        ans = 0
        for pos in pos_list.values():
            if len(pos) <= ans:
                continue
            left = 0
            for right, p in enumerate(pos):
                while p - pos[left] > k:
                    left += 1
                ans = max(ans, right - left + 1)
        return ans
# leetcode submit region end(Prohibit modification and deletion)
