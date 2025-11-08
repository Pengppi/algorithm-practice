"""
Title: 1611.Minimum One Bit Operations to Make Integers Zero
Title Slug: minimumOneBitOperationsToMakeIntegersZero
Author: Neo
Date: 2025-11-08 10:50:26
"""

# leetcode submit region begin(Prohibit modification and deletion)

"""
0~15的转换顺序是0-1-3-2-6-7-5-4-12-13-15-14-10-11-9-8（这个变换规则是可逆的）,
把1变成0需要1步，把2变成0需要3步，把4变成0需要7步，把8变成0需要15步，把2^x变成0需要2^(x+1)-1步
然后再进一步找规律，12变成0需要8步(15-7), 13变成0需要9步(15-7+1), 15变成0需要10步(15-7+3-1)，至此就找出规律了。
"""


class Solution:
    def minimumOneBitOperations(self, n: int) -> int:
        ans = 0
        l = n.bit_length()
        flg = 1
        for i, e in enumerate(bin(n)[2:]):
            if e == '0':
                continue
            cur = 2 ** (l - i) - 1
            ans += cur * flg
            flg = -flg
        return ans
# leetcode submit region end(Prohibit modification and deletion)

