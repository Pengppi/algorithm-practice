"""
Title: 3484.Design Spreadsheet
Title Slug: designSpreadsheet
Author: Neo
Date: 2025-09-19 12:36:54
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Spreadsheet:

    def __init__(self, rows: int):
        self.rows = [[0] * 26 for _ in range(rows)]

    def setCell(self, cell: str, value: int) -> None:
        x, y = self.parseCell(cell)
        self.rows[x][y] = value

    def resetCell(self, cell: str) -> None:
        self.setCell(cell, 0)

    def parseCell(self, cell: str) -> tuple[int, int]:
        col_char = cell[0]
        row_num = int(cell[1:])
        x = row_num - 1
        y = ord(col_char) - ord('A')
        return (x, y)

    def getCellValue(self, cell: str) -> int:
        if cell[0].isdigit():
            return int(cell)
        x, y = self.parseCell(cell)
        return self.rows[x][y]

    def getValue(self, formula: str) -> int:
        p_index = formula.find("+")
        val1 = formula[1:p_index]
        val2 = formula[p_index + 1:]
        return self.getCellValue(val1) + self.getCellValue(val2)

    # Your Spreadsheet object will be instantiated and called as such:


# obj = Spreadsheet(rows)
# obj.setCell(cell,value)
# obj.resetCell(cell)
# param_3 = obj.getValue(formula)
# leetcode submit region end(Prohibit modification and deletion)