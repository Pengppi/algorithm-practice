"""
Title: 2974.最小数字游戏
Title Slug: minimumNumberGame
Author: Neo
Date: 2024-07-12 13:15:17
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def numberGame(self, nums: List[int]) -> List[int]:
        nums.sort()
        ans = []
        while nums:
            a, b = nums.pop(0), nums.pop(0)
            ans.append(b)
            ans.append(a)
        return ans
# leetcode submit region end(Prohibit modification and deletion)
