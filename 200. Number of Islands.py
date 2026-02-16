# Time: O(m*n) it is actually 2(m*n) as in the worst case bfs would take m*n and we are looping on the matrix once. We don't see as m^2 n^2 is because we do not do the bfs for every one. The one is changed to 0 and then the bfs is not called on it
# Space: O min(m,n) The max elements we will have in the queue is of the diagonal which will be min between the sides

# BFS APPROACH

# First loop through the matrix and whenever we find 1 then increment the island ct by 1 and either call dfs or bfs to make all the elements in the island 0 so that we don't visit it again
# For the BFS approach first have a queue with the initial i and j where we found the '1' do not forget to change this element to '0'
# Then loop until q is not empty and go in all the directions and check if we have '1's if yes then add that to the q and make them '0'
# Return the island ct at the end
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        m = len(grid)
        n = len(grid[0])
        direc = [[0,1],[1,0],[0,-1],[-1,0]]

        islandCt = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == "1":
                    islandCt += 1
                    self.bfs(grid,i,j,direc,m,n)
        return islandCt

    def bfs(self,grid,r,c,direc,m,n):
        q = deque([(r,c)])
        grid[r][c] == "0"

        while q:
            currR, currC = q.popleft()
            for ro,co in direc:
                nr = currR + ro
                nc = currC + co
                if 0 <= nr < m and 0 <= nc < n and grid[nr][nc] == "1":
                    q.append((nr,nc))
                    grid[nr][nc] = "0"


# Time: O(m * n)
# Space: O(m * n) As there can be all 1's and we add all of them in the recursion stack

# DFS APPROACH

# In the dfs approach go in one direction of the element at a time and make them 0
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        m = len(grid)
        n = len(grid[0])
        direc = [[0,1],[1,0],[0,-1],[-1,0]]

        islandCt = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == "1":
                    islandCt += 1
                    self.dfs(i,j,m,n,grid,direc)
        return islandCt
    
    def dfs(self,i,j,m,n,grid,direc):
        if not (0 <= i < m and 0 <= j < n) or grid[i][j] == '0': return
        grid[i][j] = '0'

        for r,c in direc:
            nr = i + r
            nc = j + c
            self.dfs(nr,nc,m,n,grid,direc)