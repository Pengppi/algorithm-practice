"""
Title: 165.比较版本号
Title Slug: compareVersionNumbers
Author: Neo
Date: 2024-05-04 16:44:34
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def compareVersion(self, version1: str, version2: str) -> int:
        v1 = version1.split(".")
        v2 = version2.split(".")
        i = 0
        while i < len(v1) and i < len(v2):
            x, y = int(v1[i]), int(v2[i])
            if x > y:
                return 1
            elif x < y:
                return -1
            else:
                i += 1
        while i < len(v1):
            if int(v1[i]) > 0:
                return 1
            i += 1
        while i < len(v2):
            if int(v2[i]) > 0:
                return -1
            i += 1
        return 0
# leetcode submit region end(Prohibit modification and deletion)
