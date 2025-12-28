"""
Title: 2054.Two Best Non-Overlapping Events
Title Slug: twoBestNonOverlappingEvents
Author: Neo
Date: 2025-12-23 17:24:56
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:

    def maxTwoEvents(self, events: List[List[int]]) -> int:
        events.sort(key=lambda x: x[1])
        st = [(0, 0)]
        ans = 0
        for s, e, v in events:
            i = bisect_left(st, (s, )) - 1
            ans = max(ans, v + st[i][1])
            if st[-1][1] < v:
                st.append((e, v))

        return ans


# leetcode submit region end(Prohibit modification and deletion)
