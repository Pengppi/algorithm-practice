"""
Title: 676.实现一个魔法字典
Title Slug: implementMagicDictionary
Author: Neo
Date: 2024-08-12 12:24:32
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class MagicDictionary:

    def __init__(self):
        self.root = Tire()

    def buildDict(self, dictionary: List[str]) -> None:
        for word in dictionary:
            self.root.insert(word)

    def search(self, searchWord: str) -> bool:
        node = self.root
        for i, c in enumerate(searchWord):
            for ch in node.children:
                if c == ch:
                    continue
                child = node.children[ch]
                if child.search(searchWord[i + 1:]):
                    return True
            if c not in node.children:
                return False
            node = node.children[c]
        return False


class Tire:
    def __init__(self):
        self.children = {}
        self.end = False

    def insert(self, word: str):
        node = self
        for c in word:
            if c not in node.children:
                node.children[c] = Tire()
            node = node.children[c]
        node.end = True

    def search(self, word: str) -> bool:
        node = self
        for c in word:
            if c not in node.children:
                return False
            node = node.children[c]
        return node.end


# Your MagicDictionary object will be instantiated and called as such:
# obj = MagicDictionary()
# obj.buildDict(dictionary)
# param_2 = obj.search(searchWord)
# leetcode submit region end(Prohibit modification and deletion)
mg = MagicDictionary()
mg.buildDict(["hello", "leetcode"])
mg.search("hhllo")

