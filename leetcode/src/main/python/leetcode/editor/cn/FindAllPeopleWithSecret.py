"""
Title: 2092.Find All People With Secret
Title Slug: findAllPeopleWithSecret
Author: Neo
Date: 2025-12-19 12:21:15
"""

# leetcode submit region begin(Prohibit modification and deletion)
from ast import Lambda
from collections import defaultdict
from mimetypes import knownfiles
from typing import List


class Solution:

    def findAllPeople(self, n: int, meetings: List[List[int]],
                      firstPerson: int) -> List[int]:
        knows = set()
        knows.add(0)
        knows.add(firstPerson)

        meet_group = defaultdict(list)
        for a, b, t in meetings:
            meet_group[t].append((a, b))

        def dfs(x: int) -> None:
            for y in meets[x]:
                if y in knows:
                    continue
                knows.add(y)
                dfs(y)

        for time in sorted(meet_group):
            persons = set()
            meets = defaultdict(list)
            for a, b in meet_group[time]:
                persons.add(a)
                persons.add(b)
                meets[a].append(b)
                meets[b].append(a)
            for p in persons:
                if p in knows:
                    dfs(p)

        return list(knows)


# leetcode submit region end(Prohibit modification and deletion)
