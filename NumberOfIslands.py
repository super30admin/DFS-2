#Time Complexity: O(m*n)
#Space Complexity:O(m*n)
#Successfully ran on leetcode

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if len(grid)==0:
            return 0
        rows = len(grid)
        cols = len(grid[0])
        count = 0
        dirs = [[-1,0],[1,0],[0,-1],[0,1]]
        for i in range(rows):
            for j in range(cols):
                if grid[i][j]=="1":
                    count+=1
                    grid[i][j]="0"
                    queue = [[i,j]]
                    while queue:
                        curr = queue.pop(0)
                        for k in dirs:
                            row = curr[0]+k[0]
                            col = curr[1]+k[1]
                            if row>=0 and row<rows and col>=0 and col<cols and grid[row][col]=="1":
                                grid[row][col]="0"
                                queue.append([row,col])
        return count