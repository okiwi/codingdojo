class packman :
    pass

class Board :
    def __init__(self, size = 0) :
        self.grid = []
        self.initGrid(size)

    def getGrid(self) :
        return self.grid

    def initGrid(self, size):
        self.grid = [[0 for x in range(size)] for y in range(size)]
        for rowNumber in range(size):
            for columNumber in range(size):
                self.grid[rowNumber][columNumber] = '.'

    def setValue(self, coordinate, value) :
        self.grid[coordinate[0]][coordinate[1]] = value
