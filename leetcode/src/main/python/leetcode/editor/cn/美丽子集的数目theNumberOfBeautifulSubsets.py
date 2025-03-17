"""
Title: 2597.美丽子集的数目
Title Slug: theNumberOfBeautifulSubsets
Author: Neo
Date: 2025-03-07 12:22:20
"""
from collections import defaultdict
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def beautifulSubsets(self, nums: List[int], k: int) -> int:
        ans = -1
        cnt = defaultdict(int)

        def dfs(i):
            if i == len(nums):
                nonlocal ans
                ans += 1
                return
            dfs(i + 1)
            x = nums[i]
            if cnt[x - k] == 0 and cnt[x + k] == 0:
                cnt[x] += 1
                dfs(i + 1)
                cnt[x] -= 1

        dfs(0)
        return ans

        # leetcode submit region end(Prohibit modification and deletion)


Solution().beautifulSubsets([2, 4, 6], 2)
