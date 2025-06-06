"""
Title: 2942.查找包含给定字符的单词
Title Slug: findWordsContainingCharacter
Author: Neo
Date: 2025-05-24 12:19:33
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def findWordsContaining(self, words: List[str], x: str) -> List[int]:
        return [i for i, w in enumerate(words) if x in w]

# leetcode submit region end(Prohibit modification and deletion)
