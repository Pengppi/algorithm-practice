"""
Title: 3340.检查平衡字符串
Title Slug: checkBalancedString
Author: Neo
Date: 2025-03-14 13:32:20
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def isBalanced(self, num: str) -> bool:
        ans = 0
        for i, c in enumerate(num):
            if i & 1:
                ans += int(c)
            else:
                ans -= int(c)
        return ans == 0
# leetcode submit region end(Prohibit modification and deletion)
