"""
Title: 3228.Maximum Number of Operations to Move Ones to the End
Title Slug: maximumNumberOfOperationsToMoveOnesToTheEnd
Author: Neo
Date: 2025-11-13 12:38:39
"""
from itertools import pairwise


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxOperations(self, s: str) -> int:
        arr = [int(s[0])]
        for i, c in enumerate(s[1:], 1):
            if c == '0':
                continue
            if s[i - 1] == '1':
                arr[-1] += 1
            else:
                arr.append(1)

        start = len(arr) - 1 if s[-1] == '0' else len(arr) - 2

        ans = 0
        mv = 1
        for i in range(start, -1, -1):
            ans += arr[i] * mv
            mv += 1
        return ans


# leetcode submit region end(Prohibit modification and deletion)

Solution().maxOperations("1001101")
"""
10201
+2 10021

"""
