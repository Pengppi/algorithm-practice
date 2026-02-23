"""
Title: 401.Binary Watch
Title Slug: binaryWatch
Author: Neo
Date: 2026-02-17 21:34:59
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def readBinaryWatch(self, turnedOn: int) -> List[str]:
        ans = []
        for h in range(12):
            for m in range(60):
                if h.bit_count() + m.bit_count() == turnedOn:
                    ans.append(f"{h}:{m:02d}")
        return ans

# leetcode submit region end(Prohibit modification and deletion)

