// Time Complexity : O(n)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
we did this problem in DFS method.we traverse the whole matrix and find if any element is having value as 1.Then we perform BFS on four directions and swap 1 to 0 to make sure that that element is visited.we keep track of count of islands .we do this we reach the end of matrix.

# DFS
class Solution(object):
    def __init__(self):
        self.count=0
    def helper(self,grid,row,col):
        if row<0 or row>=len(grid) or col<0 or col>=len(grid[0]):
            return
        
        dirs=[[0,1],[1,0],[-1,0],[0,-1]]
        for i in dirs:
            row1=row+i[0]
            col1=col+i[1]
            if 0<=row1<len(grid) and 0<=col1<len(grid[0]):
                if grid[row1][col1]=='1':
                    grid[row1][col1]=0
                    self.helper(grid,row1,col1)
        return
                
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        if grid==None or len(grid)==0:
            return 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j]=='1':
                    grid[i][j]=0
                    self.count=self.count+1
                    self.helper(grid,i,j)
        print(grid)
        return self.count    
                            
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
we used BFS approach.In this we have used a queue data staructure and traversed through the grid.when we find a element having value as 1.we increment the count and then traverse in all the four directions till we made sure all the elements in that surrounding are covered.we end this process when the queue becomes empty.

# BFS
from collections import deque
class Solution(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        count=0
        if grid==None or len(grid)==0:
            return count
        dirs=[[0,1],[1,0],[-1,0],[0,-1]]
        queue=deque([])
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j]=='1':
                    count=count+1
                    queue.append([i,j])
                    while(len(queue)!=0):
                        q=queue.popleft()
                        for k in dirs:
                            row=q[0]+k[0]
                            col=q[1]+k[1]
                            if 0<=row<len(grid) and 0<=col<len(grid[0]) and grid[row][col]=='1':
                                grid[row][col]=0
                                queue.append([row,col])
        return count
        
        