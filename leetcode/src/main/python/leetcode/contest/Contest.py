from collections import deque
from typing import List




class Solution:
    def removeSubstring(self, s: str, k: int) -> str:
        ks = "(" * k + ")" * k
        while ks in s:
           s = s.replace(ks,'')
        return s



print(Solution().removeSubstring("(())", 1))