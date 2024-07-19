"""
Title: 721.账户合并
Title Slug: accountsMerge
Author: Neo
Date: 2024-07-15 13:01:12
"""
from collections import defaultdict
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def accountsMerge(self, accounts: List[List[str]]) -> List[List[str]]:
        email_map = defaultdict(list)
        for i, account in enumerate(accounts):
            for email in account[1:]:
                email_map[email].append(i)

        isVis = [False] * len(accounts)
        ans = []

        def dfs(i: int) -> None:
            isVis[i] = True
            for email in accounts[i][1:]:
                if email in email_set:
                    continue
                email_set.add(email)
                for j in email_map[email]:
                    if not isVis[j]:
                        dfs(j)

        for i, vis in enumerate(isVis):
            if not vis:
                email_set = set()
                dfs(i)
                ans.append([accounts[i][0]] + sorted(email_set))
        return ans
# leetcode submit region end(Prohibit modification and deletion)
