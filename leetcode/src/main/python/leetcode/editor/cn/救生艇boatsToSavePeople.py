"""
Title: 881.救生艇
Title Slug: boatsToSavePeople
Author: Neo
Date: 2024-06-10 12:41:35
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def numRescueBoats(self, people: List[int], limit: int) -> int:
        people.sort()
        ans, l, r = 0, 0, len(people) - 1
        while l <= r:
            while l < r and people[l] + people[r] > limit:
                r -= 1
                ans += 1
            ans += 1
            l += 1
            r -= 1
        return ans
# leetcode submit region end(Prohibit modification and deletion)
