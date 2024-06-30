from typing import List


class Solution:
    def maxHeightOfTriangle(self, red: int, blue: int) -> int:
        cnt = 0
        i = 1
        even, odd = 0, 0
        mn = min(red, blue)
        mx = max(red, blue)
        while True:
            if i & 1:
                odd += i
                if odd > mx:
                    return cnt
                elif odd > mn:
                    return cnt + 1
            else:
                even += i
                if even > mx:
                    return cnt
                elif even > mn:
                    return cnt + 1
            i += 1
            cnt += 1

    def maximumLength(self, nums: List[int]) -> int:
        n = len(nums)
        f = [[0, 0] for _ in range(n)]
        ans = 0
        for i, x in enumerate(nums[1:], 1):
            for j in range(i - 1, -1, -1):
                if min(f[i]):
                    break
                y = (x + nums[j]) % 2
                f[i][y] = max(f[j][y] + 1, f[i][y])
            ans = max(ans, max(f[i]))
        return ans + 1


Solution().maximumLength([2, 3, 4, 5, 6])
