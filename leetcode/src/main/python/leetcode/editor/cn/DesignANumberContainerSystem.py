"""
Title: 2349.Design a Number Container System
Title Slug: designANumberContainerSystem
Author: Neo
Date: 2025-09-17 12:40:56
"""
from collections import defaultdict

from sortedcontainers import SortedSet


# leetcode submit region begin(Prohibit modification and deletion)
class NumberContainers:

    def __init__(self):
        self.index_map = dict()
        self.num_map = defaultdict(SortedSet)

    def change(self, index: int, number: int) -> None:
        index_map = self.index_map
        num_map = self.num_map
        if index in index_map:
            old_num = index_map[index]
            num_map[old_num].remove(index)

        index_map[index] = number
        num_map[number].add(index)

    def find(self, number: int) -> int:
        num_map = self.num_map
        sorted_set = num_map[number]
        if not sorted_set:
            return -1
        return sorted_set[0]

# Your NumberContainers object will be instantiated and called as such:
# obj = NumberContainers()
# obj.change(index,number)
# param_2 = obj.find(number)
# leetcode submit region end(Prohibit modification and deletion)
