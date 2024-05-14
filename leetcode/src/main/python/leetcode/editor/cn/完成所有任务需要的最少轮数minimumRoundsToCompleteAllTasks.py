"""
Title: 2244.完成所有任务需要的最少轮数
Title Slug: minimumRoundsToCompleteAllTasks
Author: Neo
Date: 2024-05-14 00:14:29
"""
from collections import Counter
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minimumRounds(self, tasks: List[int]) -> int:
        cnt = Counter(tasks)
        ans = 0
        for x in cnt:
            y = cnt[x]
            if y == 1:
                return -1
            if y % 3 == 0:
                ans += y // 3
            else:
                ans += y // 3 + 1
        return ans
# leetcode submit region end(Prohibit modification and deletion)
