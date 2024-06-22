import bisect
import math
from typing import List


class Solution:
    def minimumOperations(self, nums: List[int]) -> int:
        ans = 0
        for num in nums:
            x = num % 3
            ans += min(x, 3 - x)
        return ans

    def minOperations1(self, nums: List[int]) -> int:
        n = len(nums)
        ans = 0
        for i in range(n):
            if nums[i] == 1:
                continue
            if i + 2 >= n:
                return -1
            else:
                nums[i + 1] ^= 1
                nums[i + 2] ^= 1
                ans += 1
        return ans

    def minOperations(self, nums: List[int]) -> int:
        cnt, ans = 0, 0
        for num in nums:
            if cnt == 0:
                if num == 0:
                    ans += 1
                    cnt = 1
            else:
                if num == 1:
                    ans += 1
                    cnt = 0
        return ans

    def numberOfPermutations(self, n: int, requirements: List[List[int]]) -> int:
        MOD = 10 ** 9 + 7
        requirements.sort(key=lambda x: x[0])

        def dfs(i: int, j: int, sum: int, list: List[int]) -> int:
            if j == len(requirements):
                return math.factorial(n - len(list)) % MOD
            res = 0
            for x in range(n - 1, -1, -1):
                k = bisect.bisect_left(list, x)
                if k < len(list) and list[k] == x:
                    continue
                new_sum = sum + len(list) - k
                if new_sum > requirements[j][1]:
                    return res
                list.insert(k, x)
                if i == requirements[j][0]:
                    if new_sum == requirements[j][1]:
                        res += dfs(i + 1, j + 1, new_sum, list) % MOD
                else:
                    res += dfs(i + 1, j, new_sum, list) % MOD
                del list[k]
            return res

        return dfs(0, 0, 0, [])


Solution().numberOfPermutations(3, [[2, 2], [0, 0]])
