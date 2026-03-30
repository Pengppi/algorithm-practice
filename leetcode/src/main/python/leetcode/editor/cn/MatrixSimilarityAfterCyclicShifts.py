"""
Title: 2946.Matrix Similarity After Cyclic Shifts
Title Slug: matrixSimilarityAfterCyclicShifts
Author: Neo
Date: 2026-03-27 12:27:52
"""

from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def areSimilar(self, mat: List[List[int]], k: int) -> bool:
        n = len(mat[0])
        k %= n
        if k == 0:
            return True
        for i, row in enumerate(mat):
            if i & 1:
                if row[-k:] != row[:k] or row[:-k] != row[k:]:
                    return False
            else:
                if row[:k] != row[-k:] or row[k:] != row[:-k]:
                    return False

        return True


# leetcode submit region end(Prohibit modification and deletion)
