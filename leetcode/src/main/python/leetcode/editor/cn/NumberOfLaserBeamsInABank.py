"""
Title: 2125.Number of Laser Beams in a Bank
Title Slug: numberOfLaserBeamsInABank
Author: Neo
Date: 2025-10-27 18:45:51
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def numberOfBeams(self, bank: List[str]) -> int:
        ans = 0
        cnt = 0
        for row in bank:
            cur_cnt = 0
            for c in row:
                if c == '1':
                    cur_cnt += 1
            if cur_cnt > 0:
                ans += cnt * cur_cnt
                cnt = cur_cnt
        return ans

# leetcode submit region end(Prohibit modification and deletion)
