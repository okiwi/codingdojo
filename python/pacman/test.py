from packman import *
import unittest

class testpackman(unittest.TestCase) :

    def test_aGridExist(self) :
        board = Board()
        self.assertTrue(board.getGrid() is not None)

    def test_whenBoardIsInitWithThreeShouldInitGridThreeByThree(self) :
        board = Board(3)
        grid = board.getGrid()
        self.assertEquals(len(grid), 3)
        for row in grid:
            self.assertEquals(len(row), 3)

    def test_setValueInGrid(self):
        board = Board(3)
        board.setValue((1,2), 1)
        self.assertEquals(board.grid[1][2], 1)

    def test_dotValueInGrid(self):
        board = Board(3)
        grid = board.getGrid()
        for row in grid :
            for cell in row :
                self.assertEquals(cell,".")




if __name__ == "__main__" :
    unittest.main()
