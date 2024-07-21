from typing import List


class Solution:
    def minChanges(self, n: int, k: int) -> int:
        ans = 0
        for i in range(32):
            a = k >> i & 1
            b = n >> i & 1
            if a == 1 and b == 0:
                return -1
            if a == 0 and b == 1:
                ans += 1

        return ans

    def doesAliceWin(self, s: str) -> bool:
        cnt = 0
        st = {'a', 'e', 'i', 'o', 'u'}
        for c in s:
            if c in st:
                cnt += 1
        if cnt == 0:
            return False
        if cnt % 2 == 0:
            return True

    def maxOperations(self, s: str) -> int:
        n = len(s)
        ans = 0
        one_cnt = 0
        for i in range(n):
            if s[i] == '1':
                one_cnt += 1
            if i > 0 and s[i] == '0' and s[i - 1] == '1':
                ans += one_cnt

        return ans

