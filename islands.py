# // Time Complexity :O(mn)
# // Space Complexity :O(mn)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No

# BFS-didnt get to working soln. DFS- working perfectly fine. In DFS- for each 1 in the grid we are going to count++ and do dfs for that 1 we encounter
# the each 1 encountered is mutatted to 0 so that it doesnt get counted again in the dfs 

class Solution(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        # # bfs - somethings wrong timeO(mn) space(O(min(m,n)))
        # if(len(grid)==0): return 0
        # m=len(grid)
        # n=len(grid[0])
        # dirs=[[0,1],[1,0],[0,-1],[-1,0]]
        # count=0
        # q=[]
        # for i in range(m):
        #     for j in range(n):
        #         if(grid[i][j]=="1"):
        #             count+=1
        #             q.append([i,j])
        #             grid[i][j]="0"

        #             while(len(q)>0):
        #                 size=len(q)
        #                 curr=q.pop(0)
        #                 for dir in dirs:
        #                     nr=curr[0]+dir[0]
        #                     nc=curr[1]+dir[1]
        #                     if(nc>=0 and nr>=0 and nr<m and nc<n and grid[nr][nc]==1):
        #                         q.append([nr,nc])
        #                         grid[nr][nc]="0"
        #            
                            

        # return count

        # dfs: works time-O(mn) space O(mn)
        def dfs(grid, i, j, dirs, m , n):
            if(i<0 or j<0 or i>=m or j>=n or grid[i][j]=="0"):
                return
            # logic
            grid[i][j]="0"
            for dir in dirs:
                nr=i+dir[0]
                nc=j+dir[1]
                dfs(grid,nr,nc,dirs,m,n)

        if(len(grid)==0): return 0
        m=len(grid)
        n=len(grid[0])
        dirs=[[0,1],[1,0],[0,-1],[-1,0]]
        count=0
        for i in range(m):
            for j in range(n):
                if(grid[i][j]=="1"):
                    count+=1
                    dfs(grid, i, j, dirs, m ,n)
        

        return count