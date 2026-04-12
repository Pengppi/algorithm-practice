"""
Title: 1320.Minimum Distance to Type a Word Using Two Fingers
Title Slug: minimumDistanceToTypeAWordUsingTwoFingers
Author: Neo
Date: 2026-04-12 10:52:46
"""
from functools import cache
from math import inf
from string import ascii_uppercase


# leetcode submit region begin(Prohibit modification and deletion)

coordinate = dict()
for i, e in enumerate(ascii_uppercase):
    coordinate[e] = (i // 6, i % 6)


@cache
def dist(letter1, letter2):
    x1, y1 = coordinate[letter1]
    x2, y2 = coordinate[letter2]
    return abs(x1 - x2) + abs(y1 - y2)

class Solution:
    def minimumDistance(self, word: str) -> int:


        @cache
        def dfs(curIndex: int, finger1: str, finger2: str) -> int:
            if curIndex < 0:
                return 0
            cur = word[curIndex]
            res = dfs(curIndex - 1, cur, finger2) + dist(cur, finger1)
            res = min(res, dfs(curIndex - 1, finger1, cur) + dist(cur, finger2))
            return res

        ans = inf
        for e in ascii_uppercase:
            ans = min(ans, dfs(len(word) - 1, word[-1], e))

        dfs.cache_clear()
        return ans
# leetcode submit region end(Prohibit modification and deletion)
