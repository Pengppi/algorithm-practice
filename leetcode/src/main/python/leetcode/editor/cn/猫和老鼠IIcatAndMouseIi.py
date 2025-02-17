"""
Title: 1728.猫和老鼠 II
Title Slug: catAndMouseIi
Author: Neo
Date: 2025-02-11 12:41:33
"""
from collections import deque
from typing import List, Tuple


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    # 913. 猫和老鼠
    def catMouseGame(self, g_mouse: List[List[int]], g_cat: List[List[int]], mouse_start: int, cat_start: int, hole: int) -> int:
        n = len(g_mouse)
        deg = [[[0, 0] for _ in range(n)] for _ in range(n)]
        for i in range(n):
            for j in range(n):
                deg[i][j][0] = len(g_mouse[i])
                deg[i][j][1] = len(g_cat[j])

        winner = [[[0, 0] for _ in range(n)] for _ in range(n)]
        q = deque()
        for i in range(n):
            winner[hole][i][1] = 1  # 鼠到达洞中（此时轮到猫移动），鼠获胜
            winner[i][hole][0] = 2  # 猫到达洞中（此时轮到鼠移动），猫获胜
            winner[i][i][0] = winner[i][i][1] = 2  # 猫和鼠出现在同一个节点，无论轮到谁移动，都是猫获胜
            q.append((hole, i, 1))
            q.append((i, hole, 0))
            q.append((i, i, 0))
            q.append((i, i, 1))

        # 获取 (mouse, cat, turn) 的上个状态（值尚未确定）
        def get_pre_states() -> List[Tuple[int, int]]:
            if turn:  # 当前轮到猫移动，枚举上一轮鼠的位置
                return [(pre_mouse, cat) for pre_mouse in g_mouse[mouse] if winner[pre_mouse][cat][0] == 0]
            # 当前轮到鼠移动，枚举上一轮猫的位置
            return [(mouse, pre_cat) for pre_cat in g_cat[cat] if winner[mouse][pre_cat][1] == 0]

        # 减少上个状态的度数
        def dec_deg_to_zero() -> bool:
            deg[pre_mouse][pre_cat][pre_turn] -= 1
            return deg[pre_mouse][pre_cat][pre_turn] == 0

        while q:
            mouse, cat, turn = q.popleft()
            win = winner[mouse][cat][turn]  # 最终谁赢了
            pre_turn = turn ^ 1
            for pre_mouse, pre_cat in get_pre_states():
                # 情况一：如果上一回合鼠从 pre 移动到 cur，最终鼠赢，那么标记 pre 状态的 winner = 鼠
                # 情况二：如果上一回合猫从 pre 移动到 cur，最终猫赢，那么标记 pre 状态的 winner = 猫
                # 情况三：如果上一回合鼠从 pre 移动到 cur，最终猫赢，那么待定，直到我们发现从 pre 出发能到达的状态都是猫赢，那么标记 pre 状态的 winner = 猫
                # 情况四：如果上一回合猫从 pre 移动到 cur，最终鼠赢，那么待定，直到我们发现从 pre 出发能到达的状态都是鼠赢，那么标记 pre 状态的 winner = 鼠
                if pre_turn == win - 1 or dec_deg_to_zero():
                    winner[pre_mouse][pre_cat][pre_turn] = win
                    q.append((pre_mouse, pre_cat, pre_turn))

        # 鼠在节点 mouse_start，猫在节点 cat_start，当前轮到鼠移动
        return winner[mouse_start][cat_start][0]  # 返回最终谁赢了（或者平局）

    def canMouseWin(self, grid: List[str], catJump: int, mouseJump: int) -> bool:
        dirs = [0, -1, 0, 1, 0]
        m, n = len(grid), len(grid[0])
        gm = [[] for _ in range(m * n)]
        gc = [[] for _ in range(m * n)]
        for i, row in enumerate(grid):
            for j, c in enumerate(row):
                if c == '#':
                    continue
                if c == 'M':
                    mx, my = i, j
                elif c == 'C':
                    cx, cy = i, j
                elif c == 'F':
                    fx, fy = i, j
                v = i * n + j
                for k in range(4):
                    for d in range(mouseJump + 1):
                        x, y = i + dirs[k] * d, j + dirs[k + 1] * d
                        if x < 0 or x >= m or y < 0 or y >= n or grid[x][y] == '#':
                            break
                        gm[v].append(x * n + y)
                    for d in range(catJump + 1):
                        x, y = i + dirs[k] * d, j + dirs[k + 1] * d
                        if x < 0 or x >= m or y < 0 or y >= n or grid[x][y] == '#':
                            break
                        gc[v].append(x * n + y)
        return self.catMouseGame(gm, gc, mx * n + my, cx * n + cy, fx * n + fy) == 1
# leetcode submit region end(Prohibit modification and deletion)
