"""
Title: 1963.使字符串平衡的最小交换次数
Title Slug: minimumNumberOfSwapsToMakeTheStringBalanced
Author: Neo
Date: 2025-03-17 21:32:45
"""

# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minSwaps(self, s: str) -> int:
        s = list(s)
        ans = c = 0
        j = len(s) - 1
        for b in s:
            if b == '[':
                c += 1
            elif c > 0:
                c -= 1
            else:  # c == 0
                # 找最右边的左括号交换
                while s[j] == ']':
                    j -= 1
                s[j] = ']'  # s[i] = '[' 可以省略
                ans += 1
                c += 1  # s[i] 变成左括号，c 加一
        return ans

# leetcode submit region end(Prohibit modification and deletion)

