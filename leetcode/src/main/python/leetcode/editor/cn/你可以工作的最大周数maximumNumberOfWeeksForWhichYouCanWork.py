"""
Title: 1953.你可以工作的最大周数
Title Slug: maximumNumberOfWeeksForWhichYouCanWork
Author: Neo
Date: 2024-05-16 21:08:44
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def numberOfWeeks(self, milestones: List[int]) -> int:
        s = sum(milestones)
        m = max(milestones)
        return (s - m) * 2 + 1 if m > s - m + 1 else s
# leetcode submit region end(Prohibit modification and deletion)
