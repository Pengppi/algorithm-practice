from collections import Counter, defaultdict
from functools import cache
from typing import List


class Solution:
    def maxTargetNodes(self, edges1: List[List[int]], edges2: List[List[int]], k: int) -> List[int]:
        @cache
        def dfs1(x, step, fa):
            res = 1
            if step == 0:
                return res
            for y in g1[x]:
                if y == fa:
                    continue
                res += dfs1(y, step - 1, x)
            return res

        @cache
        def dfs2(x, flg, fa):
            res = 1
            if flg == 0:
                return res
            for y in g2[x]:
                if y == fa:
                    continue
                res += dfs2(y, flg ^ 1, x)
            return res

        def getGraph(edges):
            g = defaultdict(list)
            for u, v in edges:
                g[u].append(v)
                g[v].append(u)
            return g

        n = len(edges1) + 1
        if k == 0:
            return [1] * n

        g1 = getGraph(edges1)
        g2 = getGraph(edges2)

        mx = max(dfs2(key, k - 1, -1) for key in g2.keys())
        return [dfs1(i, k, -1) + mx for i in range(n)]

    def getLargestOutlier(self, nums: List[int]) -> int:
        nums.sort(reverse=True)
        s = 0
        cnt = defaultdict(int)
        for num in nums:
            s += num
            cnt[num] += 1
        for num in nums:
            remain = s - num
            if remain % 2 == 0:
                cnt[num] -= 1
                if cnt[remain // 2] > 0:
                    return num
                cnt[num] += 1
        return -1

    def smallestNumber(self, n: int) -> int:
        cur = n
        while True:
            binary = bin(cur)[2:]
            valid = True
            for bit in binary:
                if bit == '0':
                    valid = False
                    break
            if valid:
                return cur
            cur += 1
