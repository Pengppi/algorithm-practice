from cmath import inf
from linecache import cache
from urllib.response import addbase

from encodings.punycode import adapt
from typing import List


class Solution:
    def resultsArray(self, nums: List[int], k: int) -> List[int]:
        ans = []
        st = []
        for i, x in enumerate(nums):
            if st and st[-1] != x - 1:
                st = []
            st.append(x)
            if i >= k - 1:
                if len(st) >= k:
                    ans.append(st[-1])
                else:
                    ans.append(-1)

        return ans

    def maximumValueSum(self, board: List[List[int]]) -> int:
        arr = []
        for row in board:
            sorted_row = sorted([(value, idx) for idx, value in enumerate(row)], reverse=True)
            arr.append(sorted_row[:3])

        @cache
        def dfs(x, vis):
            if len(vis) == 3:
                return 0
            res = dfs(x + 1, vis)
            for i in range(x, len(arr)):
                for val, col in arr[i]:
                    if col in vis:
                        continue
                    vis.append(col)
                    res = max(res, dfs(i + 1, vis) + val)
                    break
            return res

        return dfs(0,set())


