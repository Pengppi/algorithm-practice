"""
Title: 1652.拆炸弹
Title Slug: defuseTheBomb
Author: Neo
Date: 2024-05-05 14:08:17
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def decrypt(self, code: List[int], k: int) -> List[int]:
        n = len(code)
        ans = [0] * n
        r = k + 1 if k > 0 else n
        k = abs(k)
        s = sum(code[r - k:r])
        for i in range(n):
            ans[i] = s
            s += code[r % n] - code[(r - k) % n]
            r += 1

        return ans

# leetcode submit region end(Prohibit modification and deletion)
