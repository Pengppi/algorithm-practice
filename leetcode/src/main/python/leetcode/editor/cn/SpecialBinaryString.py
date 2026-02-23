"""
Title: 761.Special Binary String
Title Slug: specialBinaryString
Author: Neo
Date: 2026-02-20 11:12:24
"""


# https://leetcode.cn/problems/special-binary-string/solutions/3905099/ben-zhi-shi-he-fa-gua-hao-zi-fu-chuan-di-x6ci/
# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def makeLargestSpecial(self, s: str) -> str:
        if len(s) <= 2:
            return s

        validPieces = []
        start = diff = 0
        for i, c in enumerate(s):
            if c == "1":
                diff += 1
            else:
                diff -= 1
                if diff == 0:
                    validPieces.append(
                        "1" + self.makeLargestSpecial(s[start + 1 : i]) + "0"
                    )
                    start = i + 1

        validPieces.sort(reverse=True)
        return "".join(validPieces)


# leetcode submit region end(Prohibit modification and deletion)
