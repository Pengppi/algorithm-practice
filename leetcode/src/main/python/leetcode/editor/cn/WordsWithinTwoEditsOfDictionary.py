"""
Title: 2452.Words Within Two Edits of Dictionary
Title Slug: wordsWithinTwoEditsOfDictionary
Author: Neo
Date: 2026-04-22 18:37:10
"""

from sre_parse import FAILURE
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)


class Solution:
    def twoEditWords(self, queries: List[str], dictionary: List[str]) -> List[str]:
        res = []

        for q in queries:
            for d in dictionary:
                diff = 0
                for i in range(len(q)):
                    if q[i] != d[i]:
                        diff += 1
                        if diff > 2:
                            break
                if diff <= 2:
                    res.append(q)
                    break

        return res


# leetcode submit region end(Prohibit modification and deletion)
Solution().twoEditWords(["word", "note", "ants", "wood"], ["wood", "joke", "moat"])
