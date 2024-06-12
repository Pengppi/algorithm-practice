"""
Title: LCR 033.字母异位词分组
Title Slug: sfvd7V
Author: Neo
Date: 2024-06-12 19:35:33
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        map = dict()
        for word in strs:
            key = "".join(sorted(word))
            if key not in map:
                map[key] = []
            map[key].append(word)

        return list(map.values())
# leetcode submit region end(Prohibit modification and deletion)
