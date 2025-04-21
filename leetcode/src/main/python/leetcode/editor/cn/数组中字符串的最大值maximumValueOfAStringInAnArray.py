"""
Title: 2496.数组中字符串的最大值
Title Slug: maximumValueOfAStringInAnArray
Author: Neo
Date: 2025-04-19 17:57:27
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maximumValue(self, strs: List[str]) -> int:
        return max(int(s) if s.isdigit() else len(s) for s in strs)
# leetcode submit region end(Prohibit modification and deletion)
