#Time complexity: O(m*n)
#Space complexity: O(min(m,n))
#Code ran successfully on leetcode
#No issues faced while developing the code

import collections
class Solution(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        #finding the number of rows and columns
        m=len(grid)
        n=len(grid[0])
        #Taking all the directions and initializing the count variable
        dirs=[[0,1],[0,-1],[1,0],[-1,0]]
        count=0
        for i in range(0,m):
            for j in range(0,n):
                #If the value of the cell is 1, we will increase
                #the count by 1 and we will update that value to 0 and
                #We will add the indexes of the adjacent cells into the queue
                #if their value is 1
                if(grid[i][j]=='1'):
                    count+=1
                    q=collections.deque()
                    q.append([i,j])
                    grid[i][j]='0'
                    while(len(q)):
                        curr=q.popleft()
                        for d in dirs:
                            nr=curr[0]+d[0]
                            nc=curr[1]+d[1]
                            if(nr>=0 and nc>=0 and nr<m and nc<n and grid[nr][nc]=='1'):
                                q.append([nr,nc])
                                grid[nr][nc]='0'
        #Finally returning the count of number of islands
        return count
