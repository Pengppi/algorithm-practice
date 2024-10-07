import functools
from collections import defaultdict
from typing import List


class Solution:
    def maxGoodNumber(self, nums: List[int]) -> int:
        def get_bin(num):
            return bin(num)[2:]

        def compare(a, b):
            num1 = int(get_bin(a) + get_bin(b))
            num2 = int(get_bin(b) + get_bin(a))
            return num2 - num1

        nums.sort(key=functools.cmp_to_key(compare))
        ans = "".join(map(get_bin, nums))
        return int(ans, 2)

    def remainingMethods(self, n: int, k: int, invocations: List[List[int]]) -> List[int]:
        g = defaultdict(list)
        for i, j in invocations:
            g[i].append(j)

        susp = set()

        def dfs(x: int):
            if x in susp:
                return
            susp.add(x)
            for y in g[x]:
                dfs(y)


        dfs(k)
        all = {i for i in range(n)}
        remain = all.difference(susp)
        for x in remain:
            for y in g[x]:
                if y in susp:
                    return list(all)
        return list(remain)
