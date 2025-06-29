"""
Title: 2014.重复 K 次的最长子序列
Title Slug: longestSubsequenceRepeatedKTimes
Author: Neo
Date: 2025-06-27 14:40:34
"""
from collections import Counter


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def longestSubsequenceRepeatedK(self, s: str, k: int) -> str:
        c_cnt = Counter(s)
        chs = []
        for c, cnt in c_cnt.items():
            if cnt >= k:
                d = cnt // k
                chs.extend([c] * d)
        if not chs:
            return ''
        ss = [c for c in s if c in chs]
        chs.sort(reverse=True)
        ans = ''

        def check(selected: str) -> bool:
            """
            检查selected字符串是否在ss字符串中出现k次。

            Args:
            selected (str): 要检查的字符串。

            Returns:
            bool: 如果selected在ss中出现k次，则返回True，否则返回False。
            """
            # 获取selected字符串的长度
            n = len(selected)
            # 如果selected为空，则直接返回False
            if n == 0:
                return False
            
            # 初始化索引i和计数器k_cnt
            i = 0
            k_cnt = 0

            # 遍历ss字符串
            for j in range(len(ss)):
                # 如果selected的当前字符与ss的字符匹配，则移动selected的索引
                if selected[i] == ss[j]:
                    i += 1
                    # 如果selected的所有字符都匹配成功，则计数器加1，并重置索引
                    if i == n:
                        k_cnt += 1
                        # 如果计数器达到k，则返回True
                        if k_cnt == k:
                            return True
                        i = 0

            # 如果遍历完ss后没有满足条件，则返回False
            return False

        # 回溯穷举
        def dfs(selected: str):
            nonlocal ans
            if len(selected) > len(ans) and check(selected):
                ans = selected
            if chs:
                for i in range(len(chs)):
                    c = chs.pop(i)
                    dfs(selected + c)
                    chs.insert(i, c)

        dfs('')
        return ans


# leetcode submit region end(Prohibit modification and deletion)
Solution().longestSubsequenceRepeatedK("kkrkmktkkhqdlkzqfdmkkghjk", 9)
