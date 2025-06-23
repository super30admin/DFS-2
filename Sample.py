##problem 1
#Time Complexity : 0(N2)
# Space Complexity : 0(N)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no
# Your code here along with comments explaining your approach: used dfs
class Solution:   
    def numIslands(self, grid: List[List[str]]) -> int:
        visited = set()
        islands = 0
        dirs = [(0,1),(0,-1),(-1,0),(1,0)]
        def dfs(i,j):
            if i < 0 or i >= len(grid) or j < 0 or j >= len(grid[0]) or grid[i][j] == '0' or (i,j) in visited:
                return 
            visited.add((i,j))
            for r,c in dirs:
                newrow = i + r
                newcol = j + c
                dfs(newrow,newcol)
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == '1' and (i,j) not in visited:
                    print("yo")
                    islands+=1
                    dfs(i,j)
        return islands

##problem 2
#Time Complexity : 0(N)
# Space Complexity : 0(N)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no
# Your code here along with comments explaining your approach: used dfs and stack

class Solution:
    def decodeString(self, s: str) -> str:
        currnum = 0 
        currstr = ""
        stack = []

        for let in s:

            if let.isdigit():
                currnum = currnum * 10 + int(let)

            elif let == '[':
                stack.append((currnum,currstr))
                currnum = 0
                currstr = ""


            elif let == ']':
                prevnum,prevstr = stack.pop()
                currstr = prevstr + (prevnum * currstr) 

            else:
                currstr += let 
        return currstr


      