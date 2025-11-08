"""
Title: 2043.Simple Bank System
Title Slug: simpleBankSystem
Author: Neo
Date: 2025-10-26 14:37:20
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Bank:

    def __init__(self, balance: List[int]):
        self.ba = balance

    def transfer(self, account1: int, account2: int, money: int) -> bool:
        ba = self.ba
        a, b = account1 - 1, account2 - 1
        if a < 0 or a >= len(ba) or b < 0 or b >= len(ba) or ba[a] < money:
            return False
        ba[a] -= money
        ba[b] += money
        return True

    def deposit(self, account: int, money: int) -> bool:
        ba = self.ba
        a = account - 1
        if a < 0 or a >= len(ba):
            return False
        ba[a] += money
        return True

    def withdraw(self, account: int, money: int) -> bool:
        ba = self.ba
        a = account - 1
        if a < 0 or a >= len(ba):
            return False
        if ba[a] < money:
            return False
        self.ba[a] -= money
        return True

# Your Bank object will be instantiated and called as such:
# obj = Bank(balance)
# param_1 = obj.transfer(account1,account2,money)
# param_2 = obj.deposit(account,money)
# param_3 = obj.withdraw(account,money)
# leetcode submit region end(Prohibit modification and deletion)
