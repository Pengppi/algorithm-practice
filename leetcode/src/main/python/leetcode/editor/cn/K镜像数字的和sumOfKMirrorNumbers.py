"""
Title: 2081.k 镜像数字的和
Title Slug: sumOfKMirrorNumbers
Author: Neo
Date: 2025-06-23 19:50:12
"""
from itertools import accumulate

# leetcode submit region begin(Prohibit modification and deletion)

N = 30
ans = [[] for _ in range(10)]


def is_k_mirror(x: int, k: int) -> bool:
    if x % k == 0:
        return False
    mask = 0
    while mask < x // k:
        mask = mask * k + x % k
        x //= k
    return mask == x or mask == x // k


def check_palindrome(x: int) -> bool:
    done = True
    for k in range(2, 10):
        if len(ans[k]) < N and is_k_mirror(x, k):
            ans[k].append(x)
        if len(ans[k]) < N:
            done = False
    if not done:
        return False
    for k in range(2, 10):
        ans[k] = list(accumulate(ans[k]))
    return True


def init():
    base = 1
    while True:
        for i in range(base, base * 10):
            s = str(i)
            x = int(s + s[::-1][1:])  # odd length
            if check_palindrome(x):
                return
        for i in range(base, base * 10):
            s = str(i)
            x = int(s + s[::-1])  # even length
            if check_palindrome(x):
                return
        base *= 10

init()

class Solution:
    def kMirror(self, k: int, n: int) -> int:
        return ans[k][n - 1]
# leetcode submit region end(Prohibit modification and deletion)
