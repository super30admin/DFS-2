class Solution(object):
    def __init__(self):
        #Since I want to travel to all the neighbours, I will be making a directions array
        self.dirs=[[-1,0], [1,0], [0,-1], [0,1]] #UP, DOWN, LEFT, RIGHT
        
    def dfs(self, grid, i, j, m,n):
        #base case
        if i<0 or j<0 or i>=m or j >= n or grid[i][j]=="0":
            return
        #logic
        #Make the visited as 0
        grid[i][j]="0"
        #Go over the directions
        for direction in self.dirs:
            nr=i+direction[0]
            nc=j+direction[1]
            #Call dfs on the neighbour
            self.dfs(grid, nr, nc, m, n)
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        
        '''We can use BFS or DFS. Check for the connected the 1s and make all the visited 1s as 0s so that we do not visit them again and increase the count+1.'''

        #DFS 
        #Time Complexity: O(2mn) ---> O(mn)
        #Space Complexity: O(mn) ---> In recursive stack mn nodes will be touched
        
        #Edge case
        if len(grid)==0:
            return 0
        
        m=len(grid) #ROWS
        n=len(grid[0]) #COLS
        
        #count of island
        count=0
        
        for i in range(m):
            for j in range(n):
                #Check if we have encountered 1 and call dfs on it
                if grid[i][j]=="1":
                    count+=1
                    self.dfs(grid, i, j,m, n)
        return count
