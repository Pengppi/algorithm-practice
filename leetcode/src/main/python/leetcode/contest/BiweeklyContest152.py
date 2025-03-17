from collections import defaultdict
from functools import cache
from itertools import permutations
from typing import List


class Spreadsheet:

    def __init__(self, rows: int):
        self.mp = defaultdict(int)
        self.rows = rows

    def setCell(self, cell: str, value: int) -> None:
        idx = self.getIndex(cell)
        self.mp[idx] = value

    def getIndex(self, cell):
        col = ord(cell[0]) - ord('A')
        row = int(cell[1:]) - 1
        return row * 26 + col

    def getNum(self, cell: str):
        if cell.isdigit():
            return int(cell)
        return self.mp[self.getIndex(cell)]

    def resetCell(self, cell: str) -> None:
        self.setCell(cell, 0)

    def getValue(self, formula: str) -> int:
        p = formula.find("+")
        return self.getNum(formula[1:p]) + self.getNum(formula[p + 1:])


# Your Spreadsheet object will be instantiated and called as such:
# obj = Spreadsheet(rows)
# obj.setCell(cell,value)
# obj.resetCell(cell)
# param_3 = obj.getValue(formula)©leetcode


class Solution:
    class Tire:
        def __init__(self):
            self.children = {}
            self.freq = 0

        def insert(self, word: str):
            node = self
            for c in word:
                if c not in node.children:
                    node.children[c] = Solution.Tire()
                node = node.children[c]
                node.freq += 1

        def delete(self, word: str):
            node = self
            for c in word:
                if node.children[c].freq == 1:
                    del node.children[c]
                    return
                node.children[c].freq -= 1
                node = node.children[c]

    def longestCommonPrefix(self, words: List[str], k: int) -> List[int]:

        def dfs(node, mx):
            res = 0
            for child in node.children.values():
                if child.freq >= k:
                    res = max(res, 1 + dfs(child, mx - 1))
                    if res == mx:
                        return res
            return res

        n = len(words)
        ans = [0] * n
        if n <= k:
            return ans
        root = Solution.Tire()
        for i, word in enumerate(words):
            root.insert(word)

        mx = dfs(root, -1)

        for i, word in enumerate(words):
            root.delete(word)
            ans[i] = dfs(root, mx)
            root.insert(word)
        return ans


def totalNumbers(self, digits: List[int]) -> int:
    ans = set()
    for num in permutations(digits, 3):
        if num[0] != 0 and num[2] % 2 == 0:
            number = num[0] * 100 + num[1] * 10 + num[2]
            ans.add(number)
    return len(ans)
