"""
Title: 2071.你可以安排的最多任务数目
Title Slug: maximumNumberOfTasksYouCanAssign
Author: Neo
Date: 2025-05-01 18:19:30
"""
import bisect
from collections import deque
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxTaskAssign(self, tasks: List[int], workers: List[int], pills: int, strength: int) -> int:
        n, m = len(tasks), len(workers)
        tasks.sort()
        workers.sort()

        def check(k: int) -> bool:
            i = 0
            p = pills
            q = deque()

            for w in workers[-k:]:
                while i < k and w + strength >= tasks[i]:
                    q.append(tasks[i])
                    i += 1
                if not q:
                    return False
                if w >= q[0]:
                    q.popleft()
                elif p:
                    p -= 1
                    q.pop()
                else:
                    return False

            return True

        l = 0
        r = min(n, m) + 1
        while l + 1 < r:
            mid = (l + r) // 2
            if check(mid):
                l = mid
            else:
                r = mid
        return l

    # leetcode submit region end(Prohibit modification and deletion)
