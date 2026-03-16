"""
Title: 1415.The k-th Lexicographical String of All Happy Strings of Length n
Title Slug: theKThLexicographicalStringOfAllHappyStringsOfLengthN
Author: Neo
Date: 2026-03-14 17:37:24
"""

# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def getHappyString(self, n: int, k: int) -> str:
        rule = ['a','b','c']
        valid = []

        def build(path:str)->None:
            if len(path) == n:
                valid.append(path)
                return
            for c in rule:
                if path[-1] != c:
                    build(path+c)

        for c in rule:
            build(c)

        if len(valid) >= k:
            return valid[k-1]
        else:
            return ''







# leetcode submit region end(Prohibit modification and deletion)
