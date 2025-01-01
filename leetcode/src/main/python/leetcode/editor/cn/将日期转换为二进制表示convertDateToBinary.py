"""
Title: 3280.将日期转换为二进制表示
Title Slug: convertDateToBinary
Author: Neo
Date: 2025-01-01 15:50:50
"""

# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def convertDateToBinary(self, date: str) -> str:
        def binary(s):
            return bin(int(s))[2:]

        return f"{binary(date[:4])}-{binary(date[5:7])}-{binary(date[8:])}"
# leetcode submit region end(Prohibit modification and deletion)

