"""
Title: LCR 010.和为 K 的子数组
Title Slug: QTMn0o
Author: Neo
Date: 2024-10-02 15:03:55
"""
from collections import defaultdict
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        ans = 0
        mp = defaultdict(int)
        mp[0] = 1
        s = 0
        for x in nums:
            s += x
            ans += mp[s - k]
            mp[s] += 1
        return ans
# leetcode submit region end(Prohibit modification and deletion)
