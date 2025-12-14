"""
Title: 3577.Count the Number of Computer Unlocking Permutations
Title Slug: countTheNumberOfComputerUnlockingPermutations
Author: Neo
Date: 2025-12-10 12:01:01
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:

    def countPermutations(self, complexity: List[int]) -> int:

        mod = 10**9 + 7
        ans = 1
        for i in range(1, len(complexity)):
            if complexity[0] >= complexity[i]:
                return 0
            ans *= i
            ans %= mod
        return ans


# leetcode submit region end(Prohibit modification and deletion)
