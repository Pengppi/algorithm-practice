"""
Title: 722.删除注释
Title Slug: removeComments
Author: Neo
Date: 2024-08-29 23:34:36
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def removeComments(self, source: List[str]) -> List[str]:
        ans = []
        flg = False
        tmp = ''
        for s in source:
            n = len(s)
            i = 0
            while i < n:
                if flg:
                    j = s.find('*/', i)
                    if j == -1:
                        break
                    else:
                        flg = False
                        i = j + 2
                else:
                    if i + 1 < n and s[i:i + 2] == '/*':
                        flg = True
                        i = i + 2
                        continue
                    elif i + 1 < n and s[i:i + 2] == '//':
                        break
                    else:
                        tmp += s[i]
                        i += 1
            if not flg and tmp:
                ans.append(tmp)
                tmp = ''
        return ans

# leetcode submit region end(Prohibit modification and deletion)
