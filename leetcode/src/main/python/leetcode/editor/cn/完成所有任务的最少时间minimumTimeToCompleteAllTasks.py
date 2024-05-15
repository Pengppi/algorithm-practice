"""
Title: 2589.完成所有任务的最少时间
Title Slug: minimumTimeToCompleteAllTasks
Author: Neo
Date: 2024-05-15 00:19:55
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def findMinimumTime(self, tasks: List[List[int]]) -> int:
        ans, m = 0, max(tasks, key=lambda x: x[1])[1]
        for i in range(1, m + 1):
            run = False
            for s, e, d in tasks:
                if d > 0 and e - i + 1 == d:
                    run = True
                    break
            if run:
                for task in tasks:
                    if task[0] <= i <= task[1] and task[2] > 0:
                        task[2] -= 1
                ans += 1
        return ans
# leetcode submit region end(Prohibit modification and deletion)
