# """
# Title: 3516.Find Closest Person
# Title Slug: findClosestPerson
# Author: Neo
# Date: 2025-09-04 12:47:35
# """
#
#
# # leetcode submit region begin(Prohibit modification and deletion)
# class Solution:
#     def findClosest(self, x: int, y: int, z: int) -> int:
#         dist_xz = abs(x - z)
#         dist_yz = abs(y - z)
#         if dist_xz == dist_yz:
#             return 0
#         elif dist_xz < dist_yz:
#             return 1
#         else:
#             return 2
# # leetcode submit region end(Prohibit modification and deletion)
