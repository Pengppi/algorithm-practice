"""
Title: 2569.更新数组后处理求和查询
Title Slug: handlingSumQueriesAfterUpdate
Author: Neo
Date: 2024-09-17 16:12:00
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def handleQuery(self, nums1: List[int], nums2: List[int], queries: List[List[int]]) -> List[int]:
        n = len(nums1)
        tree = [0] * (4 * n)
        flg = [False] * (4 * n)

        def build(node, l, r):
            if l == r:
                tree[node] = nums1[l]
            else:
                m = (l + r) // 2
                build(2 * node + 1, l, m)
                build(2 * node + 2, m + 1, r)
                pushup(node)

        def update(node, L, R, l, r):
            if L <= l and R >= r:
                pushdown(node, l, r)
                return
            m = (l + r) // 2
            if flg[node]:
                pushdown(2 * node + 1, l, m)
                pushdown(2 * node + 2, m + 1, r)
                flg[node] = False
            if m >= L:
                update(2 * node + 1, L, R, l, m)
            if m < R:
                update(2 * node + 2, L, R, m + 1, r)
            pushup(node)

        def pushdown(node, l, r):
            tree[node] = r - l + 1 - tree[node]
            flg[node] = not flg[node]

        def pushup(node):
            tree[node] = tree[2 * node + 1] + tree[2 * node + 2]

        cur_sum = sum(nums2)
        ans = []
        build(0, 0, n - 1)
        for op, l, r in queries:
            if op == 1:
                update(0, l, r, 0, n - 1)
            elif op == 2:
                cur_sum += tree[0] * l
            elif op == 3:
                ans.append(cur_sum)
        return ans


# leetcode submit region end(Prohibit modification and deletion)
res = Solution().handleQuery([1, 0, 1], [0, 0, 0], [[1, 1, 1], [2, 1, 0], [3, 0, 0]])

print(res)
