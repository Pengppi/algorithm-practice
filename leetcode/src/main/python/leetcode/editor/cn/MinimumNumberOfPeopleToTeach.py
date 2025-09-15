"""
Title: 1733.Minimum Number of People to Teach
Title Slug: minimumNumberOfPeopleToTeach
Author: Neo
Date: 2025-09-10 12:50:41
"""
from collections import defaultdict
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minimumTeachings(self, n: int, languages: List[List[int]], friendships: List[List[int]]) -> int:
        has_learned = list(map(set, languages))
        to_teach = set()
        for u, v in friendships:
            if has_learned[u - 1] & has_learned[v - 1]:
                continue
            to_teach.add(u - 1)
            to_teach.add(v - 1)

        lan_cnt = [0] * (n + 1)

        for user in to_teach:
            for lan in has_learned[user]:
                lan_cnt[lan] += 1

        return len(to_teach) - max(lan_cnt)

    # leetcode submit region end(Prohibit modification and deletion)


Solution().minimumTeachings(2,
                            [[1], [2], [1, 2]],
                            [[1, 2], [1, 3], [2, 3]], )
