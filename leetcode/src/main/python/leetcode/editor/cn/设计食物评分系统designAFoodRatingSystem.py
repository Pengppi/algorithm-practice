"""
Title: 2353.设计食物评分系统
Title Slug: designAFoodRatingSystem
Author: Neo
Date: 2025-02-28 12:45:31
"""
import heapq
from collections import defaultdict
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class FoodRatings:

    def __init__(self, foods: List[str], cuisines: List[str], ratings: List[int]):
        fmp = {}
        cmp = defaultdict(list)
        for f, c, r in zip(foods, cuisines, ratings):
            fmp[f] = [r, c]
            cmp[c].append((-r, f))
        for h in cmp.values():
            heapq.heapify(h)
        self.fmp = fmp
        self.cmp = cmp

    def changeRating(self, food: str, newRating: int) -> None:
        p = self.fmp[food]
        heapq.heappush(self.cmp[p[1]], (-newRating, food))
        p[0] = newRating

    def highestRated(self, cuisine: str) -> str:
        h = self.cmp[cuisine]
        while -h[0][0] != self.fmp[h[0][1]][0]:
            heapq.heappop(h)
        return h[0][1]

# Your FoodRatings object will be instantiated and called as such:
# obj = FoodRatings(foods, cuisines, ratings)
# obj.changeRating(food,newRating)
# param_2 = obj.highestRated(cuisine)
# leetcode submit region end(Prohibit modification and deletion)
