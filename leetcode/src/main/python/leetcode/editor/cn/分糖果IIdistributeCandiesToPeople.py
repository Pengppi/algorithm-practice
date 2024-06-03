"""
Title: 1103.分糖果 II
Title Slug: distributeCandiesToPeople
Author: Neo
Date: 2024-06-03 15:06:36
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def distributeCandies(self, candies: int, num_people: int) -> List[int]:
        ans = [0 for _ in range(num_people)]
        cur, i = 1, 0
        while candies > 0:
            if cur > candies:
                ans[i] += candies
            else:
                ans[i] += cur
            candies -= cur
            cur += 1
            i = (i + 1) % num_people
        return ans
# leetcode submit region end(Prohibit modification and deletion)
