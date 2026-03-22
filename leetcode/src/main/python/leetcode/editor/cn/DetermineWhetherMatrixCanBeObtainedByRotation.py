"""
Title: 1886.Determine Whether Matrix Can Be Obtained By Rotation
Title Slug: determineWhetherMatrixCanBeObtainedByRotation
Author: Neo
Date: 2026-03-22 13:14:07
"""

# leetcode submit region begin(Prohibit modification and deletion)
from typing import List


class Solution:
    def findRotation(self, mat: List[List[int]], target: List[List[int]]) -> bool:
        n = len(mat)

        def isEqual(rotate: int) -> bool:
            if rotate == 0:
                for i in range(n):
                    for j in range(n):
                        if mat[i][j] != target[i][j]:
                            return False
            if rotate == 90:
                for i in range(n):
                    for j in range(n):
                        if mat[i][j] != target[j][n - 1 - i]:
                            return False
            if rotate == 180:
                for i in range(n):
                    for j in range(n):
                        if mat[i][j] != target[n - 1 - i][n - 1 - j]:
                            return False
            if rotate == 270:
                for i in range(n):
                    for j in range(n):
                        if mat[i][j] != target[n - 1 - j][i]:
                            return False

            return True

        return any(isEqual(rotate) for rotate in [0, 90, 180, 270])


# leetcode submit region end(Prohibit modification and deletion)
