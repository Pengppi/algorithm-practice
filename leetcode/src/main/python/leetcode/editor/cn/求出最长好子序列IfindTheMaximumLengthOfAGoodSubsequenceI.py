"""
Title: 3176.求出最长好子序列 I
Title Slug: findTheMaximumLengthOfAGoodSubsequenceI
Author: Neo
Date: 2024-09-06 13:19:47
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maximumLength(self, nums: List[int], k: int) -> int:
        n = len(nums)
        ans = 1
        f = [[0] * (k + 1) for _ in range(n)]
        for i in range(n):
            f[i][0] = 1
            for j in range(i):
                for l in range(k + 1):
                    if nums[i] == nums[j]:
                        f[i][l] = max(f[i][l], f[j][l] + 1)
                    elif l > 0:
                        f[i][l] = max(f[i][l], f[j][l - 1] + 1)
                    ans = max(ans, f[i][l])
        return ans

# leetcode submit region end(Prohibit modification and deletion)
