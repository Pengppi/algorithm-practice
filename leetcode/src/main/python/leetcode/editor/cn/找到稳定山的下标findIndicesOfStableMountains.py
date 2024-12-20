"""
Title: 3285.找到稳定山的下标
Title Slug: findIndicesOfStableMountains
Author: Neo
Date: 2024-12-19 10:16:26
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def stableMountains(self, height: List[int], threshold: int) -> List[int]:
        return [i for i in range(len(height)) if i > 0 and height[i - 1] > threshold]

# leetcode submit region end(Prohibit modification and deletion)
