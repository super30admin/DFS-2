#Time complexity: O(m*n)
#Space complexity: O(min(m,n))
#Works on leetcode: yes
#Approach: We traverse through the grid and start a stack every time we get 1. Now till that stacks last, we pop the location
#and set the location to 0 and see if it's neighnouring cells are withing bound and 1. If they are we add it to the stack.
#Once the stack is empty, we get one more island for our count. 
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        count = 0
        for r in range(len(grid)):
            for c in range(len(grid[0])):
                if grid[r][c]=="1":
                    stack = [[r,c]]
                    while stack:
                        a,b = stack.pop()
                        grid[a][b]=0
                        for i,j in {(a,b+1),(a,b-1),(a-1,b),(a+1,b)}:
                            if 0<=i<len(grid) and 0<=j<len(grid[0]) and grid[i][j]=="1":
                                    stack.append([i,j])
                    count+=1
        return count