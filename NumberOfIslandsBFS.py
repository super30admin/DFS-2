'''
TC: O(m*n), m and n being rows and columns specifically
SC: O(m+n) ~ min of m and n
'''
from collections import deque
from typing import List

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        ROWS, COLS = len(grid), len(grid[0])
        dirs = [(-1,0),(0,-1),(1,0),(0,1)]
        q = deque()
        count = 0

        def bfs(q):
            while q:
                x,y = q.popleft()
                for dir_ in dirs:
                    nx,ny = x+dir_[0], y+dir_[1]
                    if nx>=0 and ny>=0 and nx<ROWS and ny<COLS and grid[nx][ny] == '1':
                        q.append((nx,ny))
                        grid[nx][ny] = '0'

        for i in range(ROWS):
            for j in range(COLS):
                if grid[i][j] == '1':
                    count += 1
                    grid[i][j] = '0'
                    q.append((i,j))
                    bfs(q)
        
        return count
    
s = Solution()
print(s.numIslands([["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]))
print(s.numIslands([["1","1","0","0","0"],["1","1","0","0","0"],["0","0","1","0","0"],["0","0","0","1","1"]]))
