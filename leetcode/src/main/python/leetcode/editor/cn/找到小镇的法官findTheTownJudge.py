"""
Title: 997.找到小镇的法官
Title Slug: findTheTownJudge
Author: Neo
Date: 2024-09-22 16:41:34
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        cnt = [0] * (n + 1)
        for a, b in trust:
            cnt[a] -= 1
            cnt[b] += 1
        for i in range(1, n + 1):
            if cnt[i] == n - 1:
                return i
        return -1
# leetcode submit region end(Prohibit modification and deletion)
