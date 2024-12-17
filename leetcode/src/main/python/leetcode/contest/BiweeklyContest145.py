from collections import Counter
from math import ceil
from typing import List


class Solution:
    def findMinimumTime(self, strength: List[int], K: int) -> int:
        ans = 0
        x = 1
        strength.sort()
        while strength:
            if x >= strength[0]:
                del strength[0]
                ans += 1
                x += K
                continue
            time = ceil(strength[0] / x)
            cur = time * x
            i = 0
            while i < len(strength) and cur >= strength[i]:
                i += 1
            if i != len(strength) and x + K >= strength[0] and cur + x >= strength[i]:
                del strength[i]
                time += 1
            else:
                del strength[i - 1]
            ans += time
            x += K

        return ans


def minOperations(self, nums: List[int], k: int) -> int:
    st = set()
    for x in nums:
        if x < k:
            return -1
        elif x > k:
            st.add(x)
    return len(st)


Solution().findMinimumTime([7, 3, 6, 18, 22, 50], 4)
