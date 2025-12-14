"""
Title: 3433.Count Mentions Per User
Title Slug: countMentionsPerUser
Author: Neo
Date: 2025-12-12 21:35:43
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:

    def countMentions(self, numberOfUsers: int,
                      events: List[List[str]]) -> List[int]:

        events.sort(key=lambda e: (int(e[1]), 0 if e[0] == 'OFFLINE' else 1))

        mentions = [0] * numberOfUsers
        sleep = [0] * numberOfUsers
        al = 0
        for event in events:
            time = int(event[1])
            if event[0] == 'OFFLINE':
                u = int(event[2])
                sleep[u] = time + 60
                continue
            if event[2] == 'ALL':
                al += 1
            elif event[2] == 'HERE':
                for i in range(numberOfUsers):
                    if sleep[i] <= time:
                        mentions[i] += 1
            else:
                for uid in event[2].split(' '):
                    u = int(uid[2:])
                    mentions[u] += 1

        for i in range(numberOfUsers):
            mentions[i] += al

        return mentions


# leetcode submit region end(Prohibit modification and deletion)
