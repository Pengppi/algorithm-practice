"""
Title: 1552.两球之间的磁力
Title Slug: magneticForceBetweenTwoBalls
Author: Neo
Date: 2025-02-14 13:19:47
"""
import bisect
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxDistance(self, position: List[int], m: int) -> int:
        position.sort()
        n = len(position)

        def check(x):
            cnt = 1
            last = position[0]
            for i in range(1, n):
                if position[i] - last >= x:
                    last = position[i]
                    cnt += 1
                    if cnt >= m:
                        return True
            return False


        l = 1
        r = position[-1] - position[0]
        while l < r:
            mid = (l + r + 1) >> 1
            if check(mid):
                l = mid
            else:
                r = mid - 1
        return  l
# leetcode submit region end(Prohibit modification and deletion)
Solution().maxDistance(position = [1,2,3,4,7], m = 3)