Approach : DFS ==> Drawback ==> Space is O(M*N)
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid:
            return 0
        rows = len(grid)
        cols = len(grid[0])
        count = 0
        
        def helper(i,j):
            if 0<=i<rows and 0<=j<cols and grid[i][j] == "1":
                grid[i][j] = "0"
                for a,b in [[i+1, j], [i,j+1], [i-1,j], [i,j-1]]:
                    helper(a,b)
            return 
        for i in range(rows):
            for j in range(cols):
                if grid[i][j] == "1":
                    helper(i,j)
                    count+=1
        return count
    
    
#Time Complexity : O(M*N)
#Space Complexity : O(M*N)

Approach : BFS ==> Advantage ==> Space is O(min(M,N))

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid:
            return 0
        rows = len(grid)
        cols = len(grid[0])
        count = 0
        
        def helper(i,j):
            queue = deque([(i,j)])
            while queue:
                a,b = queue.popleft()
               
                for x, y in [[a+1, b], [a,b+1], [a-1,b],[a,b-1]]:
                    if 0<=x<rows and 0<=y<cols and grid[x][y] == "1":
                        grid[x][y] = "0"
                        queue.append((x,y))
            return 
        for i in range(rows):
            for j in range(cols):
                if grid[i][j] == "1":
                    grid[i][j] = "0"
                    helper(i,j)
                    count+=1
        print(grid)
        return count
    
    
#Time Complexity : O(M*N)
#Space Complexity : O(min(M,N))