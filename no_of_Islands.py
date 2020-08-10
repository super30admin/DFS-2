# Leetcode 200. Number of Islands

# Time Complexity :  O(m X n) where m X n is the size of the grid

# Space Complexity :
# BFS:: O(min(m,n)) as the number of nodes in Q is limited by the shorter dimension of grid
# DFS :: O(m X n) where m X n is the size of the grid

# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach: DFS :: Find the island and call dfs from it. IN dfs mark the island as visited and 
# call dfs on its neighbours. Increment the conunter every time a new island is found.
# BFS:: add the island to que, if the neighbours are also island mark them as visited to avoid 
# revisiting and add to q. When a new island is found increment the count & return once the q is empty.

# Your code here along with comments explaining your approach

class Solution:
    m = None
    n = None
    count = 0

    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid or len(grid) == 0:
            return 0
        self.m = len(grid)
        self.n = len(grid[0])
        # Find the island and start dfs from it
        for i in range(self.m):
            for j in range(self.n):
                if grid[i][j] == "1":
                    self.count += 1
                    self.dfs(grid, i, j)
        return self.count

    def dfs(self, grid, i, j):
        dirs = {(0, 1), (0, -1), (1, 0), (-1, 0)}
        # If its already a "0" then its not an island so return
        if i < 0 or i >= self.m or j < 0 or j >= self.n or grid[i][j] == "0":
            return
        # If its "1", make it "0" to avoid re visiting
        grid[i][j] = "0"
        # Then call dfs recursively
        for direc in dirs:
            r = direc[0] + i
            c = direc[1] + j
            self.dfs(grid, r, c)



from collections import deque

class Solution:
    
    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid or len(grid)== 0:
            return 0
        m = len(grid)
        n = len(grid[0])
        count = 0
        dirs = {(0,1),(0,-1),(1,0),(-1,0)}
        q = deque()
        # Find the first island and start dfs from it 
        for i in range(m):
            for j in range(n):
                # If its "1", make it "0" to avoid re visiting, add it Q, increment count
                if grid[i][j] == "1":
                    count += 1
                    q.append((i,j))
                    grid[i][j] = "0"
                    while q:
                        x,y = q.popleft()
                        # Check neighbours of left most entry in q   
                        for direc in dirs:
                            r = direc[0] + x
                            c = direc[1] + y
                            # If its an island and in bound
                            if m>r>=0 and n>c>=0 and grid[r][c] == "1":
                                # Change it 0 to mark it as visited and add it q
                                grid[r][c] = "0"
                                q.append((r,c))
        return count