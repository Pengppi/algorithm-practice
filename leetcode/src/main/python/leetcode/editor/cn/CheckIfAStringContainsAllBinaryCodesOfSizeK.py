"""
Title: 1461.Check If a String Contains All Binary Codes of Size K
Title Slug: checkIfAStringContainsAllBinaryCodesOfSizeK
Author: Neo
Date: 2026-02-23 11:18:23
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def hasAllCodes(self, s: str, k: int) -> bool:
        bs = {s[i - k : i] for i in range(k, len(s) + 1)}
        return len(bs) == 1 << k


# leetcode submit region end(Prohibit modification and deletion)

Solution().hasAllCodes("00110110", 2)
