"""
Title: 2040.两个有序数组的第 K 小乘积
Title Slug: kthSmallestProductOfTwoSortedArrays
Author: Neo
Date: 2025-06-25 12:37:34
"""
import bisect
import heapq
from typing import List

from sortedcontainers import SortedList


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def kthSmallestProduct(self, nums1: List[int], nums2: List[int], k: int) -> int:
        n, m = len(nums1), len(nums2)
        i0, j0 = bisect.bisect_left(nums1, 0), bisect.bisect_left(nums2, 0)

        def check(x: int) -> bool:
            cnt = 0
            if x < 0:
                i, j = 0, j0 # 右上
                while i < i0 and j < m:
                    if nums1[i] * nums2[j] > x:
                        j += 1
                    else:
                        cnt += m - j
                        i += 1
                i, j = i0, 0 # 左下
                while i < n and j < j0:
                    if nums1[i] * nums2[j] > x:
                        i += 1
                    else:
                        cnt += n - i
                        j += 1
            else:
                cnt = i0 * (m - j0) + (n - i0) * j0

                i, j = 0, j0 - 1 # 左上
                while i < i0 and j >= 0:
                    if nums1[i] * nums2[j] > x:
                        i += 1
                    else:
                        cnt += i0 - i
                        j -= 1

                i, j = i0, m - 1 # 右下
                while i < n and j >= j0:
                    if nums1[i] * nums2[j] > x:
                        j -= 1
                    else:
                        cnt += j - j0 + 1
                        i += 1

            return cnt >= k

        corners = (nums1[0] * nums2[0], nums1[0] * nums2[m - 1], nums1[n - 1] * nums2[0], nums1[n - 1] * nums2[m - 1])
        l, r = min(corners), max(corners)
        return l + bisect.bisect_left(range(l, r), True, key=check)

    # leetcode submit region end(Prohibit modification and deletion)
