"""
Title: 2011.Final Value of Variable After Performing Operations
Title Slug: finalValueOfVariableAfterPerformingOperations
Author: Neo
Date: 2025-10-20 18:19:43
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def finalValueAfterOperations(self, operations: List[str]) -> int:
        increment = "++"
        x = 0
        for op in operations:
            if increment in op:
                x += 1
            else:
                x -= 1

        return x

# leetcode submit region end(Prohibit modification and deletion)
