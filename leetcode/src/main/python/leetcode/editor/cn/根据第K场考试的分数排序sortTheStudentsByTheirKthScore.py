"""
Title: 2545.根据第 K 场考试的分数排序
Title Slug: sortTheStudentsByTheirKthScore
Author: Neo
Date: 2024-12-21 20:37:28
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def sortTheStudents(self, score: List[List[int]], k: int) -> List[List[int]]:
        return sorted(score, key=lambda row: -row[k])
# leetcode submit region end(Prohibit modification and deletion)
