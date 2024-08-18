"""
Title: 551.学生出勤记录 I
Title Slug: studentAttendanceRecordI
Author: Neo
Date: 2024-08-18 10:28:46
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def checkRecord(self, s: str) -> bool:
        last = 0
        a_cnt = 0
        for c in s:
            if c == 'L':
                last += 1
                if last == 3:
                    return False
                continue
            last = 0
            if c == 'A':
                a_cnt += 1
        return a_cnt < 2
# leetcode submit region end(Prohibit modification and deletion)
