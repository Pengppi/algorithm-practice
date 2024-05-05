"""
Title: 658.找到 K 个最接近的元素
Title Slug: findKClosestElements
Author: Neo
Date: 2024-05-04 16:26:18
"""
from math import inf
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        pre_sum = [0] * (len(arr) + 1)
        for i, num in enumerate(arr):
            pre_sum[i + 1] = pre_sum[i] + abs(num - x)

        r = len(arr)
        ans, mn_sum = r, inf
        while r >= k:
            cur_sum = pre_sum[r] - pre_sum[r - k]
            if cur_sum <= mn_sum:
                mn_sum = cur_sum
                ans = r
            else:
                break
            r -= 1
        return arr[ans - k:ans]
# leetcode submit region end(Prohibit modification and deletion)
