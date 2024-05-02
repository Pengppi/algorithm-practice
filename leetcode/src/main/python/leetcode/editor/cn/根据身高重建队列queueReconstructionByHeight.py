"""
Title: 406.根据身高重建队列
Title Slug: queueReconstructionByHeight
Author: Neo
Date: 2024-05-02 22:47:05
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        n = len(people)
        people.sort(key=lambda x: (-x[0], x[1]))
        ans = list()
        print(people)
        for person in people:
            ans.insert(person[1], person)
        return ans
# leetcode submit region end(Prohibit modification and deletion)
