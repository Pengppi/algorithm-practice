"""
Title: 2981.找出出现至少三次的最长特殊子字符串 I
Title Slug: findLongestSpecialSubstringThatOccursThriceI
Author: Neo
Date: 2024-05-29 23:03:25
"""
from collections import defaultdict


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maximumLength(self, s: str) -> int:
        g = defaultdict(list)
        cnt = 0
        for i, c in enumerate(s):
            cnt += 1
            if i + 1 == len(s) or c != s[i + 1]:
                g[c].append(cnt)
                cnt = 0
        ans = 0
        for arr in g.values():
            arr.sort(reverse=True)
            arr.extend([0, 0])
            ans = max(ans, arr[0] - 2, min(arr[0] - 1, arr[1]), arr[2])
        return ans if ans > 0 else -1

        return ans
# leetcode submit region end(Prohibit modification and deletion)
