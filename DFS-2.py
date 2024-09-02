# DFS-2

## Problem1 (https://leetcode.com/problems/number-of-islands/)

from queue import Queue
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if grid == None or len(grid) == 0:
            return 0
        q = Queue()
        count = 0
        m = len(grid)
        n = len(grid[0])
        dirs = [[-1,0],[1,0],[0,-1],[0,1]] # U D L R
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    count = count + 1
                    q.put([i,j])
                    grid[i][j] = '2'
                    while not q.empty():
                        curr = q.get()
                        for Dir in dirs:
                            nr = curr[0] + Dir[0]
                            nc = curr[1] + Dir[1]
                            if nr >= 0 and nr < m and nc >= 0 and nc < n and grid[nr][nc] == '1':
                                grid[nr][nc] = '2'
                                q.put([nr, nc])
        return count
# TC = O(m*n), SC = O(m+n)

## Problem2 (https://leetcode.com/problems/decode-string/)

class Solution:
    i =0 # declare only for solution 2
    def decodeString(self, s: str) -> str:
#2. Recursive solution
        if s == None or len(s) == 0:
            return ""
        currStr =[]
        num = 0
        while self.i < len(s):
            c= s[self.i]
            if c>='0' and c <= '9':
                self.i = self.i +1
                num = num *10 + int(c)
            elif c == '[':
                self.i = self.i+1
                decoded = self.decodeString(s)
                newStr = []
                for i in range(num):
                    newStr.append("".join(decoded))
                currStr.append("".join(newStr))
                num = 0
            elif c == ']':
                self.i = self.i+1
                return "".join(currStr)                
            else:
                self.i = self.i+1
                currStr.append(c)
        return "".join(currStr)
                
#1. DFS based solution (iterative solution)
        if s == None or len(s) == 0:
            return ""
        currStr = []
        strStack = []
        numStack =[]
        num = 0
        for i in range(len(s)):
            c = s[i]
            if c>='0' and c <= '9':
                num = num*10 + int(c)
            elif c == '[':
                strStack.append("".join(currStr))
                numStack.append(num)
                num = 0
                currStr.clear()
            elif c == ']':
                times = numStack.pop()
                newStr = []
                for i in range(times):
                    newStr.append("".join(currStr))
                currStr.clear()
                currStr.append(strStack.pop()+"".join(newStr))
            else:
                currStr.append(c)
        return "".join(currStr)      