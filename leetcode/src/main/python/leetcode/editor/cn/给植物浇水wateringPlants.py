"""
Title: 2079.给植物浇水
Title Slug: wateringPlants
Author: Neo
Date: 2024-05-08 17:12:17
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def wateringPlants(self, plants: List[int], capacity: int) -> int:
        ans, cur = 0, capacity
        for i, plant in enumerate(plants):
            if cur >= plant:
                cur -= plant
            else:
                ans += i * 2
                cur = capacity - plant
            ans += 1
        return ans

# leetcode submit region end(Prohibit modification and deletion)
