class Solution(object):
    def __init__(self):
        #Since I want to travel to all the neighbours, I will be making a directions array
        self.dirs=[[-1,0], [1,0], [0,-1], [0,1]] #UP, DOWN, LEFT, RIGHT
  
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        
        '''We can use BFS or DFS. Check for the connected the 1s and make all the visited 1s as 0s so that we do not visit them again and increase the count+1.'''

        #BFS 
        #Time Complexity: O(2mn) ---> O(mn)
        #Space Complexity: O(min(mn)) ---> If the BFS is returning in the diagonal then the space complexity will be min(m,n) because that many number of nodes will be there present in the queue
        
        #Edge case
        if len(grid)==0:
            return 0
        
        m=len(grid) #ROWS
        n=len(grid[0]) #COLS
        
        #count of island
        count=0
        
        queue=deque()
        
        for i in range(m):
            for j in range(n):
                #Check if we have encountered 1 and call dfs on it
                if grid[i][j]=="1":
                    queue.append([i,j])
                    count+=1
                    grid[i][j]="0"
                    while len(queue) !=0:
                        node=queue.popleft()
                        cr=node[0]
                        cc=node[1]
                        #Go over all the neighbors
                        for d in self.dirs:
                            nr=cr+d[0]
                            nc=cc+d[1]
                            #bound check
                            if nr >=0 and nc >=0 and nr < m and nc <n and grid[nr][nc]=='1':
                                #put the neighbours in the queue and mark them 0
                                queue.append([nr,nc])
                                grid[nr][nc]="0"
        return count
