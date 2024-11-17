"""
Title: 825.适龄的朋友
Title Slug: friendsOfAppropriateAges
Author: Neo
Date: 2024-11-17 20:03:01
"""
from bisect import bisect_left, bisect_right
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def numFriendRequests(self, ages: List[int]) -> int:
        ages.sort()
        ans = 0
        for i in range(1, len(ages)):
            x = ages[i]
            j = bisect_right(ages, x // 2 + 7, hi=i)
            k = bisect_left(ages, x, j, i)
            ans += i - j + i - k
        return ans
    # leetcode submit region end(Prohibit modification and deletion)
