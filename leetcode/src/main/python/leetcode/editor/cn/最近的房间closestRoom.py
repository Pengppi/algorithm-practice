"""
Title: 1847.最近的房间
Title Slug: closestRoom
Author: Neo
Date: 2024-12-16 22:13:06
"""
from cmath import inf
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def closestRoom(self, rooms: List[List[int]], queries: List[List[int]]) -> List[int]:
        n = len(queries)
        ans = [-1] * n
        rooms.sort(key=lambda x: x[1], reverse=True)
        j = 0
        rm_ids = SortedList()
        for i in sorted(range(n), key=lambda x: queries[x][1], reverse=True):
            prefer_id, sz = queries[i]
            while j < len(rooms) and rooms[j][1] >= sz:
                rm_ids.add(rooms[j][0])
                j += 1
            k = rm_ids.bisect_left(prefer_id)
            diff = inf
            if k:
                diff = prefer_id - rm_ids[k - 1]
                ans[i] = rm_ids[k - 1]
            if k < len(rm_ids) and diff > rm_ids[k] - prefer_id:
                ans[i] = rm_ids[k]
        return ans
# leetcode submit region end(Prohibit modification and deletion)
