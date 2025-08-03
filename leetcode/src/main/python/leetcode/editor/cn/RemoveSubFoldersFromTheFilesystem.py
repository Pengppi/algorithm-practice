"""
Title: 1233.Remove Sub-Folders from the Filesystem
Title Slug: removeSubFoldersFromTheFilesystem
Author: Neo
Date: 2025-07-19 17:48:17
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Tire:
    def __init__(self):
        self.children = {}
        self.end = False

    def insert(self, path: str) -> bool:
        node = self
        folders = path.split('/')
        for c in folders:
            if node.end:
                return False
            if c not in node.children:
                node.children[c] = Tire()
            node = node.children[c]
        node.end = True
        return True


class Solution:

    def removeSubfolders(self, folder: List[str]) -> List[str]:
        root = Tire()
        return [path for path in sorted(folder) if root.insert(path)]

# leetcode submit region end(Prohibit modification and deletion)
