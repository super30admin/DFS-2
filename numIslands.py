# Time Complexity: O(mn)
# Space Complexity: O(mn)

class Solution(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        # queue=collections.deque()
        # m=len(grid)
        # n=len(grid[0])
        # dir=[[0,1],[0,-1],[-1,0],[1,0]]
        # count=0
        # for i in range(m):
        #     for j in range(n):
        #         if grid[i][j]=="1":
        #             queue.append([i,j])
        #             grid[i][j]="0"
        #             while queue:
        #                 curr=queue.popleft()
        #                 for d in dir:
        #                     newRow=curr[0]+d[0]
        #                     newCol=curr[1]+d[1]
        #                     if 0<=newRow<m and 0<=newCol<n and grid[newRow][newCol]=="1":
        #                         queue.append([newRow,newCol])
        #                         grid[newRow][newCol]="0"
        #             count+=1
        # return count


        m=len(grid)
        n=len(grid[0])
        directions=[[0,1],[0,-1],[-1,0],[1,0]]
        count=0
        def helper(grid,i, j, m,n,directions):
            if i<0 or i>=m or j<0 or j>=n or grid[i][j]=="0":
                    return
            grid[i][j]="0"
            for d in directions:
                nr=i+d[0]
                nc=j+d[1]
                helper(grid,nr,nc,m,n,directions)

        for i in range(m):
            for j in range(n):
                if grid[i][j]=="1":
                    count+=1
                    helper(grid,i,j,m,n, directions)
        return count
