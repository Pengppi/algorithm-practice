from collections import defaultdict
from functools import cache
from math import inf, ceil
from typing import List


class Solution:
    def minimumSumSubarray(self, nums: List[int], l: int, r: int) -> int:
        ans = inf
        i = 0
        s = 0
        for j, x in enumerate(nums):
            s += x
            if j - i + 1 > r:
                s -= nums[i]
                i += 1
            k = i
            t = s
            while j - k + 1 >= l:
                if t > 0:
                    ans = min(ans, t)
                t -= nums[k]
                k += 1
        return -1 if ans == inf else ans

    def isPossibleToRearrange(self, s: str, t: str, k: int) -> bool:
        seg = len(s) // k

        def getSubs(ss: str):
            return [ss[i:i + seg] for i in range(0, len(ss), seg)]

        mp = defaultdict(int)
        for sub in getSubs(s):
            mp[sub] += 1
        for sub in getSubs(t):
            if mp[sub] > 0:
                mp[sub] -= 1
            else:
                return False
        return True

    def minArraySum(self, nums: List[int], k: int, op1: int, op2: int) -> int:
        nums.sort(reverse=True)

        @cache
        def dfs(i, o1, o2):
            if i == len(nums):
                return 0
            x = nums[i]
            if o1 == 0 and (o2 == 0 or x < k):
                return sum(nums[i:])
            res = nums[i] + dfs(i + 1, o1, o2)
            if o1 > 0:
                y = ceil(x / 2)
                res = min(res, y + dfs(i + 1, o1 - 1, o2))
                if y >= k and o2 > 0:
                    res = min(res, y - k + dfs(i + 1, o1 - 1, o2 - 1))
            if x >= k and o2 > 0:
                res = min(res, x - k + dfs(i + 1, o1, o2 - 1))
                if o1 > 0:
                    res = min(res, ceil((x - k) / 2) + dfs(i + 1, o1 - 1, o2 - 1))
            return res

        return dfs(0, op1, op2)


