"""
Title: 2211.Count Collisions on a Road
Title Slug: countCollisionsOnARoad
Author: Neo
Date: 2025-12-04 21:09:46
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:

    def countCollisions(self, directions: str) -> int:
        baffle = 0
        r_cnt = 0
        ans = 0
        for d in directions:
            if d == 'R':
                r_cnt += 1
                baffle = 0
            elif d == 'S':
                ans += r_cnt
                baffle = 1
                r_cnt = 0
            else:
                if r_cnt > 0:
                    ans += r_cnt + 1
                    r_cnt = 0
                    baffle = 1
                elif baffle == 1:
                    ans += 1
        return ans


# leetcode submit region end(Prohibit modification and deletion)

Solution().countCollisions("RLRSLL")
