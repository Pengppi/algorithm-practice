"""
Title: 2138.将字符串拆分为若干长度为 k 的组
Title Slug: divideAStringIntoGroupsOfSizeK
Author: Neo
Date: 2025-06-22 22:08:12
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def divideString(self, s: str, k: int, fill: str) -> List[str]:
        ans = []
        for i in range(0, len(s), k):
            if i + k > len(s):
                ans.append(s[i:] + fill * (k - len(s[i:])))
                break
            ans.append(s[i:i + k])

        return ans
# leetcode submit region end(Prohibit modification and deletion)
