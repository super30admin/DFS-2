# Time Complexity: O(mn) where m and n is the size of the matrix
# Space Complexity:  O(mn)
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : No

# DFS
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        self.dirs = [[0,1],[0,-1],[1,0],[-1,0]]
        def dfs(grid,i,j):
            if i < 0 or i >= len(grid) or j < 0 or j >= len(grid[0]) or grid[i][j] != "1":
                return
            grid[i][j] = "0"
            for x, y in self.dirs:
                r = i + x
                c = j + y
                dfs(grid,r,c)
        
        count = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == "1":
                    count += 1
                    dfs(grid, i , j)
        return count
###########################
# BFS
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        count = 0
        q = deque()
        dirs = [[0,1],[0,-1],[1,0],[-1,0]]
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == "1":
                    count += 1
                    q.append([i,j])
                    grid[i][j] = "2"
                    while q:
                        cell = q.popleft()
                        for x, y in dirs:
                            r = cell[0] + x
                            c = cell[1] + y
                            if r >= 0 and r < len(grid) and c >=0 and c < len(grid[0]) and grid[r][c] == "1":
                                grid[r][c] = "2"
                                q.append([r,c])
        return count
