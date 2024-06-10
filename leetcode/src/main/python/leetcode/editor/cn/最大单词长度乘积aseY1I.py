"""
Title: LCR 005.最大单词长度乘积
Title Slug: aseY1I
Author: Neo
Date: 2024-06-10 13:29:59
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxProduct(self, words: List[str]) -> int:
        words.sort(key=lambda x: -len(x))
        ans, n = 0, len(words)
        masks = []
        for word in words:
            mask = 0
            for c in word:
                mask |= 1 << (ord(c) - ord('a'))
            for i in range(len(masks)):
                score = len(word) * len(words[i])
                if score <= ans:
                    break
                elif mask & masks[i] == 0:
                    ans = score
            masks.append(mask)
        return ans
# leetcode submit region end(Prohibit modification and deletion)
