"""
Title: 2327.Number of People Aware of a Secret
Title Slug: numberOfPeopleAwareOfASecret
Author: Neo
Date: 2025-09-09 12:31:33
"""
from collections import deque


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def peopleAwareOfSecret(self, n: int, delay: int, forget: int) -> int:
        mod = 10 ** 9 + 7
        f = [0] * n
        f[0] = 1
        for i in range(n):
            f[i] %= mod
            for j in range(i + delay, min(i + forget, n)):
                f[j] += f[i]
        return sum(f[-forget:]) % mod
# leetcode submit region end(Prohibit modification and deletion)
