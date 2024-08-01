"""
Title: 3106.满足距离约束且字典序最小的字符串
Title Slug: lexicographicallySmallestStringAfterOperationsWithConstraint
Author: Neo
Date: 2024-07-27 12:25:43
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def getSmallestString(self, s: str, k: int) -> str:
        ans = []
        n = len(s)
        i = 0
        mn, mx = ord('a'), ord('z') + 1
        while k > 0 and i < n:
            cur = ord(s[i])
            dist = min(cur - mn, mx - cur)
            if dist > k:
                ans.append(chr(cur - k))
                k = 0
            else:
                k -= dist
                ans.append('a')
            i += 1

        return "".join(ans) + s[i:]

# leetcode submit region end(Prohibit modification and deletion)
Solution().getSmallestString("rn",9)