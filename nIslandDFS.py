'''
time complexity: O(m+n)
space complexity: O(m+n)
'''
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        
        
        count = 0
        def dfs(row,col):
            grid[row][col]=2
            
            for x,y in (0, 1), (0, -1), (1, 0), (-1, 0):
                new_x =row - x
                new_y = col - y
                if(0<=new_x<len(grid) and 0<=new_y<len(grid[0]) and
                    grid[new_x][new_y]=='1'):
                    dfs(new_x,new_y)
        
        for r in range(len(grid)):
            for c in range(len(grid[0])):
                if(grid[r][c]=='1'):
                    dfs(r,c)
                    count+=1
        return count