"""
Title: 1912.Design Movie Rental System
Title Slug: designMovieRentalSystem
Author: Neo
Date: 2025-09-21 11:23:44
"""
from collections import defaultdict
from typing import List

from sortedcontainers import SortedList


# leetcode submit region begin(Prohibit modification and deletion)
class MovieRentingSystem:

    def __init__(self, n: int, entries: List[List[int]]):
        shops = [dict() for _ in range(n)]

        self.report_rented = SortedList()
        search_unrented = defaultdict(SortedList)
        for shop, movie, price in entries:
            search_unrented[movie].add((price, shop))
            shops[shop][movie] = price
        self.search_unrented = search_unrented
        self.shops = shops

    def search(self, movie: int) -> List[int]:
        return [shop for _, shop in self.search_unrented[movie][:5]]

    def rent(self, shop: int, movie: int) -> None:
        price = self.shops[shop][movie]
        self.search_unrented[movie].discard((price, shop))
        self.report_rented.add((price, shop, movie))

    def drop(self, shop: int, movie: int) -> None:
        price = self.shops[shop][movie]
        self.report_rented.remove((price, shop, movie))
        self.search_unrented[movie].add((price, shop))

    def report(self) -> List[List[int]]:
        return [[s, m] for _, s, m in self.report_rented[:5]]

# Your MovieRentingSystem object will be instantiated and called as such:
# obj = MovieRentingSystem(n, entries)
# param_1 = obj.search(movie)
# obj.rent(shop,movie)
# obj.drop(shop,movie)
# param_4 = obj.report()
# leetcode submit region end(Prohibit modification and deletion)
