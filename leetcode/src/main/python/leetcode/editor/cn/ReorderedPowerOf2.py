"""
Title: 869.Reordered Power of 2
Title Slug: reorderedPowerOf2
Author: Neo
Date: 2025-08-10 11:14:52
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def reorderedPowerOf2(self, n: int) -> bool:
        t = ''.join(sorted(list(str(n))))
        for i in range(32):
            if ''.join(sorted(list(str(1<<i)))) == t:
                return True
        return False
# leetcode submit region end(Prohibit modification and deletion)
