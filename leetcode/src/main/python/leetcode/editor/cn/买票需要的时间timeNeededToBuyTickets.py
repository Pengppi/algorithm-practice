"""
Title: 2073.买票需要的时间
Title Slug: timeNeededToBuyTickets
Author: Neo
Date: 2024-09-29 14:12:53
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def timeRequiredToBuy(self, tickets: List[int], k: int) -> int:
        n = len(tickets)
        q = [x for x in range(n)]
        ans = 0
        while q:
            ans += 1
            x = q.pop(0)
            tickets[x] -= 1
            if tickets[x] > 0:
                q.append(x)
            elif x == k:
                return ans

# leetcode submit region end(Prohibit modification and deletion)
