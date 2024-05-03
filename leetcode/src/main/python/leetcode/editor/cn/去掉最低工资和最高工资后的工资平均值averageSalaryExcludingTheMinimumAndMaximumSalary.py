"""
Title: 1491.去掉最低工资和最高工资后的工资平均值
Title Slug: averageSalaryExcludingTheMinimumAndMaximumSalary
Author: Neo
Date: 2024-05-03 00:23:52
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def average(self, salary: List[int]) -> float:
        return (sum(salary) - max(salary) - min(salary)) / (len(salary) - 2)

# leetcode submit region end(Prohibit modification and deletion)
