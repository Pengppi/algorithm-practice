import collections
from cmath import inf
from collections import defaultdict
from typing import List


class Solution:
    def losingPlayer(self, x: int, y: int) -> str:
        cnt = min(x, y // 4)
        if cnt % 2 == 0:
            return "Bob"
        else:
            return "Alice"

    def minimumLength(self, s: str) -> int:
        mp = defaultdict(int)
        ans = len(s)
        for c in s:
            mp[c] += 1
            if mp[c] == 3:
                ans -= 2
                mp[c] = 1
        return ans

    def minChanges(self, nums: List[int], k: int) -> int:
        n = len(nums)
        diffs = [abs(nums[i] - nums[n - i - 1]) for i in range(n // 2)]
        diff_cnt = collections.Counter(diffs)
        ans = inf
        diff_cnt = dict(sorted(diff_cnt.items(), key=lambda x: x[1], reverse=True))
        for x, y in diff_cnt.items():
            res = n - y * 2
            if x > k:
                continue
            for i in range(n // 2):
                if ans < res - (n // 2 - i):
                    return ans
                j = n - i - 1
                mx = max(nums[i], nums[j])
                mn = min(nums[i], nums[j])
                if mx - mn == x:
                    continue
                if x + mn <= k or mx - x >= 0:
                    res -= 1
            ans = min(ans, res)

        return ans


r = Solution().minChanges([0, 1, 2, 3, 3, 6, 5, 4], 6)
print(r)
