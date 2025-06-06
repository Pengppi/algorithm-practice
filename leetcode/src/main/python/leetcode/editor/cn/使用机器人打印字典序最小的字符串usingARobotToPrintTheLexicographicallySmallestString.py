"""
Title: 2434.使用机器人打印字典序最小的字符串
Title Slug: usingARobotToPrintTheLexicographicallySmallestString
Author: Neo
Date: 2025-06-06 12:15:10
"""
from collections import deque


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def robotWithString(self, s: str) -> str:
        n = len(s)
        ans = ""
        next_smaller = ['z'] * (n + 1)
        for i in range(n - 1, -1, -1):
            next_smaller[i] = min(next_smaller[i + 1], s[i])

        stack = deque()
        for i in range(n):
            stack.append(s[i])
            while stack and stack[-1] <= next_smaller[i + 1]:
                ans += stack.pop()

        return ans


# leetcode submit region end(Prohibit modification and deletion)

print('z' <= 'a')
# Solution().robotWithString("zza")
