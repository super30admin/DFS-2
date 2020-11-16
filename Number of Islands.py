# Time Complexity:- O(m*n)
# Space Complexity:- O(m*n)
# Approach:- BFS on the matrix starting from a 1 in the matrix and keep adding to the queue and 
# change the value in the matrix to 0. The number of islands in the matrix is equal to the number of time we have to do BFS in the matrix
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        dirs=[[0,1],[1,0],[0,-1],[-1,0]]
        def bfs(grid,i,j):
            while(q):
                m,n=q.popleft()
                for i,j in dirs:
                    o=m+i
                    p=n+j
                    if 0<=o<len(grid) and 0<=p<len(grid[0]) and grid[o][p]=="1":
                        grid[o][p]=0
                        q.append((o,p))
        res=0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j]=="1":
                    grid[i][j]=0
                    q=collections.deque([])
                    q.append((i,j))
                    bfs(grid,i,j)
                    res+=1
        return res