"""
Title: 1450.在既定时间做作业的学生人数
Title Slug: numberOfStudentsDoingHomeworkAtAGivenTime
Author: Neo
Date: 2024-09-01 00:40:23
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def busyStudent(self, startTime: List[int], endTime: List[int], queryTime: int) -> int:
        return sum(start <= queryTime <= end for start, end in zip(startTime, endTime))

# leetcode submit region end(Prohibit modification and deletion)
