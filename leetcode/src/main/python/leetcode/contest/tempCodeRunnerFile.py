# 1 ,1
# 1 2 ,1
# 1 2 3 ,3
# 1 2 3 4 ,3
# 1 2 3 4 5 ,1
# 1 2 3 4 5 6 ,1
# 1 2 3 4 5 6 7 ,3
# 1 2 3 4 5 6 7 8 ,3
# 1 2 3 4 5 6 7 8 9, 9
from functools import cache


@cache
def f(n: int) -> int:
    if n == 1:
        return 1
    m = (n + 1) // 2
    return 2 * (m - f(m) + 1) - 1


class Solution:

    def lastInteger(self, n: int) -> int:
        return f(n)


print(Solution().lastInteger(9))
