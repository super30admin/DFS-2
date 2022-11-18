#Approach 1: DFS
# // Time Complexity : O(m x n), because we visit each element which is land and exploring all neighbours and their corresponding neighbours until we find water
# // Space Complexity : O(m x n) for recursive stack
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
class Solution:
    def dfs(self, row, col, grid, directions):
        if grid[row][col] != "1":
            return
        grid[row][col] = "#"
        
        for r, c in directions:
            newR = row + r
            newC = col + c
            if 0<= newR < len(grid) and 0<= newC < len(grid[0]) and grid[newR][newC] == "1":
                self.dfs(newR, newC, grid, directions)
        return
        
    def numIslands(self, grid: List[List[str]]) -> int:

        directions = [[1,0], [-1,0], [0,1], [0,-1]]
        row = len(grid)
        col = len(grid[0])
        number = 0

        for i in range(row):
            for j in range(col):
                if grid[i][j] == "1":
                    self.dfs(i, j, grid, directions)
                    print("hello")
                    number += 1
        
        return number

#approach 2: BFS
# // Time Complexity : O(m, n), because we visit each element which is land and exploring all neighbours and their corresponding neighbours until we find water
# // Space Complexity : O(min(m,n)) for diagonal access
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
class Solution:
    def bfs(self, grid, directions, r, c):
        q = collections.deque()
        q.append([r,c])
        while(q):
            size = len(q)
            while (size > 0):
                i, j = q.popleft()
                grid[i][j] = "#"
                for r, c in directions:
                    newR = i + r
                    newC = j + c
                    if 0<=newR<len(grid) and 0<=newC<len(grid[0]) and grid[newR][newC] == "1":
                        q.append([newR, newC])
                        grid[newR][newC] = "#"
                size -= 1
        return
        
    def numIslands(self, grid: List[List[str]]) -> int:

        directions = [[1,0], [-1,0], [0,1], [0,-1]]
        number = 0
        
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == "1":
                    self.bfs(grid, directions, i, j)
                    number += 1


        return number
        
        