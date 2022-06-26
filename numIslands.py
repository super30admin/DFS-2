"""
TC/SC:O(mn)/O(mn)
"""
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        dirs=[[0,1],[0,-1],[1,0],[-1,0]]
        count = 0
        rows = len(grid)
        cols = len(grid[0])
        def markcurrent(r,c):
            q=[[r,c]]
            while q:
                row,col = q.pop() 
                grid[row][col] = "-1"
                for i,j in dirs:
                    nr = row + i
                    nc = col + j
                    if 0<= nr < rows and 0 <= nc < cols and grid[nr][nc] == "1":
                        q.append([nr,nc])
                         
                
        for row in range(rows):
            for col in range(cols):
                if grid[row][col] != "1":
                    continue
                markcurrent(row, col)
                count += 1
        return count
