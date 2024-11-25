from functools import cache
from typing import List


class Solution:
    def canAliceWin(self, n: int) -> bool:
        cur = 10
        while cur <= n:
            n -= cur
            cur -= 1
        return cur & 1 == 1

    def shiftDistance(self, s: str, t: str, nextCost: List[int], previousCost: List[int]) -> int:

        ne = [0] * 27
        pr = [0] * 27
        nes = 0
        prs = 0
        for i in range(26):
            ne[i + 1] = ne[i] + nextCost[i]
            nes += nextCost[i]
            pr[i + 1] = pr[i] + previousCost[i]
            prs += previousCost[i]
        ans = 0
        for x in range(len(s)):
            i = ord(s[x]) - ord('a')
            j = ord(t[x]) - ord('a')
            res = 0
            if i < j:
                res = min(ne[j] - ne[i], prs - (pr[j + 1] - pr[i + 1]))
            elif i > j:
                res = min(pr[i + 1] - pr[j + 1], nes - (ne[i] - ne[j]))
            ans += res
        return ans

    def maxRemoval(self, nums: List[int], queries: List[List[int]]) -> int:
        n = len(nums)
        tree = [0] * (4 * n)
        lazy = [0] * (4 * n)

        def build(o, l, r):
            if l == r:
                tree[o] = nums[l]
            else:
                mid = (l + r) // 2
                build(2 * o + 1, l, mid)
                build(2 * o + 2, mid + 1, r)
                tree[o] = max(tree[2 * o + 1], tree[2 * o + 2])

        def push_down(o):
            if lazy[o] != 0:
                lazy[2 * o + 1] += lazy[o]
                lazy[2 * o + 2] += lazy[o]
                tree[2 * o + 1] -= lazy[o]
                tree[2 * o + 2] -= lazy[o]
                lazy[o] = 0

        def update(o, l, r, L, R):
            if L <= l and r <= R:
                tree[o] -= 1
                lazy[o] += 1
                return
            push_down(o)
            mid = (l + r) // 2
            if L <= mid:
                update(2 * o + 1, l, mid, L, R)
            if R > mid:
                update(2 * o + 2, mid + 1, r, L, R)
            tree[o] = max(tree[2 * o + 1], tree[2 * o + 2])

        def query(o, l, r, L, R):
            if L <= l and r <= R:
                return tree[o]
            push_down(o)
            mid = (l + r) // 2
            res = 0
            if L <= mid:
                res = max(query(2 * o + 1, l, mid, L, R), res)
            if R > mid:
                res = max(query(2 * o + 2, mid + 1, r, L, R), res)
            return res

        build(0, 0, n - 1)
        ans = 0
        queries.sort(key=lambda x: x[0] - x[1])
        for l, r in queries:
            if query(0, 0, n - 1, l, r) > 0:
                update(0, 0, n - 1, l, r)
            else:
                ans += 1
        return -1 if query(0, 0, n - 1, 0, n - 1) > 0 else ans


Solution().maxRemoval([1, 1, 1, 1], [[1, 3], [0, 2], [1, 3], [1, 2]])
