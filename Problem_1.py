"""
Problem : 1

Time Complexity : O(m*n)

Space Complexity : 

For BFS - O(min(m,n))
For DFS - O(m*n)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


For BFS - 
Iterating over the matrix to find the first occurence of 1, increasing the counter by 1, as first island encountered, 
then performing bfs on all of its neighbours which are 1, until 0 is encountered, and changing all of the neighbors values to 0, to stop multiple visits,
after the bfs stop, continue iterating over matrix until another 1 is found, repeating the same process till we reach end of the matrix

For DFS - 
Iterating over the matrix to find the first occurence of 1, if found, increasing the counter by 1 and performing recursive dfs on that cell over its neighbors,
which has value 1, changing the value to 0, until 0 is encountered or cell is out of bounds of matrix dimensions, repeating the task until iterated over entire matrix

"""

# Number of islands

# Approach - 1
# BFS

class Solution(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        m=len(grid)
        n=len(grid[0])
        directions=[[1,0],[0,-1],[-1,0],[0,1]]
        count=0
        
        for i in range(m):
            for j in range(n):
                if grid[i][j]=="1":
                    count+=1
                    q=collections.deque()
                    q.append((i,j))

                    while q:
                        curr=q.popleft()
                        for dirs in directions:
                            r=dirs[0]+curr[0]
                            c=dirs[1]+curr[1]
                            if r<m and r>=0 and c<n and c>=0 and grid[r][c]=="1":
                                grid[r][c]="0"
                                q.append((r,c))



        return count


# Approach - 2
# DFS

class Solution(object):
    def __init__(self):
        self.res=None
        self.count=0
        self.directions=[[1,0],[0,-1],[-1,0],[0,1]]
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        m=len(grid)
        n=len(grid[0])
        self.res=[[None for _ in range(n)] for _ in range(m)]
        for i in range(m):
            for j in range(n):
                self.res[i][j]=grid[i][j]

        
        
        for i in range(m):
            for j in range(n):
                if self.res[i][j]=="1":
                    self.count+=1
                    self.dfs(i,j,m,n)
        return self.count
        
    def dfs(self,i,j,m,n):
        if i==m or i<0 or j==n or j<0 or self.res[i][j]=="0":
            return
        self.res[i][j]="0"
        for dirs in self.directions:
            r=dirs[0]+i
            c=dirs[1]+j
            self.dfs(r,c,m,n)