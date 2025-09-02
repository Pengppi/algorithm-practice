"""
Title: 1792.Maximum Average Pass Ratio
Title Slug: maximumAveragePassRatio
Author: Neo
Date: 2025-09-01 12:38:00
"""
import heapq
from typing import List
from xml.etree.ElementTree import QName


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxAverageRatio(self, classes: List[List[int]], extraStudents: int) -> float:
        n = len(classes)

        def get_imp(clas: List[int]) -> float:
            x, y = clas
            # (x + 1) / (y + 1) - x / y
            return (y - x) / (y * y + y)

        q = [(-get_imp(clas), i) for i, clas in enumerate(classes)]
        heapq.heapify(q)
        while extraStudents:
            extraStudents -= 1
            _, i = q[0]
            classes[i][0] += 1
            classes[i][1] += 1
            heapq.heapreplace(q, (-get_imp(classes[i]), i))
        return sum(classes[i][0] / classes[i][1] for _, i in q) / n

        # leetcode submit region end(Prohibit modification and deletion)


Solution().maxAverageRatio([[1, 2], [3, 5], [2, 2]], 2)
