
# Solution
# // Time Complexity : O(m*n) since we are navigating all cells in outerloop and inner while loop in worst case runs m*n but once
#                       that is run, there will no more runs of while loop.
# // Space Complexity : For BFS approach minimum(m,n), at a point in stack it will be maximum of minimum(m,n)
#                       For DFS approach it would be m*n if all are 1's
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : None


# // Your code here along with comments explaining your approach
# Approach is BFS, find the first 1, consider that as starting point, check if 4-directional adjacent cells are 1's. If they are
# then keep adding those indices in queue and further check for each of those 1's if there are 1's in their 4-directional cells
# Once all adjacent 1's are done, we can continue the outer loop to find the next 1 which was not adjacent to previous 1.
# We can increase the counter everytime a new 1 is found in outer loop to have the right count of islands

from collections import deque

def numIslands(grid):
        # DFS
        def dfs(i,j,grid,rowLen,colLen):
            if i<0 or j<0 or i>=rowLen or j>=colLen or grid[i][j] == "0":
                return
            grid[i][j] = "0"
            dfs(i-1,j,grid,rowLen,colLen)
            dfs(i,j-1,grid,rowLen,colLen)
            dfs(i+1,j,grid,rowLen,colLen)
            dfs(i,j+1,grid,rowLen,colLen)

        if grid == None or len(grid) == 0:
            return 0
        counter = 0
        rowLen = len(grid)
        colLen = len(grid[0])
        for i in range(rowLen):
            for j in range(colLen):
                if grid[i][j] == "1":
                    counter += 1
                    dfs(i,j,grid,rowLen,colLen)
        
        return counter
        # BFS
        # if grid == None or len(grid) == 0:
        #     return 0
        # oneStack = deque()
        # counter = 0
        # rowLen = len(grid)
        # colLen = len(grid[0])
        # for i in range(rowLen):
        #     for j in range(colLen):
        #         if grid[i][j] == "1":
        #             counter += 1
        #             oneStack.append([i,j])
        #             while oneStack:
        #                 rowCol = oneStack.popleft()
        #                 if rowCol[0]>0 and grid[rowCol[0]-1][rowCol[1]] == "1":
        #                      grid[rowCol[0]-1][rowCol[1]] = "0"
        #                      oneStack.append([rowCol[0]-1,rowCol[1]])
        #                 if rowCol[1]>0 and grid[rowCol[0]][rowCol[1]-1] == "1":
        #                      grid[rowCol[0]][rowCol[1]-1] = "0"
        #                      oneStack.append([rowCol[0],rowCol[1]-1])
        #                 if rowCol[0]+1<rowLen and grid[rowCol[0]+1][rowCol[1]] == "1":
        #                      grid[rowCol[0]+1][rowCol[1]] = "0"
        #                      oneStack.append([rowCol[0]+1,rowCol[1]])
        #                 if rowCol[1]+1<colLen and grid[rowCol[0]][rowCol[1]+1] == "1":
        #                      grid[rowCol[0]][rowCol[1]+1] = "0"
        #                      oneStack.append([rowCol[0],rowCol[1]+1])
        
        # return counter
                             
if __name__ == "__main__":
    #  grid = [["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]
     grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
     print(numIslands(grid))