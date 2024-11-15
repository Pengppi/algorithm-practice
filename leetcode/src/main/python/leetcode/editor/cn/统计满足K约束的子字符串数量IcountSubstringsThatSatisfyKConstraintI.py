"""
Title: 3258.统计满足 K 约束的子字符串数量 I
Title Slug: countSubstringsThatSatisfyKConstraintI
Author: Neo
Date: 2024-11-12 12:47:02
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def countKConstraintSubstrings(self, s: str, k: int) -> int:
        ans = 0
        l = 0
        o_cnt = 0
        i_cnt = 0
        for r, c in enumerate(s):
            if c == '0':
                o_cnt += 1
            else:
                i_cnt += 1
            while o_cnt > k and i_cnt > k:
                if s[l] == '0':
                    o_cnt -= 1
                else:
                    i_cnt -= 1
                l += 1
            ans += r - l + 1

        return ans
# leetcode submit region end(Prohibit modification and deletion)


Solution().countKConstraintSubstrings("10101",1)