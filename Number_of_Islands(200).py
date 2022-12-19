# Time Complexity: O(m*n)
# Space Complexity: O(m*n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# here we perform DFS for every land found in the matrix
# Once we have visited a land, we change it to 0 so that it is not counted again

class Solution:
    def __init__(self):
        self.dirs = None
        self.islands = None
        self.row_l = None
        self.col_l = None

    def numIslands(self, grid: List[List[str]]) -> int:
        self.row_l = len(grid)
        self.col_l = len(grid[0])
        self.islands = 0
        self.dirs = [[-1,0],[0,-1],[1,0],[0,1]]

        for i in range(self.row_l):
            for j in range(self.col_l):
                if grid[i][j]=="1":
                    self.islands+=1
                    self.dfs(grid,i,j)
                    # every time we complete 1 dfs that is an entire island
                    # since we change the visited lands to "0",we wont count them again
        return self.islands

    def dfs(self,grid,row,col):
        if grid[row][col]!="1":
            return
        grid[row][col]="0"

        for dir in self.dirs:
            nr = row + dir[0]
            nc = col + dir[1]
            if (nr>=0 and nr<self.row_l) and (nc>=0 and nc<self.col_l):
                self.dfs(grid,nr,nc)


    # BFS Solution
    # def numIslands(self, grid: List[List[str]]) -> int:
    #     row_l = len(grid)
    #     col_l = len(grid[0])
    #     islands = 0
    #     dirs = [[-1,0],[0,-1],[1,0],[0,1]]

    #     for i in range(row_l):
    #         for j in range(col_l):
    #             if grid[i][j]=="1":
    #                 islands+=1
    #                 grid[i][j]="0"
    #                 queue = [[i,j]]

    #                 while len(queue)!=0:
    #                     curr = queue.pop(0)
    #                     row = curr[0]
    #                     col = curr[1]
    #                     for dir in dirs:
    #                         nr = row + dir[0]
    #                         nc = col + dir[1]
    #                         if (nr>=0 and nr<row_l) and (nc>=0 and nc<col_l):
    #                             if grid[nr][nc]=="1":
    #                                 grid[nr][nc] = "0"
    #                                 queue.append([nr,nc])
    #     return islands