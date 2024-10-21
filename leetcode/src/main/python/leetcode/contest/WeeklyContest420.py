from collections import defaultdict
from functools import cache, lru_cache
from typing import List


class Solution:
    def stringSequence(self, target: str) -> List[str]:
        ans = []
        pre = ''
        for c in target:
            for i in range(ord('a'), ord('z') + 1):
                ans.append(pre + chr(i))
                if chr(i) == c:
                    pre = pre + chr(i)
                    break
        return ans

    def numberOfSubstrings(self, s: str, k: int) -> int:
        ans = 0
        mp = defaultdict(int)
        st = set()
        l = 0
        for r, x in enumerate(s):
            mp[x] += 1
            if mp[x] >= k and x not in st:
                st.add(x)
            while st and l <= r:
                ans += len(s) - r
                y = s[l]
                mp[y] -= 1
                if y in st and mp[y] < k:
                    st.remove(y)
                l += 1
        return ans

    def minOperations(self, nums: List[int]) -> int:
        def get(x):
            if x < 2:
                return x
            if x == 2 or x == 3:
                return x
            if x % 2 == 0:
                return 2
            if x % 3 == 0:
                return 3
            i = 5
            while i * i <= x:
                if x % i == 0:
                    return i
                if x % (i + 2) == 0:
                    return i + 2
                i += 6
            return x

        n = len(nums)
        ans = 0
        prev = nums[-1]
        for i in range(n - 2, -1, -1):
            if nums[i] > prev:
                nums[i] = get(nums[i])
                if nums[i] > prev:
                    return -1
                ans += 1
            prev = nums[i]
        return ans

    def findAnswer(self, parent: List[int], s: str) -> List[bool]:
        n = len(parent)
        g = defaultdict(list)
        for i in range(n):
            g[parent[i]].append(i)

        vis = set()

        ans = [False] * n

        def isValid(x):
            l, r = 0, len(x) - 1
            while l < r:
                if x[l] != x[r]:
                    return False
                l += 1
                r -= 1
            return True

        @cache
        def dfs(x):
            res = ''
            for y in g[x]:
                res += dfs(y)
            res += s[x]
            if x not in vis:
                vis.add(x)
                ans[x] = isValid(res)
            return res

        # def get(x):
        #     if not g[x]:
        #         return True
        #     list = g[x]
        #     l = dfs(list[0])
        #     r = s[x]
        #     if l[0] != r[0]:
        #         return False
        #     i, j = 1, len(list) - 1
        #     cur = 0
        #     while i < j:
        #         if l[cur] != r[cur]:
        #             return False
        #         cur += 1
        #         if cur == len(l):
        #             l += dfs(list[i])
        #             i += 1
        #         if cur == len(r):
        #             r += dfs(list[j])[::-1]
        #             j -= 1
        #     remain = ''
        #     if cur < len(l):
        #         remain = l[cur:]
        #     if i == j:
        #         remain += dfs(list[i])
        #     if cur < len(r):
        #         remain += r[cur:][::-1]
        #
        #     return remain == remain[::-1]

        dfs(0)
        return ans
