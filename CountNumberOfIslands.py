# Time Complexity : O(m*n) Every cell in the grid is visited exactly once, and for each visit, we check up to 4 neighbors, which is constant work.
# Space Complexity : O(min(m,n)) The queue can hold up to a full row or column of the grid in the worst case (e.g., a narrow, snake-like island).
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : N/A


# Your code here along with comments explaining your approach
class Solution:
    #BFS Approach
    def numIslands(self, grid: List[List[str]]) -> int:
        #Assignt the required variables
        m = len(grid)
        n = len(grid[0])
        count = 0
        q = deque()
        dirs = [(-1,0),(1,0),(0,-1),(0,1)]
        #Go through the matrix where there are 1's
        for i in range(0,m):
            for j in range(0,n):
                #If the current element is one update the no.of islands variable, i.e, to 1
                if(grid[i][j]=="1"):
                    count+=1
                    q.append((i,j))
                    #After updating count make it to 0 which denotes are visited element
                    grid[i][j]="0"
                    while(len(q)>0):
                        curr = q.popleft()
                        #If the current element is 1, Go throught the four direction (left,right,top,bottom) and search if it's neighbors are 1
                        for dir in dirs:
                            r = curr[0] + dir[0]
                            c = curr[1] + dir[1]
                            #Any of the four neighbors are 1 then take them into the list and continue checking their neighbors
                            if(r>=0 and c>=0 and r<m and c<n and grid[r][c]=="1"):
                                q.append((r,c))
                                grid[r][c]="0"
        return count

    #DFS Approach
    def numIslands(self, grid: List[List[str]]) -> int:
        #Assignt the required variables
        self.m = len(grid)
        self.n = len(grid[0])
        count = 0
        self.dirs = [(-1,0),(1,0),(0,-1),(0,1)]
        #Go through the matrix where there are 1's
        for i in range(0,self.m):
            for j in range(0,self.n):
                #If the current element is one update the no.of islands variable, i.e, to 1
                if(grid[i][j]=="1"):
                    count+=1
                    self.dfs(grid, i, j)
        return count
    def dfs(self,grid, i, j):
        if(i<0 or j<0 or i==self.m or j==self.n or grid[i][j]!="1"):
            return
        grid[i][j]="0"
        for dir in self.dirs:
            r = dir[0] + i
            c = dir[1] + j
            self.dfs(grid, r, c)