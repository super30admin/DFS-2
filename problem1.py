'''
200. Number of Islands

APPROACH 1: DFS
TIME COMPLEXITY: O(M*N)
SPACE COMPLEXITY: O(M*N)
LEETCODE: YES
DIFFICULTIES: Nope. I solved it after the class

APPROACH 1: BFS
TIME COMPLEXITY: O(M*N)
SPACE COMPLEXITY: min(M,N)
LEETCODE: YES
DIFFICULTIES: Nope. I solved it after the class

'''

from collections import deque
class Solution:
    def numIslands(self, ggrid: List[List[str]]) -> int:
        global dirs, grid
        grid = ggrid
        dirs = [(-1,0), (1,0), (0,1), (0,-1)]
        
        # DFS
        def approach1():
            global m, n
            m = len(grid)
            n = len(grid[0])
            ic = 0
            
            def dfs(i, j):
                global dirs, grid, m, n
                # base
                if i < 0 or j < 0 or i >= m or j >= n or grid[i][j] == '0':
                    return 
                
                # logic
                grid[i][j] = '0'
                for dirr, dirc in dirs:
                    nr = i + dirr
                    nc = j + dirc 
                    
                    dfs(nr, nc)
            
            for i in range(0, m):
                for j in range(0, n):
                    if grid[i][j] == '1':
                        ic += 1
                        dfs(i, j)
                        
            return ic
        
        # BFS
        def approach2():
            m = len(grid)
            n = len(grid[0])
            q = deque()
            ic = 0
            
            for i in range(0, m):
                for j in range(0, n):
                    if grid[i][j] == '1':
                        ic += 1
                        q.append((i,j))
                        while len(q) != 0:
                            sz = len(q)
                            for k in range(0, sz):
                                ii, jj = q.popleft()
                                
                                for dirr, dirc in dirs:
                                    nr = ii + dirr
                                    nc = jj + dirc
                                    
                                    if nr >= 0 and nc >= 0 and nr < m and nc < n and grid[nr][nc] == '1':
                                        grid[nr][nc] = '0'
                                        q.append((nr, nc))
            
            return ic
        
        return approach1()
        #return approach2()
    
