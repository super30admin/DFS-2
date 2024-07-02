# Depth first search
# Time Complexity : O(m*n)
# space complexity : O(m*n)

# Approach :

# use dfs
# use dir array and use dfs to move recursively 4 adjacent dimensionally.
# at each stage make it 2 if it is not out of bounds and value is 1
# if each one dfs round is completed, and any ones remaining, do another dfs
# count == no of dfs completed


class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:

        if not grid:
            return None

        self.rows = len(grid)
        self.cols = len(grid[0])
        self.dirs = [[-1, 0], [1, 0], [0, -1], [0, 1]]
        self.mat = grid
        count = 0

        for i in range(self.rows):
            for j in range(self.cols):
                if grid[i][j] == "1":
                    self.dfs(i, j)
                    count = count+1
        return count

    def dfs(self, row, col):

        if row == self.rows or row < 0 or col == self.cols or col < 0 or self.mat[row][col] != "1":
            return
        self.mat[row][col] = 2
        for dirVal in self.dirs:
            nr = dirVal[0] + row
            nc = dirVal[1] + col
            self.dfs(nr, nc)

# Breadth first search


# Time Complexity : O(m*n)
# space complexity : O(min(m,n))

# Approach :

# use bfs
# use a queue and append to it the row and column of 1,increment count and change it to 2
# for a particular row and column change it to the target row,column by moving 4 adjacent dimensionally and if it is 1 then make it 2
# if queue is empty and still there is 1 left, increment count and do bfs
# count == no of bfs completed

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:

        if not grid:
            return None

        self.rows = len(grid)
        self.cols = len(grid[0])
        self.dirs = [[-1, 0], [1, 0], [0, -1], [0, 1]]
        self.mat = grid
        count = 0
        q = deque()
        for i in range(self.rows):
            for j in range(self.cols):
                if self.mat[i][j] == "1":
                    self.mat[i][j] = 2
                    q.append([i, j])
                    count = count+1
                    while q:
                        poppedVal = q.popleft()
                        for dirVal in self.dirs:
                            nr = dirVal[0] + poppedVal[0]
                            nc = dirVal[1] + poppedVal[1]
                            if nr < self.rows and nr >= 0 and nc < self.cols and nc >= 0 and self.mat[nr][nc] == "1":
                                self.mat[nr][nc] = 2
                                q.append([nr, nc])

        return count
