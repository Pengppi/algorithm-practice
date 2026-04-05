"""
Title: 2751.Robot Collisions
Title Slug: robotCollisions
Author: Neo
Date: 2026-04-01 20:52:37
"""

# leetcode submit region begin(Prohibit modification and deletion)
from collections import deque
from typing import List


class Solution:
    def survivedRobotsHealths(
        self, positions: List[int], healths: List[int], directions: str
    ) -> List[int]:
        n = len(positions)
        ids = list(range(n))
        ids.sort(key=lambda id: positions[id])

        q = deque()
        k = 0
        while k < n:
            i = ids[k]
            k += 1
            if directions[i] == "R":
                q.append(i)
            else:
                if not q:
                    continue
                while q:
                    j = q[-1]
                    if healths[j] > healths[i]:
                        healths[i] = 0
                        healths[j] -= 1
                        break
                    elif healths[j] < healths[i]:
                        healths[j] = 0
                        healths[i] -= 1
                        q.pop()
                    else:
                        healths[i] = 0
                        healths[j] = 0
                        q.pop()
                        break

        return [healths[i] for i in range(n) if healths[i] > 0]


# leetcode submit region end(Prohibit modification and deletion)
Solution().survivedRobotsHealths([3,5,2,6],[10,10,15,12],"RLRL")
