from collections import Counter
from itertools import permutations


class Solution:
    def generateKey(self, num1: int, num2: int, num3: int) -> int:
        str_num1 = str(num1).zfill(4)
        str_num2 = str(num2).zfill(4)
        str_num3 = str(num3).zfill(4)

        ans = ""

        for i in range(4):
            min_digit = min(str_num1[i], str_num2[i], str_num3[i])
            ans += min_digit

        return int(ans)

    def stringHash(self, s: str, k: int) -> str:
        n = len(s)
        ans = ""
        for i in range(n // k):
            sub = s[i * k: (i + 1) * k]
            h = 0
            for c in sub:
                h += ord(c) - ord('a')
            h %= 26
            ans += chr(ord('a') + h)
        return ans


