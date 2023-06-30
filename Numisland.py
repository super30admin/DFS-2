# Time Complexity : O(mxn)
# Space Complexity : O(mxn)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA

# Approach is to iterate using bfs and find the connected 1's to make it as 0 then increase the count for every traversal.

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        dirs=[[0,1],[0,-1],[1,0],[-1,0]]
        m=len(grid)
        n=len(grid[0])
        c=0
        for i in range(m):
            for j in range(n):
                if(grid[i][j]=="1"):
                    c+=1
                    q=deque()
                    grid[i][j]="0"
                    q.append([i,j])
                    while(len(q)):
                        curr=q.popleft()
                        for dir in dirs:
                            nr=dir[0]+curr[0]
                            nc=dir[1]+curr[1]
                            if(nr>=0 and nc>=0 and nr<m and nc<n and grid[nr][nc]=="1"):
                                grid[nr][nc]="0"
                                q.append([nr,nc])
        return c