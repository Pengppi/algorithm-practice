"""
Title: 552.学生出勤记录 II
Title Slug: studentAttendanceRecordIi
Author: Neo
Date: 2024-08-19 12:36:15
"""
from functools import cache

# leetcode submit region begin(Prohibit modification and deletion)

mod = 10 ** 9 + 7
@cache
def dfs(step, a_cnt, l_last):
    if step == 0:
        return 1
    res = dfs(step - 1, a_cnt, 0)
    if a_cnt < 1:
        res = (dfs(step - 1, a_cnt + 1, 0) + res) % mod
    if l_last < 2:
        res = (dfs(step - 1, a_cnt, l_last + 1) + res) % mod
    return res % mod


class Solution:
    def checkRecord(self, n: int) -> int:
        return dfs(n, 0, 0)
# leetcode submit region end(Prohibit modification and deletion)
