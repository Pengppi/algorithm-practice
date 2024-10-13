from collections import defaultdict, Counter
from functools import cache
from typing import List, Optional

from leetcode.entity import TreeNode


class Solution:
    def findXSum(self, nums: List[int], k: int, x: int) -> List[int]:
        n = len(nums)
        ans = []
        mp = defaultdict(int)

        def get_sum():
            s = 0
            if len(mp) <= x:
                return sum([ke * va for (ke, va) in mp.items()])
            for i, (ke, va) in enumerate(sorted(mp.items(), key=lambda o: (-o[1], -o[0]))):
                if i >= x:
                    break
                s += ke * va
            return s

        for i in range(n):
            mp[nums[i]] += 1
            if i >= k:
                mp[nums[i - k]] -= 1
                if mp[nums[i - k]] == 0:
                    del mp[nums[i - k]]
            if i >= k - 1:
                ans.append(get_sum())
        return ans

    def kthLargestPerfectSubtree(self, root: Optional[TreeNode], k: int) -> int:
        ans = []

        def dfs(node):
            if not node:
                return 0
            left = dfs(node.left)
            right = dfs(node.right)
            if left == right:
                ans.append(left * 2 + 1)
                return left + right + 1
            else:
                return -1

        dfs(root)
        ans.sort(reverse=True)
        return -1 if len(ans) < k else ans[k - 1]

    def countWinningSequences(self, s: str) -> int:
        n = len(s)
        mod = 10 ** 9 + 7

        def get_score(a, b):
            if a == b:
                return 0
            if (a, b) == ('F', 'W'):
                return 1
            elif (a, b) == ('W', 'E'):
                return 1
            elif (a, b) == ('E', 'F'):
                return 1
            else:
                return -1

        @cache
        def dfs(i, last, cnt):
            if i == n:
                return 1 if cnt > 0 else 0
            if cnt + n - i <= 0:
                return 0
            a = s[i]
            res = 0
            for b in ('F', 'W', 'E'):
                if b == last:
                    continue
                res = (res + dfs(i + 1, b, cnt + get_score(a, b))) % mod
            return res

        return dfs(0, "", 0)
