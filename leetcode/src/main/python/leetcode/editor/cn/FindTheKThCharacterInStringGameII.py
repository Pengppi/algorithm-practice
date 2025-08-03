"""
Title: 3307.Find the K-th Character in String Game II
Title Slug: findTheKThCharacterInStringGameIi
Author: Neo
Date: 2025-07-04 20:09:16
"""
from string import ascii_lowercase
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def kthCharacter(self, k: int, operations: List[int]) -> str:
        n = len(operations)
        if not n:
            return 'a'
        m = 1 << (n - 1)
        if k <= m:
            return self.kthCharacter(k, operations[:-1])
        ans = self.kthCharacter(k - m, operations[:-1])
        return ascii_lowercase[(ord(ans) - ord('a') + operations[-1]) % 26]
# leetcode submit region end(Prohibit modification and deletion)
