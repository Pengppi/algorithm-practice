"""
Title: 826.安排工作以达到最大收益
Title Slug: mostProfitAssigningWork
Author: Neo
Date: 2024-05-17 12:59:32
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxProfitAssignment(self, difficulty: List[int], profit: List[int], worker: List[int]) -> int:
        n, m = len(profit), len(worker)
        id = [i for i in range(n)]
        id.sort(key=lambda x: -profit[x])
        worker.sort(reverse=True)
        i, j, ans = 0, 0, 0
        while j < m and i < n:
            d, p = difficulty[id[i]], profit[id[i]]
            while j < m and worker[j] >= d:
                ans += p
                j += 1
            i += 1
        return ans

# leetcode submit region end(Prohibit modification and deletion)
