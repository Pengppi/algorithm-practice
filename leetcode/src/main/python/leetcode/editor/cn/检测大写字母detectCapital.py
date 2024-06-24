"""
Title: 520.检测大写字母
Title Slug: detectCapital
Author: Neo
Date: 2024-06-23 10:16:43
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def detectCapitalUse(self, word: str) -> bool:
        return True if word.isupper() or word.islower() or word.istitle() else False
    # leetcode submit region end(Prohibit modification and deletion)
