"""
Title: 690.员工的重要性
Title Slug: employeeImportance
Author: Neo
Date: 2024-08-26 12:28:42
"""
from typing import List


class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates


# leetcode submit region begin(Prohibit modification and deletion)
"""
# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""


class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        mp = {p.id: p for p in employees}

        def dfs(person: Employee) -> int:
            if not person:
                return 0

            res = person.importance
            for id in person.subordinates:
                res += dfs(mp[id])
            return res

        return dfs(mp[id])
# leetcode submit region end(Prohibit modification and deletion)
