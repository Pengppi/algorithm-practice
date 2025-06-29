"""
Title: 2566.替换一个数字后的最大差值
Title Slug: maximumDifferenceByRemappingADigit
Author: Neo
Date: 2025-06-14 21:35:50
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minMaxDifference(self, num: int) -> int:
        s = str(num)
        mx = num
        for c in s:
            if c != '9':
                mx = int(s.replace(c, '9'))
                break
        mn = int(s.replace(s[0], '0'))
        return mx - mn
# leetcode submit region end(Prohibit modification and deletion)
