from collections import defaultdict
from typing import List


class Solution:
    def buttonWithLongestTime(self, events: List[List[int]]) -> int:
        ans = -1
        mx = 0
        last = 0
        for i, t in events:
            if t - last > mx:
                mx = t - last
                ans = i
            elif t - last == mx and i < ans:
                ans = i
            last = t
        return ans

    def maxAmount(self, initialCurrency: str, pairs1: List[List[str]], rates1: List[float], pairs2: List[List[str]],
                  rates2: List[float]) -> float:
        s_mp = dict()
        s_count = 0

        def get(s):
            if s in s_mp:
                return s_mp[s]
            nonlocal s_count
            s_mp[s] = s_count
            s_count += 1
            return s_count - 1

        def getGraph(pairs, rates):
            g = defaultdict(list)
            for i, (u, v) in enumerate(pairs):
                g[get(u)].append((get(v), rates[i]))
                g[get(v)].append((get(u), 1.0 / rates[i]))
            return g

        g1 = getGraph(pairs1, rates1)
        g2 = getGraph(pairs2, rates2)

        st1 = set()

        def dfs1(x, val):
            if x in st1:
                return
            st1.add(x)
            dfs2(x, val, set())
            for y, v in g1[x]:
                dfs1(y, val * v)

        def dfs2(x, val, st):
            if x in st:
                return
            st.add(x)
            if x == get(initialCurrency):
                nonlocal ans
                ans = max(ans, val)
                return
            for y, v in g2[x]:
                dfs2(y, val * v, st)

        ans = 1.0
        dfs1(get(initialCurrency), 1)
        return ans

    def beautifulSplits(self, nums: List[int]) -> int:
        def check(x, pivot):
            x += 1
            i = pivot
            j = x + pivot
            if j + x > len(nums):
                return False
            while i < x + pivot:
                if nums[i] != nums[j]:
                    return False
                i += 1
                j += 1
            return True

        ans = 0
        n = len(nums)
        for i in range(n - 2):
            if check(i, 0):
                ans += n - 2 - i * 2
                continue
            for j in range(i + 1, (n - i) // 2 + i + 2):
                if check(j - (i + 1), i + 1):
                    ans += 1

        return ans


Solution().beautifulSplits([0,0,0,0,2,2,0,1,2,1,2])
