"""
Title: 1299.将每个元素替换为右侧最大元素
Title Slug: replaceElementsWithGreatestElementOnRightSide
Author: Neo
Date: 2025-02-16 12:23:52
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def replaceElements(self, arr: List[int]) -> List[int]:
        n = len(arr)
        ans = [-1] * n
        mx = arr[n - 1]
        for i in range(n - 2, -1, -1):
            ans[i] = mx
            mx = max(mx, arr[i])
        return ans

# leetcode submit region end(Prohibit modification and deletion)
