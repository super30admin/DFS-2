#----------------Solution 1 : BFS -----------
''' Time Complexity : O(m*n) 
    Space Complexity : O(miun(m,n)) , as bfs is traversing diagonally
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No

   Approach : Run BFS at each index where it has 1's, Make it 0 and add to the queue.
                Increament the island count at begining of each bfs.
'''
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        rows, cols = len(grid), len(grid[0])
        dirs = [(0,1),(0,-1),(1,0),(-1,0)]
        q = deque()
        island = 0

        for i in range(rows):
            for j in range(cols):
                if grid[i][j] == "1":
                    island += 1
                    grid[i][j] = "0"
                    q.append((i,j))
                    while q : 
                        curr = q.popleft()
                        for dir in dirs:
                            r = dir[0] + curr[0]
                            c = dir[1] + curr[1]
                            if 0<=r<rows and 0<=c<cols and grid[r][c] == "1":
                                grid[r][c] = "0"
                                q.append((r,c))
        
        return island

#----------------Solution 2 : DFS -----------
''' Time Complexity : O(m*n) 
    Space Complexity : O(m*n)
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No

   Approach : Run DFS at each index where it has 1's, Make it 0 
                Increament the island count at begining of each dfs.
'''
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        rows, cols = len(grid), len(grid[0])
        dirs = [(0,1),(0,-1),(1,0),(-1,0)]
        island = 0
        def dfs(i,j):
            grid[i][j] = "0"
            for dir in dirs:
                r = dir[0] + i
                c = dir[1] + j
                if 0<=r<rows and 0<=c<cols and grid[r][c] == "1":
                    dfs(r,c)

        for i in range(rows):
            for j in range(cols):
                if grid[i][j] == "1":
                    dfs(i,j)
                    island += 1 
        return island
