from bisect import bisect
from collections import defaultdict
from typing import List


class Solution:

    def numberOfSubsequences(self, nums: List[int]) -> int:
        n = len(nums)
        ans = 0

        mp = defaultdict(list)
        for i in range(n - 2):
            for j in range(i + 2, n):
                s = nums[i] * nums[j]
                mp[s].append((i, j))

        for pairs in mp.values():
            sz = len(pairs)

        return ans

    def answerString(self, word: str, numFriends: int) -> str:
        if numFriends == 1:
            return word
        n = len(word)

        def compare(x, y):
            i = x + 1
            j = y + 1
            while i < n and j < n:
                if word[i] == word[j]:
                    i += 1
                    j += 1
                else:
                    return word[i] < word[j]
            return False

        mxc = max(word)
        idx = -1
        for i, c in enumerate(word):
            if c != mxc:
                continue
            if idx == -1:
                idx = i
                continue
            if compare(idx, i):
                idx = i
        sz = n - numFriends + 1
        return word[idx:idx + sz]

    def minimumOperations(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        ans = 0
        for j in range(n):
            for i in range(1, m):
                if grid[i][j] <= grid[i - 1][j]:
                    ans += grid[i - 1][j] - grid[i][j] + 1
                    grid[i][j] = grid[i - 1][j] + 1
        return ans


Solution().numberOfSubsequences([1,2,3,4,3,6,1])
