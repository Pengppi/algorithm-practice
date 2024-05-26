"""
Title: 1738.找出第 K 大的异或坐标值
Title Slug: findKthLargestXorCoordinateValue
Author: Neo
Date: 2024-05-26 12:32:48
"""
import heapq
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def kthLargestValue(self, matrix: List[List[int]], k: int) -> int:
        m, n = len(matrix), len(matrix[0])
        last = []
        ans = []
        for i in range(m):
            tmp = []
            for j in range(n):
                cur = matrix[i][j]
                if i > 0:
                    cur = cur ^ last[j]
                if j > 0:
                    cur = cur ^ tmp[-1]
                if i > 0 and j > 0:
                    cur = cur ^ last[j - 1]
                ans.append(cur)
                tmp.append(cur)
            last = tmp
        ans.sort()
        return ans[-k]
    # leetcode submit region end(Prohibit modification and deletion)


s = Solution()
s.kthLargestValue([[5, 2], [1, 6]], 1)
