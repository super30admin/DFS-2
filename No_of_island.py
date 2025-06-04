from collections import deque

# Time Complexity : O(m*n)
# Space Complexity : O(m*n)

class Solution:
    def numIslands(self, grid) -> int:


        rows = len(grid)
        cols = len(grid[0])
        no_of_island = 0
        dirs = [[1,0],[-1,0],[0,1],[0,-1]]
        visited = set()

        def bfs(i,j):
            queue = deque()
            visited.add((i,j))
            queue.append([i,j])

            while queue:
                row,col = queue.popleft()
                for x,y in dirs:
                    if 0<= x+row < rows and 0<=y+col<cols and grid[x+row][y+col]=="1" and (x+row,y+col) not in visited:
                        queue.append([x+row,y+col])
                        visited.add((x+row,y+col))


        for i in range(0,rows):
            for j in range(0,cols):
                if grid[i][j]=="1" and (i,j) not in visited:
                    no_of_island +=1
                    bfs(i,j)

        return no_of_island








        