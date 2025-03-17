import bisect
from collections import defaultdict
from operator import index
from typing import List


class SegmentTree:
    def __init__(self, arr):
        self.n = len(arr)
        self.tree = [0] * (4 * self.n)
        self.mp = defaultdict(set)
        self.build_tree(arr, 0, 0, self.n - 1)

    def build_tree(self, arr, node, start, end):
        if start == end:
            self.mp[node].add(arr[start])
            self.tree[node] = arr[start]
        else:
            mid = (start + end) // 2
            left_child = 2 * node + 1
            right_child = 2 * node + 2
            self.build_tree(arr, left_child, start, mid)
            self.build_tree(arr, right_child, mid + 1, end)
            self.tree[node] = self.tree[left_child] + self.tree[right_child]

    def update_range(self, l, r, val):
        self._update_range(0, 0, self.n - 1, l, r, val)

    def _update_range(self, node, start, end, l, r, val):
        if r < start or l > end or self.tree[node] == 0:
            return

        if start == end:
            if val in self.mp[node]:
                self.tree[node] = 0
                del self.mp[node]
                return
            for prev in self.mp[node].copy():
                if prev > val:
                    self.mp[node].add(prev - val)
            return

        mid = (start + end) // 2
        left_child = 2 * node + 1
        right_child = 2 * node + 2

        self._update_range(left_child, start, mid, l, r, val)
        self._update_range(right_child, mid + 1, end, l, r, val)

        self.tree[node] = self.tree[left_child] + self.tree[right_child]


class Solution:
    def minZeroArray(self, nums: List[int], queries: List[List[int]]) -> int:
        root = SegmentTree(nums)
        if root.tree[0] <= 0:
            return 0
        for i, (l, r, v) in enumerate(queries):
            root.update_range(l, r, v)
            if root.tree[0] <= 0:
                return i + 1
        return -1

    def solveQueries(self, nums: List[int], queries: List[int]) -> List[int]:
        mp = defaultdict(list)
        for i, x in enumerate(nums):
            mp[x].append(i)

        n = len(nums)
        ans = [-1] * len(queries)
        for i, q in enumerate(queries):
            x = nums[q]
            if len(mp[x]) <= 1:
                continue
            idx = mp[x]
            pos = bisect.bisect_left(idx, q)
            if pos == 0:
                # ans[i] = idx[pos + 1] if idx[pos + 1] - q <= len(nums) - idx[-1] else index()
                ans[i] = min(idx[pos + 1] - q, q + n - idx[-1])
            elif pos == len(idx) - 1:
                ans[i] = min(q - idx[pos - 1], idx[0] + n - q)
            else:
                ans[i] = min(q - idx[pos - 1], idx[pos + 1] - q)
        return ans

    def maxSum(self, nums: List[int]) -> int:
        nums.sort(reverse=True)
        ans = nums[0]
        for i in range(1, len(nums)):
            if nums[i] == nums[i - 1]:
                continue
            ans += max(nums[i], 0)
        return ans


Solution().minZeroArray([2], [[0, 0, 6], [0, 0, 2], [0, 0, 9], [0, 0, 5], [0, 0, 10]])
