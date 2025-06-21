# // Time Complexity :O(MXN)
# // Space Complexity :O(Max(M,N)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach
# we are doing simple DFS here with a for loop we try to find 1, we increase count and then will make zeros connecting neighbours





class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        count=0
        def dfs(mat,r,c,maxr,maxc):
            #base
            if -1<r<maxr and -1<c<maxc and mat[r][c]=="0":
                return 
            
            #logic
            if -1<r<maxr and -1<c<maxc:
                if mat[r][c]=="1":
                    mat[r][c]="0"
                dfs(mat,r,c+1,maxr,maxc)
                dfs(mat,r,c-1,maxr,maxc)
                dfs(mat,r+1,c,maxr,maxc)
                dfs(mat,r-1,c,maxr,maxc)
        maxr,maxc=len(grid),len(grid[0])
        for i in range(maxr):
            for j in range(maxc):
                # print(count,grid[i][j])
                if grid[i][j]=="1":
                    count+=1
                    dfs(grid,i,j,maxr,maxc)
        return count
            
                

