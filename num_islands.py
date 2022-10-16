#time complexity:
#space complexity:
#passed all cases on LeetCode:
#difficulty faced:
# comments: in the code
#https://leetcode.com/problems/number-of-islands/description/
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:

        
        m = len(grid)
        n = len(grid[0])
        
        #print("rows,cols",m,n)
        dirs = [[0,-1],[0,1],[-1,0],[1,0]]
        count = 0

        #1st need to find the place to start bfs from
        #this is done by finding a 1 in the matrix

        #when we find a 1 we start bfs then and there since we traverse thru adjacent or connected
        #1s which are part of same island
        #so we increment the count only when we find another new one
        #after completing all the bfs of prev
        for i in range(m):
            for j in range(n):
                if grid[i][j] == "1":
                    count += 1
                    #print("count at this i,j:",i,j,count)
                    q = []
                    q.append([i,j])

                    #we added above 1 to q and started bfs
                    #we change all the visited nodes to 0 so that we
                    #dont go to them again from other nodes
                    while q:
                        #make sure this for loop has diff index variable
                        for ii in range(len(q)):
                            curr = q.pop(0)
                            for dir1 in dirs:
                                nr = curr[0] + dir1[0]
                                nc = curr[1] + dir1[1]
                                #print("nr,nc:",nr,nc)
                                if (nr>=0 and nr < m and nc >=0 and nc < n and grid[nr][nc] == "1"):
                                    grid[nr][nc] = "0"
                                    #print("changed these nr,nc:",nr,nc)
                                    q.append([nr,nc])
                    
        return count



