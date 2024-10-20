# Time Complexity : O(m * n)
# Space Complexity : O(m * n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no
# Problem Name: Number of Islands

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        self.m = len(grid)
        self.n = len(grid[0])
        self.dirs = [[-1,0],[0,-1],[0,1],[1,0]] 
        count = 0
        for i in range(self.m):
            for j in range(self.n):
                if grid[i][j] == "1":
                    count  += 1
                    self.dfs(grid, i ,j)
        
        return count

    def dfs(self, grid: List[List[str]], i: int, j: int):
        if i < 0 or j < 0 or j >= self.n or i >= self.m or grid[i][j] != "1":
            return 

        grid[i][j] = "0"
        for dr in self.dirs:
            r = dr[0] + i
            c = dr[1] + j
            self.dfs(grid, r, c)


        #--------bfs---------
        # m = len(grid)
        # n = len(grid[0])
        # dirs = [[-1,0],[0,-1],[0,1],[1,0]] 
        # q = []
        # count = 0
        # for i in range(m):
        #     for j in range(n):
        #         if grid[i][j] == "1":
        #             count += 1
        #             q.append([i,j])
        #             grid[i][j] = '0'

        #             while q:
        #                 curr = q.pop(0)
        #                 for dr in dirs:
        #                     print(curr, dr)
        #                     r = curr[0] + dr[0]
        #                     c = curr[1] + dr[1]

        #                     if r >= 0 and c >= 0 and r < m and c < n and grid[r][c] == "1":
        #                         q.append([r,c])
        #                         grid[r][c] = 0

        # return count

        