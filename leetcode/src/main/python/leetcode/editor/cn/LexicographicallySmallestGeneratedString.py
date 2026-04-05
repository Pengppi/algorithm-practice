"""
Title: 3474.Lexicographically Smallest Generated String
Title Slug: lexicographicallySmallestGeneratedString
Author: Neo
Date: 2026-03-31 12:20:26
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def generateString(self, str1: str, str2: str) -> str:
        n, m = len(str1), len(str2)
        word = [""] * (n + m - 1)
        s1 = list(str1)
        s2 = list(str2)
        for i in range(n - 1, -1, -1):
            if s1[i] == "T":
                for j in range(m):
                    k = i + j
                    if word[k] != "" and word[k] != s2[j]:
                        return ""
                    word[k] = s2[j]

        unfill = {i for i, c in enumerate(word) if c == ""}

        word = ["a" if c == "" else c for c in word]

        for i in range(n):
            if s1[i] == "F":
                if word[i : i + m] != s2:
                    continue
                for j in range(i + m - 1, i - 1, -1):
                    if j in unfill:
                        word[j] = "b"
                        break
                else:
                    return ""

        return "".join(word)


# leetcode submit region end(Prohibit modification and deletion)
