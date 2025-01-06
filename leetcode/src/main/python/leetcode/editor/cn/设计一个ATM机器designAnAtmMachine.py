"""
Title: 2241.设计一个 ATM 机器
Title Slug: designAnAtmMachine
Author: Neo
Date: 2025-01-05 15:10:00
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class ATM:

    def __init__(self):
        mp = [20, 50, 100, 200, 500]
        cnt = [0] * 5
        self.mp = mp
        self.cnt = cnt

    def deposit(self, banknotesCount: List[int]) -> None:
        for i in range(5):
            self.cnt[i] += banknotesCount[i]

    def withdraw(self, amount: int) -> List[int]:
        res = []
        for i in range(4, -1, -1):
            cur = self.mp[i]
            cur_cnt = amount // cur
            if cur_cnt > self.cnt[i]:
                cur_cnt = self.cnt[i]
            amount -= cur_cnt * cur
            self.cnt[i] -= cur_cnt
            res.insert(0, cur_cnt)
        if amount != 0:
            for i in range(5):
                self.cnt[i] += res[i]
            return [-1]
        return res
# Your ATM object will be instantiated and called as such:
# obj = ATM()
# obj.deposit(banknotesCount)
# param_2 = obj.withdraw(amount)
# leetcode submit region end(Prohibit modification and deletion)
