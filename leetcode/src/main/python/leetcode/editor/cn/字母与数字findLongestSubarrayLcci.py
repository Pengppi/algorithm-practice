"""
Title: 面试题 17.05. 字母与数字
Title Slug: findLongestSubarrayLcci
Author: Neo
Date: 2025-03-24 12:46:21
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def findLongestSubarray(self, array: List[str]) -> List[str]:
        mp = dict()
        cur = 0
        mp[0] = 0
        l = r = 0
        for i, c in enumerate(array, 1):
            if c.isdigit():
                cur += 1
            else:
                cur -= 1
            if cur not in mp:
                mp[cur] = i
            elif i - mp[cur] > r - l:
                l, r = mp[cur], i

        return array[l:r]

# leetcode submit region end(Prohibit modification and deletion)
